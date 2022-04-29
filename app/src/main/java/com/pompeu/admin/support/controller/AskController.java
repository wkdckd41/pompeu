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
    return askService.list(ask);
  }



  @RequestMapping("/ask/user-list")
  public Object userList(@AuthenticationPrincipal Member member, Ask ask) {

    //  int no = member.getNo();
    //  log.info("no = " + no);

    ask.setMemberNo(member.getNo());

    log.info("ask.get = " + ask.getMemberNo());

    return askService.userList(ask);
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
