package com.pompeu.user.party.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Party;
import com.pompeu.user.party.service.UserPartyService;

@RestController 
public class UserPartyController {

  // log를 출력하는 도구 준비
  private static final Logger log = LoggerFactory.getLogger(UserPartyController.class);

  @Autowired
  UserPartyService userPartyService;

  /**
   * 게시판 목록
   * @return
   */
  @RequestMapping("/userparty/list")
  public Object list(String sort, String inOutEx) {
    System.out.printf("list param : sort = %s, inOutEx = %s \n" , sort , inOutEx) ;
    log.info("게시글 목록조회!"); // 운영자가 확인하기를 원하는 정보
    List<Party> list =  userPartyService.list(sort, inOutEx);
    log.debug(list.toString()); // 개발자가 확인하기를 원하는 정보
    return list;
  }

  /**
   * 게시판 등록
   * @param party
   * @return
   */
  @RequestMapping("/userparty/add")
  public Object add(Party party) {
    System.out.println("### : " + party.getInOutEx());
    return userPartyService.add(party);
  }

  /**
   * 게시판 상세
   * @param no
   * @return
   */
  @RequestMapping("/userparty/get")
  public Object findByNo(int no) {
    Object object = userPartyService.get(no);
    return object;
  }

  /**
   * 게시판 수정
   * @param party
   * @return
   */
  @RequestMapping("/userparty/update")
  public Object update(Party party) {
    return userPartyService.update(party);
  }

  /**
   * 게시판 삭제
   * @param no
   * @return
   */
  @RequestMapping("/userparty/delete")
  public Object delete(int no) {
    return userPartyService.delete(no);
  }

  /**
   * 이미지 파일명 가져오기
   * @param no
   * @return
   */
  @RequestMapping("/userparty/addImage")
  public Object addImage(int no) {
    return userPartyService.img(no);
  }

  /**
   * 소모임 이미지 등록
   * @param filename
   * @return
   */
  @RequestMapping("/userparty/image")
  public ResponseEntity<Resource> image(String filename) {

    try {
      // 다운로드할 파일의 입력 스트림 자원을 준비한다.
      File downloadFile = new File("./upload/party_image/" + filename); // 다운로드 상대 경로 준비
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

  /**
   * 운동 Tag 목록
   * @return
   */
  @RequestMapping("/userparty/tag")
  public Object findByExTag(Party party) {
    return userPartyService.tag(party);
  }

}