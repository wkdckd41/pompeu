package com.pompeu.mypage.userChange.service;

import java.util.List;
import com.pompeu.domain.Member;

public interface UserChangeService {

  List<Member> list();

  int add(Member member);

  Member get(int no);

  int update(Member member);

  int delete(int no);

}