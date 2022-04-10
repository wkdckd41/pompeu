package com.pompeu.admin.main.controller;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.main.service.AdminMainService;
import com.pompeu.domain.Member;

@RestController 
public class AdminMainController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 AdminMainController 객체를 만들 때 AdminMainDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  AdminMainService adminMainService;

  @RequestMapping("/adminMain/list")
  public Object list() {
    return adminMainService.list();
  }

  @RequestMapping("/adminMain/add")
  public Object add(Member member) {
    return adminMainService.add(member);
  }

  @RequestMapping("/adminMain/get")
  public Object get(int no) {
    Member member = adminMainService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/adminMain/update")
  public Object update(Member member) {
    return adminMainService.update(member);
  }

  @RequestMapping("/adminMain/delete")
  public Object delete(int no) {
    return adminMainService.delete(no);
  }

  @RequestMapping("/adminMain/memberStatus")
  public Object memberStatus() {
    return adminMainService.memberStatus();
  }

  @RequestMapping("/adminMain/lectureStatus")
  public Object lectureStatus() {
    return adminMainService.lectureStatus();
  }

  @RequestMapping("/adminMain/undoStatus")
  public Object[] undoStatus() {
    return new Object[] {adminMainService.undoStatusApply(), adminMainService.undoStatusClaim()};
  }

  @RequestMapping("/adminMain/memberSummary")
  public Object[] memberSummary() {
    Calendar now = Calendar.getInstance();
    int monthNow = now.get(Calendar.MONTH) +1;

    Object[] memsum = new Object[12];
    for (int i = 0; i < monthNow; i++) {
      memsum[i] = adminMainService.memberSummary(i+1);
    }
    return memsum;
  }

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