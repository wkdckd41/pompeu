package com.pompeu.admin.member.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Member {

  int no;
  int memberTypeNo;
  String name;
  String email;
  String phone;
  String birth;
  String nickName;
  int gender;
  int password;
  Date joinDate;
  Date loginDate;
  Date modifyDate;
  int useCheck;
  int adminCheck;
  int snsNo;

}
