package com.pompeu.admin.support.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.support.service.AskService;
import com.pompeu.domain.Ask;
import com.pompeu.domain.Member;

@RestController 
public class AskController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(AskController.class);

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 AskController 객체를 만들 때 AskDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  AskService askService;

  @RequestMapping("/ask/list")
  public Object list(Ask ask) {
    log.info("A");
    log.info("ask.get = " + ask.getMemberNo());

    log.info("memberTypeNo : " + ask.getMemberTypeNo()); //컨트롤러 까지만 온 데이터
    log.info("pageNo : " + ask.getPageNo());
    log.info("pageSize : " + ask.getPageSize());
    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (ask.getPageSize() < 8 || ask.getPageSize() > 100) {
        ask.setPageSize(8);
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int askSize = askService.size(ask); 
    totalPageSize = askSize / ask.getPageSize(); // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((askSize % ask.getPageSize()) > 0) {
      totalPageSize++;
    }

    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (ask.getPageNo() < 1 || ask.getPageNo() > totalPageSize) {// pageNo 유효성 검증
        ask.setPageNo(1);
      }
    } catch (Exception e) {}

    log.info("totalPageSize =" + totalPageSize);
    log.info("PageNo =" + ask.getPageNo());
    log.info("PageSize =" + ask.getPageSize());

    ResultMap resultMap = new ResultMap();
    resultMap.setPageNo(ask.getPageNo());
    resultMap.setPageSize(ask.getPageSize());
    resultMap.setTotalPageSize(totalPageSize);

    resultMap.setAskList(askService.userList(ask));

    return resultMap; 
  }



  @RequestMapping("/ask/user-list")
  public Object userList(@AuthenticationPrincipal Member member, Ask ask) {
    log.info("B");
    //  int no = member.getNo();
    //  log.info("no = " + no);
    ask.setMemberNo(member.getNo());
    log.info("ask.get = " + ask.getMemberNo());

    log.info("memberTypeNo : " + ask.getMemberTypeNo()); //컨트롤러 까지만 온 데이터
    log.info("pageNo : " + ask.getPageNo());
    log.info("pageSize : " + ask.getPageSize());
    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (ask.getPageSize() < 8 || ask.getPageSize() > 100) {
        ask.setPageSize(8);
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int askSize = askService.size(ask); 
    totalPageSize = askSize / ask.getPageSize(); // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((askSize % ask.getPageSize()) > 0) {
      totalPageSize++;
    }

    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (ask.getPageNo() < 1 || ask.getPageNo() > totalPageSize) {// pageNo 유효성 검증
        ask.setPageNo(1);
      }
    } catch (Exception e) {}

    log.info("totalPageSize =" + totalPageSize);
    log.info("PageNo =" + ask.getPageNo());
    log.info("PageSize =" + ask.getPageSize());

    ResultMap resultMap = new ResultMap();
    resultMap.setPageNo(ask.getPageNo());
    resultMap.setPageSize(ask.getPageSize());
    resultMap.setTotalPageSize(totalPageSize);

    resultMap.setAskList(askService.userList(ask));

    return resultMap;  

  }

  @RequestMapping("/ask/add")
  public Object add(Ask ask) {

    log.info("AnswerContent = "+ ask.getAnswerContent());

    return askService.add(ask);  
  };

  @RequestMapping("/ask/user-add")
  public Object userAdd(Ask ask, @AuthenticationPrincipal Member member) {
    log.info("askAdd.....");
    ask.setMemberNo(member.getNo());
    log.info(member.getNo());
    log.info("========");
    int count = askService.userAdd(ask);
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/ask/get")
  public Object get(int no) {
    Ask ask = askService.get(no);
    if (ask == null) {
      return "";
    }
    return ask;
  }


  @RequestMapping("/ask/update")
  public Object update(Ask ask) {
    log.info("ask_no =" + ask.getNo());
    log.info("AnswerContent = "+ ask.getAnswerContent());

    int count = askService.update(ask);
    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }


  @RequestMapping("/ask/delete")
  public Object delete(int no) {
    return askService.delete(no);
  }

  @RequestMapping("/ask/deleteAll")
  public Object deleteAll(String memberNo) {
    log.info("memberNo : " + memberNo);

    int count = askService.deleteAll(memberNo);

    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }

  }

}
