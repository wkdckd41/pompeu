package com.pompeu.login.service;

import com.pompeu.domain.Member;

public interface UserService {


  int add(Member member);

  int nickCheck(String nickname);


  String roleCheck(String email);


  int emailCheck(String email);

  //  Optional<Member> getEmail(String email);

  //  Member getMember(String email, String password);

  int loginDate(String email);


  int deleteUser(String email);


}