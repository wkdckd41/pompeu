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

  List<Map<String,Object>> srchMember(Member member);

<<<<<<< HEAD
=======
  int memberRegi(Member member);

>>>>>>> branch 'main' of https://github.com/linarano/pompeu.git
}




