package com.pompeu.creator.lecture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.creator.lecture.Service.LectureService;
import com.pompeu.domain.Lecture;

@RestController
public class LectureController {


  LectureService lectureService;

  @RequestMapping("/lecture/list")
  public Object list() {
    return lectureService.list();
  }

  @RequestMapping("/lecture/add")
  public Object add(Lecture lecture) {
    return lectureService.add(lecture);
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
