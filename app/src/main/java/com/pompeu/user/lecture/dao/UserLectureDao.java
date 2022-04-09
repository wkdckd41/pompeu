package com.pompeu.user.lecture.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Lecture;

@Mapper  
public interface UserLectureDao {

  List<Lecture> findAll();

  int insert(Lecture lecture);

  Lecture findByNo(int no);

  int update(Lecture lcture);

  int delete(int no);

  List<Lecture> findEverything();

  List<Lecture> findOut();

  List<Lecture> findIn();

  List<Map<Object, Object>> findLecture(int no);

  Lecture findLectureLocation(int no);

}