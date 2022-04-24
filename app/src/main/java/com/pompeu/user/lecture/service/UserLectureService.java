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

  List<Lecture> getEverything(String sort, String region);

  List<Lecture> getOut(String sort, String region);

  List<Lecture> getIn(String sort, String region);

  List<LectureIntro> lecture(int no);

  List<Lecture> userCon(int no);

  List<Lecture> creator(int no);

  List<Lecture> regist(int no);

  List<Lecture> time(int no);

  int addAsk(Lecture lecture);

  List<Lecture> img(int no);

  List<Lecture> map(int no);

  List<Lecture> si(int no);
}

