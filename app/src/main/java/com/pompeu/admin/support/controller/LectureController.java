package com.pompeu.admin.support.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.support.service.LectureService;
import com.pompeu.domain.Lecture;

@RestController
public class LectureController {

  LectureService lectureService;

  @RequestMapping("/lecture/list")
  public Object list() {
    return lectureService.list();
  }

  @RequestMapping("/lecture/get")
  public Object get(int no) {
    Lecture lecture = lectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  @RequestMapping("/lecture/update")
  public Object update(Lecture lecture) {
    return lectureService.update(lecture);
  }


}
