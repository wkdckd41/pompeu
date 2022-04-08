package com.pompeu.admin.main.service;

import java.util.List;
import com.pompeu.domain.Member;

public interface AdminMainService {

  List<Member> list();

  int add(Member member);

  Member get(int no);

  int update(Member member);

  int delete(int no);

  Object memberStatus();

  Object lectureStatus();

  Object undoStatusApply();

  Object undoStatusClaim();

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