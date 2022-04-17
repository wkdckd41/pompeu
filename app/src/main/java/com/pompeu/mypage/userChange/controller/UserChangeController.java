package com.pompeu.mypage.userChange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Member;
import com.pompeu.mypage.userChange.service.UserChangeService;

@RestController 
public class UserChangeController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 UserChangeDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  UserChangeService userChangeService;

  @RequestMapping("/userChange/list")
  public Object list() {
    return userChangeService.list();
  }

  @RequestMapping("/userChange/add")
  public Object add(Member member) {
    return userChangeService.add(member);
  }

  @RequestMapping("/userChange/get")
  public Object get(int no) {
    Member member = userChangeService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/userChange/update")
  public Object update(Member member) {
    return userChangeService.update(member);
  }

  @RequestMapping("/userChange/delete")
  public Object delete(int no) {
    return userChangeService.delete(no);
  }

}