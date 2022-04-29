package com.pompeu.creator.lecture.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureList;
import com.pompeu.domain.LectureTime;
import com.pompeu.domain.Test;

@Mapper
public interface CreatorLectureDao {

  int countAll();

  List<LectureList> findAllMyclass(@Param("no") int no);

  int insert(Lecture lecture);

  int insertTimes(@Param("lectureNo") int lectureNo, @Param("times") List<LectureTime> times);

  int insertImages(@Param("lectureNo") int lectureNo, @Param("images") List<String> images);

  Lecture findByNo(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Test> test();

}



