package com.pompeu.user.lecture.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Lecture;
import com.pompeu.user.lecture.dao.UserLectureDao;

@RestController 
public class UserLectureController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(UserLectureController.class);

  @Autowired
  UserLectureDao userLectureDao;

  @RequestMapping("/userLecture/list")
  public Object list() {
    log.debug("게실물 목록 조회!");
    return userLectureDao.findAll();
  }

  @RequestMapping("/userLecture/add")
  public Object add(Lecture lecture) {
    return userLectureDao.insert(lecture);
  }

  @RequestMapping("/userLecture/get")
  public Object get(int no) {
    Lecture lecture = userLectureDao.findByNo(no);
    return lecture != null ? lecture : "";
  }

  @RequestMapping("/userLecture/update")
  public Object update(Lecture lecture) {
    return userLectureDao.update(lecture);
  }

  @RequestMapping("/userLecture/delete")
  public Object delete(int no) {
    return userLectureDao.delete(no);
  }

  @RequestMapping("/userLecture/findEverything")
  public Object findEverything() {
    return userLectureDao.findEverything();
  }

  @RequestMapping("/userLecture/findOut")
  public Object findOut() {
    return userLectureDao.findOut();
  }

  @RequestMapping("/userLecture/findIn")
  public Object findIn() {
    return userLectureDao.findIn();
  }

  @RequestMapping("/userLecture/findLectureLocation")
  public Object findLectureLocation(int no) {
    return userLectureDao.findLectureLocation(no);
  }

}