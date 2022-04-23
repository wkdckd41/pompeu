package com.pompeu.mypage.userChange.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.domain.Member;
import com.pompeu.domain.UserUpdate;
import com.pompeu.mypage.userChange.service.UserChangeService;

@RestController 
public class UserChangeController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 UserChangeDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  UserChangeService userChangeService;

  @RequestMapping("/userChange/list")
  public Object list() {
    return userChangeService.list();
  }

  @RequestMapping("/userChange/add")
  public Object add(Member member) {
    return userChangeService.add(member);
  }

  @RequestMapping("/userChange/get")
  public Object get(int no) {
    Member member = userChangeService.get(no);
    return member != null ? member : "";
  }

  @RequestMapping("/userChange/update")
  public Object update(Member member) {
    return userChangeService.update(member);
  }

  @RequestMapping("/userChange/delete")
  public Object delete(int no) {
    return userChangeService.delete(no);
  }

  @RequestMapping("/userChange/getUser")
  public Object getUser(int no) {
    Map<Object,Object> user = userChangeService.getUser(no);
    return user != null ? user : "";
  }

  @RequestMapping("/userChange/updateUser")
  public Object updateUser(UserUpdate user, MultipartFile file) {
    try {
      user.setImage(saveFile(file));
      System.out.println(user.getImage());
      return userChangeService.updateUser(user);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  @RequestMapping("/userChange/checkNickname")
  public Object checkNickname(String nickname) {
    return userChangeService.checkNickname(nickname);
  }

  @RequestMapping("/userChange/deleteUser")
  public Object deleteUser(Member member) {
    try {
      return userChangeService.deleteUser(member);
    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  @RequestMapping("/userChange/image")
  public ResponseEntity<Resource> image(String filename) {

    try {
      // 다운로드할 파일의 입력 스트림 자원을 준비한다.
      File downloadFile = new File("./upload/users/" + filename); // 다운로드 상대 경로 준비
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

  private String saveFile(MultipartFile file) throws Exception {
    // Multipart : 웹 클라이언트가 요청을 보낼 때, http 프로토콜의 바디 부분에 
    // 데이터를 여러 부분으로 나눠서 보내는 것.

    if (file != null && file.getSize() > 0) { 
      // 파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      // "."이 문자열에서 몇번째 문자인지 알아낸다
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
        //"."부터 마지막까지 문자열을 추출해 filename에 더한다.
      }

      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("./upload/users/" + filename); // App 클래스를 실행하는 프로젝트 폴더
      file.transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.

      //      // 썸네일 이미지 파일 생성
      //      Thumbnails.of(photoFile)
      //      .size(50, 50)
      //      .crop(Positions.CENTER)
      //      .outputFormat("jpg")
      //      .toFile(new File("./upload/book/" + "50x50_" + filename));

      return filename;

    } else {
      return null;
    }
  }

}