package com.pompeu.mypage.userChange.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Member;
import com.pompeu.domain.UserUpdate;

@Mapper
public interface UserChangeDao {

  int countAll();

  List<Member> findAll();

  int insert(Member member);

  Member findByNo(int no);

  int update(Member member);

  int delete(int no);

  Map<Object,Object> getUser(int no);

  int updateUser(UserUpdate user);

  int checkNickname(String nickname);

  int deleteUser(Member member);

  int deleteUserDetail(int no);
}

