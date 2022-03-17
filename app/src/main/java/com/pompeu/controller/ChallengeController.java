package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.ChallengeDao;
import com.pompeu.domain.Challenge;

@RestController 
public class ChallengeController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 NoticeController 객체를 만들 때 NoticeDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  ChallengeDao challengeDao;

  @RequestMapping("/challenge/list")
  public Object list() {
    return challengeDao.findAll();
  }

  @RequestMapping("/challenge/add")
  public Object add(Challenge challenge) {
    return challengeDao.insert(challenge);
  }


  @RequestMapping("/challenge/get")
  public Object get(int no) {
    Challenge challenge = challengeDao.findByNo(no);
    if (challenge == null) {
      return "";
    }
    return challenge;
  }

  @RequestMapping("/challenge/update")
  public Object update(Challenge challenge) {
    return challengeDao.update(challenge);
  }

  @RequestMapping("/challenge/delete")
  public Object delete(int no) {
    return challengeDao.delete(no);
  }

}
