package com.pompeu.user.main.controller;

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

  @RequestMapping("/userMain/image")
  public ResponseEntity<Resource> image(String filename) {

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