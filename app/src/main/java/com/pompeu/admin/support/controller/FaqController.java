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
    return faqService.list(faq);
  }

  @RequestMapping("/faq/add")
  public Object add(Faq faq) {
    int count = faqService.add(faq);
    if (count == 1) {
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
