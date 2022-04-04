package com.pompeu.admin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.member.service.MemberService;
import com.pompeu.domain.Member;

@RestController 
public class MemberController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  MemberService memberService;

  @RequestMapping("/member/list")
  public Object list() {
    return memberService.list();
  }

  @RequestMapping("/member/add")
  public Object add(Member member) {
    return memberService.add(member);
  }

  @RequestMapping("/member/get")
  public Object get(int no) {
    Member member = memberService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/member/update")
  public Object update(Member member) {
    return memberService.update(member);
  }

  @RequestMapping("/member/delete")
  public Object delete(int no) {
    return memberService.delete(no);
  }

  @RequestMapping("/member/findCount")
  public Object memberList() {
    return memberService.memberList();
  }

  @RequestMapping("/member/srchMember")
  public Object srchMember(Member member) {

    return memberService.srchMember(member);
  }


  @RequestMapping("/member/getLecture")
  public Object getLecture(int no) {
    return memberService.getLecture(no);
  }

  @RequestMapping("/member/creatorLecture")
  public Object creatorLecture(int no) {
    return memberService.creatorLecture(no);
  }

  @RequestMapping("/member/applyingLecture")
  public Object applyingLecture(int no) {
    return memberService.applyingLecture(no);
  }

}