package com.pompeu.user.lecture.service;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface UserLectureService {

  List<Lecture> list();

  int add(Lecture lecture);

  Lecture get(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Lecture> getOut();

}