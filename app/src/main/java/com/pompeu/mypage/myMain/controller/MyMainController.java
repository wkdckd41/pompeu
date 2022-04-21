package com.pompeu.mypage.myMain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Member;
import com.pompeu.mypage.myMain.service.MyMainService;

@RestController 
public class MyMainController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MyMainController 객체를 만들 때 MyMainDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  MyMainService myMainService;

  @RequestMapping("/myMain/list")
  public Object list() {
    return myMainService.list();
  }

  @RequestMapping("/myMain/add")
  public Object add(Member member) {
    return myMainService.add(member);
  }

  @RequestMapping("/myMain/get")
  public Object get(int no) {
    Member member = myMainService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/myMain/update")
  public Object update(Member member) {
    return myMainService.update(member);
  }

  @RequestMapping("/myMain/delete")
  public Object delete(int no) {
    return myMainService.delete(no);
  }
  //
  //  @RequestMapping("/adminMain/memberStatus")
  //  public Object memberStatus() {
  //    return adminMainService.memberStatus();
  //  }
  //
  //  @RequestMapping("/adminMain/lectureStatus")
  //  public Object lectureStatus() {
  //    return adminMainService.lectureStatus();
  //  }
  //
  //  @RequestMapping("/adminMain/undoStatus")
  //  public Object[] undoStatus() {
  //    return new Object[] {adminMainService.undoStatusApply(), adminMainService.undoStatusClaim()};
  //  }
  //
  //  @RequestMapping("/adminMain/memberSummary")
  //  public Object[] memberSummary() {
  //    Calendar now = Calendar.getInstance();
  //    int monthNow = now.get(Calendar.MONTH) +1;
  //
  //    Object[] memsum = new Object[12];
  //    for (int i = 0; i < monthNow; i++) {
  //      memsum[i] = adminMainService.memberSummary(i+1);
  //    }
  //    return memsum;
  //  }

  //  @RequestMapping("/member/findCount")
  //  public Object memberList() {
  //    return memberService.memberList();
  //  }
  //
  //  @RequestMapping("/member/srchMember")
  //  public Object srchMember(Member member) {
  //
  //    return memberService.srchMember(member);
  //  }
  //
  //
  //  @RequestMapping("/member/getLecture")
  //  public Object getLecture(int no) {
  //    return memberService.getLecture(no);
  //  }
  //
  //  @RequestMapping("/member/creatorLecture")
  //  public Object creatorLecture(int no) {
  //    return memberService.creatorLecture(no);
  //  }
  //
  //  @RequestMapping("/member/applyingLecture")
  //  public Object applyingLecture(int no) {
  //    return memberService.applyingLecture(no);
  //  }

}