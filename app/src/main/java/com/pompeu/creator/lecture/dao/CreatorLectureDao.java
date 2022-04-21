package com.pompeu.creator.lecture.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureImage;
import com.pompeu.domain.LectureTime;

@Mapper
public interface CreatorLectureDao {

  int countAll();

  List<Lecture> findAll();


  int insert(Lecture lecture);

  int insertTimes(@Param("lectureNo") int contactNo, @Param("times") List<LectureTime> times);

  int insertImage(@Param("lectureNo") int contactNo, @Param("image") List<LectureImage> images);

  int insertImages(@Param("lectureNo") int contactNo, @Param("images") List<LectureImage> images);

  Lecture findByNo(int no);

  int update(Lecture lecture);

  int delete(int no);

}



