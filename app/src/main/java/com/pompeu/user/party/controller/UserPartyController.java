package com.pompeu.user.party.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.domain.Member;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyClaim;
import com.pompeu.domain.PartyUser;
import com.pompeu.domain.PartyWishlist;
import com.pompeu.user.party.service.UserPartyService;

@RestController 
public class UserPartyController {

  // log를 출력하는 도구 준비
  private static final Logger log = LoggerFactory.getLogger(UserPartyController.class);

  @Autowired
  UserPartyService userPartyService;

  /**
   * 소모임 목록
   * @return
   */
  @RequestMapping("/userparty/list")
  public Object list(String region, String sort, String inOutEx) {
    System.out.printf("list param : region = %s, sort = %s, inOutEx = %s \n" , region, sort , inOutEx) ;
    log.info("게시글 목록조회!"); // 운영자가 확인하기를 원하는 정보
    List<Party> list =  userPartyService.list(region, sort, inOutEx);
    log.debug(list.toString()); // 개발자가 확인하기를 원하는 정보
    return list;
  }

  /**
   * 소모임 등록
   * @param party
   * @return
   */
  @PostMapping("/userparty/add")
  public Object add(Party party, MultipartFile file, @AuthenticationPrincipal Member member) throws Exception {
    log.info("party---add");
    //    System.out.println(member.getNo());
    //    party.setWriter(member.getNo());
    System.out.println(file);
    party.setWriter(member.getNo());    
    System.out.println(party.getWriter());
    System.out.println("=======");
    log.debug(party.toString()); // 개발자가 확인하기를 원하는 정보

    System.out.println("party = " + party);
    try {
      party.setImage(saveFile(file));
      return userPartyService.add(party);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  /**
   * 소모임 참가
   * @param partyuser
   * @param member
   * @return
   * @throws Exception
   */
  @RequestMapping("/userparty/crewAdd")
  public Object crewAdd(PartyUser partyuser, @AuthenticationPrincipal Member member) {

    log.info("partyCrewAdd.....");
    partyuser.setUsersNo(member.getNo());
    System.out.println(member.getNo());
    System.out.println("========");
    System.out.println("partyuser:"+partyuser.getUsersNo());
    System.out.println("partyno:"+partyuser.getPartyNo());
    System.out.println("--------");
    return userPartyService.crewAdd(partyuser);
  }

  /**
   * 소모임 찜하기
   * @param partyuser
   * @param member
   * @return
   * @throws Exception
   */
  @RequestMapping("/userparty/wishlistAdd")
  public Object wishlistAdd(PartyWishlist partywishlist, @AuthenticationPrincipal Member member) {

    log.info("partyWishlist.....");
    partywishlist.setUsersNo(member.getNo());
    System.out.println(member.getNo());
    System.out.println("========");
    System.out.println("partyuser:"+partywishlist.getUsersNo());
    System.out.println("partyno:"+partywishlist.getPartyNo());
    System.out.println("--------");
    return userPartyService.wishlistAdd(partywishlist);
  }

  /**
   * 소모임 신고
   * @param partyuser
   * @param member
   * @return
   * @throws Exception
   */
  @RequestMapping("/userparty/claimAdd")
  public Object claimAdd(PartyClaim partyclaim, @AuthenticationPrincipal Member member) {

    log.info("partyClaimAdd.....");
    partyclaim.setUsersNo(member.getNo());
    System.out.println(member.getNo());
    System.out.println("========");
    System.out.println("partyuser:"+partyclaim.getUsersNo());
    System.out.println("partyno:"+partyclaim.getPartyNo());
    System.out.println("--------");
    return userPartyService.claimAdd(partyclaim);
  }  

  /**
   * 소모임 상세
   * @param no
   * @return
   */
  @RequestMapping("/userparty/get")
  public Object findByNo(int no) {
    Object object = userPartyService.get(no);
    System.out.println("no: "+no);

    return object;
  }

  /**
   * 소모임 수정
   * @param party
   * @return
   */
  @RequestMapping("/userparty/update")
  public Object update(Party party, MultipartFile file) throws Exception {
    try {
      party.setImage(saveFile(file));
      return userPartyService.update(party);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  /**
   * 소모임 삭제
   * @param no
   * @return
   */
  @RequestMapping("/userparty/delete")
  public Object delete(int no) {
    return userPartyService.delete(no);
  }

  /**
   * 소모임 이미지 조회
   * @param filename
   * @return
   */
  @RequestMapping("/userparty/image")
  public ResponseEntity<Resource> image(String filename) {
    System.out.println("filename: ============="+filename);

    try {
      File downloadFile = new File("./upload/party/" + filename); 
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); 
      InputStreamResource resource = new InputStreamResource(fileIn);
      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");

      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

      return ResponseEntity.ok() 
          .headers(header)
          .contentLength(downloadFile.length())
          .contentType(MediaType.APPLICATION_OCTET_STREAM) 
          .body(resource);

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("요청한 파일이 없습니다.");
      return null;
    }
  }

  /**
   * 소모임 이미지 업로드
   * @param file
   * @return
   * @throws Exception
   */
  private String saveFile(MultipartFile file) throws Exception {
    System.out.println("file: " + file);
    System.out.println("===========");
    if (file != null && file.getSize() > 0) {
      String filename = UUID.randomUUID().toString();

      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      File imageFile = new File("./upload/party/" + filename);
      file.transferTo(imageFile.getCanonicalFile());

      return filename;
    } else {
      //      log.info(" image..... " + file + member);
      //      System.out.println(file + "-----" + member.getEmail());
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

  /**
   * 주소 가져오기
   * @return
   */
  @RequestMapping("/userparty/mapping")
  public Object mapping(int no) {
    return userPartyService.map(no);
  }  

  /**
   * 주소 Tag 가져오기
   * @return
   */
  @RequestMapping("/userparty/siSep")
  public Object siSep(int no) {
    return userPartyService.si(no);
  } 

}