package com.pompeu.user.lecture.service;

import java.util.List;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureIntro;

public interface UserLectureService {

  List<Lecture> list();

  int add(Lecture lecture);

  Lecture get(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Lecture> getEverything();

  List<Lecture> getOut();

  List<Lecture> getIn();

  List<LectureIntro> lecture(int no);

  List<Lecture> regist(int no);
}