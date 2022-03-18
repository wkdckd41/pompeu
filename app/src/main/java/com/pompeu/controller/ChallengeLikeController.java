package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.ChallengeLikeDao;
import com.pompeu.domain.ChallengeLike;


@RestController 
public class ChallengeLikeController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UsersController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  ChallengeLikeDao challengeLikeDao;

  @RequestMapping("/challengeLike/list")
  public Object list() {
    return challengeLikeDao.findAll();
  }

  @RequestMapping("/challengeLike/add")
  public Object add(ChallengeLike challengelike) {
    return challengeLikeDao.insert(challengelike);
  }


  @RequestMapping("/challengeLike/get")
  public Object get(ChallengeLike challengelike) {
    ChallengeLike like = challengeLikeDao.findByNo(challengelike);
    if (like == null) {
      return "";
    }
    return like;
  }

  @RequestMapping("/challengeLike/update")
  public Object update(ChallengeLike challengelike) {
    return challengeLikeDao.update(challengelike);
  }

  @RequestMapping("/challengeLike/delete")
  public Object delete(ChallengeLike challengelike) {
    return challengeLikeDao.delete(challengelike);
  }

}
