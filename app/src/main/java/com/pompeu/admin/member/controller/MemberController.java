package com.pompeu.admin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.member.dao.MemberDao;
import com.pompeu.admin.member.domain.Member;

@RestController
public class MemberController {

  @Autowired
  MemberDao memberDao;

  @RequestMapping("/member/list")
  public Object list() {
    return memberDao.findAll();
  }

  @RequestMapping("/member/get")
  public Object get(int no) {
    Member member = memberDao.findByNo(no);
    if (member == null) {
      return "";
    }
    return member;
  }

  @RequestMapping("/member/findCount")
  public Object memberList() {
    return memberDao.findCount();
  }

  @RequestMapping("/member/srchMember")
  public Object srchMember(Member member) {

    System.out.println("srchMember : " + member.getNickName());
    System.out.println("srchMember : " + member.getPhone());
    System.out.println("srchMember : " + member.getEmail());
    System.out.println("srchMember : " + member.getMemberTypeNo());

    return memberDao.srchMember(member);
  }

  @RequestMapping("/member/memberRegi")
  public Object memberRegi(Member member) {

    System.out.println("memberRegi : " + member.getName());
    System.out.println("memberRegi : " + member.getEmail());
    System.out.println("memberRegi : " + member.getPassword());
    System.out.println("memberRegi : " + member.getPhone());
    System.out.println("memberRegi : " + member.getNickName());
    System.out.println("memberRegi : " + member.getBirth());
    System.out.println("memberRegi : " + member.getGender());

    return memberDao.memberRegi(member);
  }


}
