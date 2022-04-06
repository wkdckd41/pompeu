package com.pompeu.creator.lecture.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureTime;

@RestController
public class LectureController {


  @Autowired
  CreatorLectureService creatorlectureService;

  @RequestMapping("/creatorLecture/list")
  public Object list() {
    return creatorlectureService.list();
  }

  @RequestMapping("/creatorLecture/add")
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
    return creatorlectureService.add(lecture);
  }

  @RequestMapping("/creatorLecture/get")
  public Object get(int no) {
    Lecture lecture = creatorlectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  @RequestMapping("/creatorLecture/update")
  public Object update(Lecture lecture) {
    return creatorlectureService.update(lecture);
  }


}
