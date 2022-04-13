package com.pompeu.creator.userAsk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.creator.userAsk.service.UserAskService;

@RestController 
public class UserAskController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(UserAskController.class);

  @Autowired
  UserAskService userAskService;

  @RequestMapping("/userAsk/list")
  public Object list() {
    log.debug("게실물 목록 조회!");
    return userAskService.list();
  }
}