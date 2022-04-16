package com.pompeu.creator.userAsk.service;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface UserAskService {

  List<Lecture> list();

  int add(Lecture lecture);

  Lecture get(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Lecture> drop(int no);

}

