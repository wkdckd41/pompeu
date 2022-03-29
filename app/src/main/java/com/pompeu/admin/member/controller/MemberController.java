package com.pompeu.admin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.member.dao.MemberDao;
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
    return member != null ? member : "";
  }

  @RequestMapping("/member/update")
  public Object update(Member member) {
    return memberDao.update(member);
  }

  @RequestMapping("/member/delete")
  public Object delete(int no) {
    return memberDao.delete(no);
  }

  @RequestMapping("/member/findCount")
  public Object memberList() {
    return memberDao.findCount();
  }

  @RequestMapping("/member/srchMember")
  public Object srchMember(Member member) {

    System.out.println("srchMember : " + member.getNo());
    System.out.println("srchMember : " + member.getName());
    System.out.println("srchMember : " + member.getPhone());
    System.out.println("srchMember : " + member.getEmail());

    System.out.println(memberDao.srchMember(member));
    return memberDao.srchMember(member);
  }


  @RequestMapping("/member/getClass")
  public Object getClass(int no) {
    return memberDao.findByNoClass(no);
  }

}