package com.pompeu.creator.lecture.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureTime;

@RestController
public class CreatorLectureController {


  @Autowired
  CreatorLectureService creatorlectureService;

  @RequestMapping("/creatorlecture/list")
  public Object list() {
    return creatorlectureService.list();
  }

  @RequestMapping("/creatorlecture/add")
  public Object add(Lecture lecture, String[] times) {

    ArrayList<LectureTime> timesList = new ArrayList<>();
    for(int i= 0; i< times.length; i++) {
      String[] value = times[i].split(",");

      if(value[0].length() == 0) {
        continue;
      }

      if(value[1].length() == 0) {
        continue;
      }

      LectureTime lectureTime = new LectureTime
          (value[0],value[1],Integer.parseInt(value[4]));

      timesList.add(lectureTime);
    }
    lecture.setTimes(timesList);
    return creatorlectureService.add(lecture);
  }

  @RequestMapping("/creatorlecture/get")
  public Object get(int no) {
    Lecture lecture = creatorlectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  @RequestMapping("/creatorlecture/update")
  public Object update(Lecture lecture) {
    return creatorlectureService.update(lecture);
  }

  @RequestMapping("/creatorlecture/delete")
  public Object delete(Lecture lecture) {
    return creatorlectureService.update(lecture);
  }


}
