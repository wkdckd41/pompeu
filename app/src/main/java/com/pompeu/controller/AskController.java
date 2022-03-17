package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.AskDao;
import com.pompeu.domain.Ask;

@RestController 
public class AskController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 AskController 객체를 만들 때 AskDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  AskDao askDao;

  @RequestMapping("/ask/usersList")
  public Object list1() {
    return askDao.usersFindAll();
  }

  @RequestMapping("/ask/creatorList")
  public Object list2() {
    return askDao.creatorFindAll();
  }

  @RequestMapping("/ask/add")
  public Object add(Ask ask) {
    return askDao.insert(ask);
  }


  @RequestMapping("/ask/usersGet")
  public Object get1(int no) {
    Ask ask = askDao.usersFindByNo(no);
    if (ask == null) {
      return "";
    }
    return ask;
  }

  @RequestMapping("/ask/creatorGet")
  public Object get2(int no) {
    Ask ask = askDao.creatorFindByNo(no);
    if (ask == null) {
      return "";
    }
    return ask;
  }

  @RequestMapping("/ask/askUpdate")
  public Object update1(Ask ask) {
    return askDao.askUpdate(ask);
  }

  @RequestMapping("/ask/answerUpdate")
  public Object update2(Ask ask) {
    return askDao.answer(ask);
  }

  @RequestMapping("/ask/answerModifyUpdate")
  public Object update3(Ask ask) {
    return askDao.answerUpdate(ask);
  }

  @RequestMapping("/ask/delete")
  public Object delete(int no) {
    return askDao.delete(no);
  }

}
