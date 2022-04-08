package com.pompeu.admin.lecture.dao;

import java.util.List;
import com.pompeu.domain.Lecture;

public interface AdminLectureDao {

  int countAll();

  List<Lecture> findAll();

  Lecture findByNo(int no);

  int update(Lecture lecture);

}