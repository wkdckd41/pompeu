package com.pompeu.creator.lecture.Service;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface CreatorLectureService {

  int countAll();

  List<Lecture> list();

  Lecture get(int no);

  int add(Lecture lecture);

  int update(Lecture lecture);

  int delete(int no);


}
