package com.pompeu.mypage.myMain.service;

import java.util.List;
import java.util.Map;
import com.pompeu.domain.Member;

public interface MyMainService {

  List<Member> list();

  int add(Member member);

  Member get(int no);

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

  //  List<Integer> memberList();
  //
  //  List<Member> srchMember(Member member);
  //
  //  List<Map<Object, Object>> getLecture(int no);
  //
  //  List<Map<Object, Object>> creatorLecture(int no);
  //
  //  List<Map<Object, Object>> applyingLecture(int no);

}