package com.pompeu.mypage.myMain.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Member;

@Mapper
public interface MyMainDao {

  int countAll();

  List<Member> findAll();

  int insert(Member member);

  Member findByNo(int no);

  int update(Member member);

  int delete(int no);

  List<Map<String, Object>> myGoingLecture(int no);

  List<Map<String, Object>> myWishLecture(int no);

  List<Map<String, Object>> myGoingParty(int no);

  List<Map<String, Object>> myWishParty(int no);

  //  Object memberStatus();
  //
  //  Object lectureStatus();
  //
  //  Object undoStatusApply();
  //
  //  Object undoStatusClaim();
  //
  //  Object memberSummary(int month);

  //  List<Integer> memberStatus();

  //  List<Integer> findCount();
  //
  //  List<Member> srchMember(Member member);
  //
  //  List<Map<Object, Object>> findUserLecture(int no);
  //
  //  List<Map<Object, Object>> findCreatorLecture(int no);
  //
  //  List<Map<Object, Object>> findApplyingLecture(int no);

}

