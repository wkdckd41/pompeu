package com.pompeu.creator.lecture.Service;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface LectureService {


  int countAll();

  List<Lecture> list();

  Lecture get(int no);

  Lecture add(Lecture lecture);

  int update(Lecture lecture);


}
