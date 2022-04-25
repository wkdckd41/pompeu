package com.pompeu.user.main.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.LectureLike;
import com.pompeu.domain.Member;

@Mapper
public interface UserMainDao {

  int countAll();

  List<Member> findAll();

  int insert(Member member);

  Member findByNo(int no);

  int update(Member member);

  int delete(int no);

  List<Map<Object, Object>> findTopLecture(int no);

  List<Map<Object, Object>> findNewLecture(int no);

  int didICount(LectureLike lectureLike);

  // Object memberStatus();
  //
  // Object lectureStatus();
  //
  // Object undoStatusApply();
  //
  // Object undoStatusClaim();
  //
  // Object memberSummary(int month);

}

