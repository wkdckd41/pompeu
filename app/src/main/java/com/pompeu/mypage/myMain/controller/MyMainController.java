package com.pompeu.mypage.myMain.controller;

import java.io.File;
import java.io.FileInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  @RequestMapping("/myMain/myGoingLecture")
  public Object myGoingLecture(int no) {
    return myMainService.myGoingLecture(no);
  }

  @RequestMapping("/myMain/myWishLecture")
  public Object myWishLecture(int no) {
    return myMainService.myWishLecture(no);
  }

  @RequestMapping("/myMain/myGoingParty")
  public Object myGoingParty(int no) {
    return myMainService.myGoingParty(no);
  }

  @RequestMapping("/myMain/myWishParty")
  public Object myWishParty(int no) {
    return myMainService.myWishParty(no);
  }

  @RequestMapping("/myMain/imageLecture")
  public ResponseEntity<Resource> imageLecture(String filename) {

    try {
      // 다운로드할 파일의 입력 스트림 자원을 준비한다.
      File downloadFile = new File("./upload/lecture_image/" + filename); // 다운로드 상대 경로 준비
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); // 다운로드 파일의 실제 경로를 지정하여 입력 스트림 준비
      InputStreamResource resource = new InputStreamResource(fileIn); // 입력 스트림을 입력 자원으로 포장

      // HTTP 응답 헤더를 준비한다. (캐시를 막기 위한 헤더 설정)
      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");

      // 다운로드 파일명을 지정하고 싶다면 다음의 응답 헤더를 추가하라!
      // => 다운로드 파일을 지정하지 않으면 요청 URL이 파일명으로 사용된다.
      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

      return ResponseEntity.ok() // HTTP 응답 프로토콜에 따라 응답을 수행할 생성기를 준비한다.
          .headers(header) // 응답 헤더를 설정한다.
          .contentLength(downloadFile.length()) // 응답할 파일의 크기를 설정한다.
          .contentType(MediaType.APPLICATION_OCTET_STREAM) // 응답 콘텐트의 MIME 타입을 설정한다.
          .body(resource); // 응답 콘텐트를 생성한 후 리턴한다.

    } catch (Exception e) {
      //e.printStackTrace();
      System.out.println("요청한 파일이 없습니다.");
      return null;
    }
  }

  @RequestMapping("/myMain/imageParty")
  public ResponseEntity<Resource> imageParty(String filename) {

    try {
      // 다운로드할 파일의 입력 스트림 자원을 준비한다.
      File downloadFile = new File("./upload/party/" + filename); // 다운로드 상대 경로 준비
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); // 다운로드 파일의 실제 경로를 지정하여 입력 스트림 준비
      InputStreamResource resource = new InputStreamResource(fileIn); // 입력 스트림을 입력 자원으로 포장

      // HTTP 응답 헤더를 준비한다. (캐시를 막기 위한 헤더 설정)
      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");

      // 다운로드 파일명을 지정하고 싶다면 다음의 응답 헤더를 추가하라!
      // => 다운로드 파일을 지정하지 않으면 요청 URL이 파일명으로 사용된다.
      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

      return ResponseEntity.ok() // HTTP 응답 프로토콜에 따라 응답을 수행할 생성기를 준비한다.
          .headers(header) // 응답 헤더를 설정한다.
          .contentLength(downloadFile.length()) // 응답할 파일의 크기를 설정한다.
          .contentType(MediaType.APPLICATION_OCTET_STREAM) // 응답 콘텐트의 MIME 타입을 설정한다.
          .body(resource); // 응답 콘텐트를 생성한 후 리턴한다.

    } catch (Exception e) {
      //e.printStackTrace();
      System.out.println("요청한 파일이 없습니다.");
      return null;
    }
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