package com.pompeu.admin.support.dao;

import java.util.List;
import com.pompeu.domain.Lecture;

//@Mapper
public interface AdminLectureDao {


  int countAll();

  List<Lecture> findAll();

  Lecture findByNo(int no);

  int update(Lecture lecture);

}
