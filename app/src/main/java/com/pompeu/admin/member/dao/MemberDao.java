package com.pompeu.admin.member.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Member;

@Mapper
public interface MemberDao {

  int countAll();

  List<Member> findAll();

  int insert(Member member);

  Member findByNo(int no);

  int update(Member member);

  int delete(int no);

  List<Integer> findCount();

  List<Member> srchMember(Member member);

  List<Map<Object, Object>> findUserClass(int no);

  List<Map<Object, Object>> findCreatorClass(int no);

  List<Map<Object, Object>> findApplyingClass(int no);

}

