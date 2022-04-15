package com.pompeu.user.lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Ask;
import com.pompeu.domain.Lecture;
import com.pompeu.user.lecture.service.UserLectureService;

@RestController 
public class UserLectureController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(UserLectureController.class);

  @Autowired
  UserLectureService userLectureService;

  @RequestMapping("/userLecture/list")
  public Object list() {
    log.debug("게실물 목록 조회!");
    return userLectureService.list();
  }

  @RequestMapping("/userLecture/add")
  public Object add(Lecture lecture) {
    return userLectureService.add(lecture);
  }

  @RequestMapping("/userLecture/get")
  public Object get(int no) {
    Lecture lecture = userLectureService.get(no);
    return lecture != null ? lecture : "";
  }

  @RequestMapping("/userLecture/update")
  public Object update(Lecture lecture) {
    return userLectureService.update(lecture);
  }

  @RequestMapping("/userLecture/delete")
  public Object delete(int no) {
    return userLectureService.delete(no);
  }

  @RequestMapping("/userLecture/findEverything")
  public Object findEverything() {
    return userLectureService.getEverything();
  }

  @RequestMapping("/userLecture/imageEverything")
  public Object imageEverything() {
    return userLectureService.imgEverything();
  }

  @RequestMapping("/userLecture/findOut")
  public Object findOut() {
    return userLectureService.getOut();
  }

  @RequestMapping("/userLecture/findIn")
  public Object findIn() {
    return userLectureService.getIn();
  }

  @RequestMapping("/userLecture/findLecture")
  public Object findLecture(int no) {
    Object object = userLectureService.lecture(no);
    return object;
  }

  @RequestMapping("/userLecture/registLecture")
  public Object registLecture(int no) {
    return userLectureService.regist(no);
  }

  @RequestMapping("/userLecture/registTime")
  public Object registTime(int no) {
    return userLectureService.time(no);
  }

  @RequestMapping("/userLecture/addAsk")
  public Object addAsk(Ask ask) {
    return userLectureService.addAsk(ask);
  }  

  @RequestMapping("/userLecture/addImage")
  public Object addImage(int no) {
    return userLectureService.img(no);
  }

  @RequestMapping("/userLecture/image")
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

}