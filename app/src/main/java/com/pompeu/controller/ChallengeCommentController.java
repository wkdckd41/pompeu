package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.ChallengeCommentDao;
import com.pompeu.domain.ChallengeComment;

@RestController 
public class ChallengeCommentController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 NoticeController 객체를 만들 때 NoticeDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  ChallengeCommentDao challengeCommentDao;

  @RequestMapping("/challengeComment/list")
  public Object list() {
    return challengeCommentDao.findAll();
  }

  @RequestMapping("/challengeComment/add")
  public Object add(ChallengeComment ChallengeComment) {
    return challengeCommentDao.insert(ChallengeComment);
  }


  @RequestMapping("/challengeComment/get")
  public Object get(int no) {
    ChallengeComment challengeComment = challengeCommentDao.findByNo(no);
    if (challengeComment == null) {
      return "";
    }
    return challengeComment;
  }

  @RequestMapping("/challengeComment/update")
  public Object update(ChallengeComment challengeComment) {
    return challengeCommentDao.update(challengeComment);
  }

  @RequestMapping("/challengeComment/delete")
  public Object delete(int no) {
    return challengeCommentDao.delete(no);
  }


}
