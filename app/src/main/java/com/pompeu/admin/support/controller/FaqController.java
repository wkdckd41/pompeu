package com.pompeu.admin.support.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.support.service.FaqService;
import com.pompeu.domain.Faq;

@RestController 
public class FaqController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(FaqController.class);

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  FaqService faqService;

  @RequestMapping("/faq/list")
  public Object list(Faq faq) {
    log.info("memberTypeNo : " + faq.getMemberType());
    log.info("pageNo : " + faq.getPageNo());
    log.info("pageSize : " + faq.getPageSize());
    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (faq.getPageSize() < 6 || faq.getPageSize() > 100) {
        faq.setPageSize(6);
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int faqSize = faqService.size(faq); 
    totalPageSize = faqSize / faq.getPageSize(); // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((faqSize % faq.getPageSize()) > 0) {
      totalPageSize++;
    }


    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (faq.getPageNo() < 1 || faq.getPageNo() > totalPageSize) {// pageNo 유효성 검증
        faq.setPageNo(1);
      }
    } catch (Exception e) {}

    log.info("totalPageSize =" + totalPageSize);
    log.info("PageNo =" + faq.getPageNo());
    log.info("PageSize =" + faq.getPageSize());

    ResultMap resultMap = new ResultMap();
    resultMap.setPageNo(faq.getPageNo());
    resultMap.setPageSize(faq.getPageSize());
    resultMap.setTotalPageSize(totalPageSize);
    resultMap.setFaqList(faqService.list(faq));


    return resultMap;  
  }

  @RequestMapping("/faq/userList")
  public Object userList(Faq faq) {
    log.info("memberTypeNo : " + faq.getMemberType());
    log.info("pageNo : " + faq.getPageNo());
    log.info("pageSize : " + faq.getPageSize());
    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (faq.getPageSize() < 6 || faq.getPageSize() > 100) {
        faq.setPageSize(6);
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int faqSize = faqService.size(faq); 
    totalPageSize = faqSize / faq.getPageSize(); // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((faqSize % faq.getPageSize()) > 0) {
      totalPageSize++;
    }


    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (faq.getPageNo() < 1 || faq.getPageNo() > totalPageSize) {// pageNo 유효성 검증
        faq.setPageNo(1);
      }
    } catch (Exception e) {}

    log.info("totalPageSize =" + totalPageSize);
    log.info("PageNo =" + faq.getPageNo());
    log.info("PageSize =" + faq.getPageSize());

    ResultMap resultMap = new ResultMap();
    resultMap.setPageNo(faq.getPageNo());
    resultMap.setPageSize(faq.getPageSize());
    resultMap.setTotalPageSize(totalPageSize);
    resultMap.setFaqList(faqService.list(faq));


    return resultMap;  
  }

  @RequestMapping("/faq/add")
  public Object add(Faq faq) {
    int count = 0;
    if (faq.getMemberTypeNo()==3) {
      faq.setMemberTypeNo(1);
      count += faqService.add(faq);
      faq.setMemberTypeNo(2);
      count += faqService.add(faq);
    }else {
      count = faqService.add(faq);
    }
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }


  @RequestMapping("/faq/get")
  public Object get(int no) {
    Faq faq = faqService.get(no);
    if (faq == null) {
      return "";
    }
    return faq;
  }

  @RequestMapping("/faq/update")
  public Object update(Faq faq) {
    System.out.println(faq.getNo());
    System.out.println(faq.getMemberTypeNo());
    System.out.println(faq.getAsk());
    System.out.println(faq.getAnswer());
    int count = faqService.update(faq);
    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }




  @RequestMapping("/faq/delete")
  public Object delete(int no) {
    return faqService.delete(no);
  }

  @RequestMapping("/faq/deleteAll")
  public Object deleteAll(String memberTypeNo) {
    System.out.println("memberTypeNo : " + memberTypeNo);

    int count = faqService.deleteAll(memberTypeNo);

    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }

  }

}
