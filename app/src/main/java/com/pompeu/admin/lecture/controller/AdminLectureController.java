package com.pompeu.admin.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.lecture.service.AdminLectureService;
import com.pompeu.domain.Lecture;

@RestController
public class AdminLectureController {

  @Autowired
  AdminLectureService adminlectureService;

  @RequestMapping("/adminlecture/list")
  public Object list() {
    return adminlectureService.list();
  }

  @RequestMapping("/adminlecture/get")
  public Object get(int no) {
    Lecture lecture = adminlectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  @RequestMapping("/adminlecture/update")
  public Object update(Lecture lecture) {
    return adminlectureService.update(lecture);
  }


}