package com.pompeu.admin.support.dao;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface LectureDao {


  int countAll();

  List<Lecture> findAll();

  Lecture findByNo(int no);

  int update(Lecture lecture);

}
