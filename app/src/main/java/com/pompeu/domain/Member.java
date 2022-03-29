package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Member {

  int no;
  String name;
  String email;
  String phone;
  String nickName;
  int useCheck;
  Date loginDate;
  Date joinDate;
  Date modifyDate;
  int adminCheck;
  String password;
  String birth;
  int gender;
  int snsNo;
  int memberTypeNo;
  MemberType memberType;




}