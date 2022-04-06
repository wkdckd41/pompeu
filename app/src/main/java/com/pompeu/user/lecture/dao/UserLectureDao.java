package com.pompeu.user.lecture.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Lecture;

@Mapper  
public interface UserLectureDao {

  List<Lecture> findAll();

  int insert(Lecture lecture);

  Lecture findByNo(int no);

  int update(Lecture lcture);

  int delete(int no);

  Lecture findExercise(int no);

  Lecture findLectureLocation(int no);


}