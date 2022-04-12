package com.pompeu.user.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Member;
import com.pompeu.user.main.service.UserMainService;

@RestController 
public class UserMainController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UserMainController 객체를 만들 때 UserMainDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  UserMainService userMainService;

  @RequestMapping("/userMain/list")
  public Object list() {
    return userMainService.list();
  }

  @RequestMapping("/userMain/add")
  public Object add(Member member) {
    return userMainService.add(member);
  }

  @RequestMapping("/userMain/get")
  public Object get(int no) {
    Member member = userMainService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/userMain/update")
  public Object update(Member member) {
    return userMainService.update(member);
  }

  @RequestMapping("/userMain/delete")
  public Object delete(int no) {
    return userMainService.delete(no);
  }

  @RequestMapping("/userMain/topLecture")
  public Object findTopLecture() {
    return userMainService.findTopLecture();
  }

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

}