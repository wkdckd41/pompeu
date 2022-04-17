package com.pompeu.mypage.userChange.service;

import java.util.List;
import java.util.Map;
import com.pompeu.domain.Member;
import com.pompeu.domain.UserUpdate;

public interface UserChangeService {

  List<Member> list();

  int add(Member member);

  Member get(int no);

  int update(Member member);

  int delete(int no);

  Map<Object,Object> getUser(int no);

  int updateUser(UserUpdate user);

}