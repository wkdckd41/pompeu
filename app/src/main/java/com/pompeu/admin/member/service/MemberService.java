package com.pompeu.admin.member.service;

import java.util.List;
import java.util.Map;
import com.pompeu.domain.Member;

public interface MemberService {

  List<Member> list();

  int add(Member member);

  Member get(int no);

  int update(Member member);

  int delete(int no);

  List<Integer> memberList();

  List<Member> srchMember(Member member);

  List<Map<Object, Object>> getClass(int no);

  List<Map<Object, Object>> creatorClass(int no);

  List<Map<Object, Object>> applyingClass(int no);

}