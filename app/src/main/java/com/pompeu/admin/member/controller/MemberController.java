package com.pompeu.admin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.member.service.MemberService;
import com.pompeu.domain.Member;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/list")
  public Object list() {
    return memberService.findAll();
  }

  @RequestMapping("/member/get")
  public Object get(int no) {
    Member member = memberService.findByNo(no);
    if (member == null) {
      return "";
    }
    return member;
  }

  @RequestMapping("/member/findCount")
  public Object memberList() {
    return memberService.findCount();
  }

  @RequestMapping("/member/srchMember")
  public Object srchMember(Member member) {

    System.out.println("srchMember : " + member.getNickName());
    System.out.println("srchMember : " + member.getPhone());
    System.out.println("srchMember : " + member.getEmail());
    System.out.println("srchMember : " + member.getMemberTypeNo());

    return memberService.srchMember(member);
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

    return memberService.memberRegi(member);
  }


}
