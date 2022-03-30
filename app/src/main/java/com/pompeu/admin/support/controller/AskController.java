package com.pompeu.admin.support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.support.dao.AskDao;
import com.pompeu.domain.Ask;

@RestController 
public class AskController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 AskController 객체를 만들 때 AskDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  AskDao askService;

  @RequestMapping("/ask/list")
  public Object list() {
    return askService.findAll();
  }

  @RequestMapping("/ask/add")
  public Object add(Ask ask) {
    return askService.insert(ask);
  }


  @RequestMapping("/ask/get")
  public Object get(int no) {
    Ask ask = askService.findByNo(no);
    if (ask == null) {
      return "";
    }
    return ask;
  }

  @RequestMapping("/ask/update")
  public Object update(Ask ask) {
    return askService.update(ask);
  }


  @RequestMapping("/ask/delete")
  public Object delete(int no) {
    return askService.delete(no);
  }
}
