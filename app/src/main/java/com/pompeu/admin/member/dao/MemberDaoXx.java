package com.pompeu.admin.member.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.admin.member.domain.MemberXx;

@Mapper
public interface MemberDaoXx {

  int countAll();

  List<MemberXx> findAll();

  int insert(MemberXx member);

  MemberXx findByNo(int no);

  int update(MemberXx member);

  int delete(int no);

  List<Integer> findCount();

  List<Map<String,Object>> srchMember(MemberXx member);

  int memberRegi(MemberXx member);
}




