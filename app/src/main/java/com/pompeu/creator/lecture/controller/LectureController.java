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


  @Autowired
  LectureService lectureService;

  @RequestMapping("/lecture/list")
  public Object list() {
    return lectureService.list();
  }

  @RequestMapping("/lecture/add")
  public Object add(Lecture lecture, String[] time) {
    ArrayList<LectureTime> timesList = new ArrayList<>();
    for(int i= 0; i< time.length; i++) {
      String[] value = time[i].split(",");
      if(value[0].length() == 0) { //시작시간
        continue;
      } 
      if(value[1].length() == 0) { //종료시간
        continue;
      }  

      LectureTime lectureTime = new LectureTime
          (value[0],value[1],Integer.parseInt(value[2]));

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
