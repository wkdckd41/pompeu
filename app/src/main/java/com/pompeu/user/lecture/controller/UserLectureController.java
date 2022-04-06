package com.pompeu.user.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Lecture;
import com.pompeu.user.lecture.dao.UserLectureDao;

@RestController 
public class UserLectureController {


  @Autowired
  UserLectureDao userLectureDao;

  @RequestMapping("/userLecture/list")
  public Object list() {
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

  @RequestMapping("/userLecture/findExercise")
  public Object findExercise(int no) {
    return userLectureDao.findExercise(no);
  }

  @RequestMapping("/userLecture/findLectureLocation")
  public Object findLectureLocation(int no) {
    return userLectureDao.findLectureLocation(no);
  }

}