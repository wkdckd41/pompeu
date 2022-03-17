package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.ChallengeClaimDao;
import com.pompeu.domain.ChallengeClaim;

@RestController 
public class ChallengeClaimController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UsersController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  ChallengeClaimDao challengeClaimDao;

  @RequestMapping("/challengeClaim/list")
  public Object list() {
    return challengeClaimDao.findAll();
  }

  @RequestMapping("/challengeClaim/add")
  public Object add(ChallengeClaim challengeclaim) {
    return challengeClaimDao.insert(challengeclaim);
  }


  @RequestMapping("/challengeClaim/get")
  public Object get(ChallengeClaim challengeclaim) {
    ChallengeClaim claim = challengeClaimDao.findByNo(challengeclaim);
    if (claim == null) {
      return "";
    }
    return claim;
  }

  @RequestMapping("/challengeClaim/update")
  public Object update(ChallengeClaim challengeclaim) {
    return challengeClaimDao.update(challengeclaim);
  }

  @RequestMapping("/challengeClaim/delete")
  public Object delete(ChallengeClaim challengeclaim) {
    return challengeClaimDao.delete(challengeclaim);
  }

}
