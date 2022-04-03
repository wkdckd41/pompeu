package com.pompeu.creator.lecture.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.creator.lecture.Service.LectureService;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureTime;

@RestController
public class LectureController {

  //add 메서드 변경필요
  //main

  @Autowired
  LectureService lectureService;

  @RequestMapping("/lecture/list")
  public Object list() {
    return lectureService.list();
  }

  @RequestMapping("/lecture/add")
  public Object add(Lecture lecture, String[] times) {

    ArrayList<LectureTime> timesList = new ArrayList<>();
    for(int i= 0; i< times.length; i++) {
      String[] value = times[i].split(",");
      if(value[1].length() == 0) {
        continue;
      }
      LectureTime lectureTime = new LectureTime
          (value[2],value[3],Integer.parseInt(value[4]));

      timesList.add(lectureTime);
    }
    lecture.setTimes(timesList);
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
