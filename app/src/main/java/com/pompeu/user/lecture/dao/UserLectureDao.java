package com.pompeu.user.lecture.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Ask;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureIntro;

@Mapper  
public interface UserLectureDao {

  List<Lecture> findAll();

  int insert(Lecture lecture);

  Lecture findByNo(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Lecture> findEverything(@Param("sort") String sort);

  List<Lecture> findOut(@Param("sort") String sort);

  List<Lecture> findIn(@Param("sort") String sort);

  List<LectureIntro> findLecture(int no);

  List<Lecture> registLecture(int no);

  List<Lecture> registTime(int no);

  int insertAsk(Ask ask);

  List<Lecture> addImage(int no);

  List<Lecture> mapping(int no);

  List<Lecture> siSep2(int no);
}