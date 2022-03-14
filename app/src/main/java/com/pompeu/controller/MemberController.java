package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.MemberDao;
import com.pompeu.domain.Member;

@RestController 
public class MemberController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  MemberDao memberDao;

  @RequestMapping("/member/list")
  public Object list() {
    return memberDao.findAll();
  }

  @RequestMapping("/member/add")
  public Object add(Member member) {
    return memberDao.insert(member);
  }


  @RequestMapping("/member/get")
  public Object get(int no) {
    Member member = memberDao.findByNo(no);
    if (member == null) {
      return "";
    }
    return member;
  }

  @RequestMapping("/member/update")
  public Object update(Member member) {
    return memberDao.update(member);
  }

  @RequestMapping("/member/delete")
  public Object delete(int no) {
    return memberDao.delete(no);
  }

}
