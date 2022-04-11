package com.pompeu.user.lecture.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}