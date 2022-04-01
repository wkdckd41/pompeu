package com.pompeu.domain;

import lombok.Data;

@Data
public class Notice {

  int no;
  int memberTypeNo;
  String memberType;
  int criticalCheck;
  java.sql.Date registerDate;
  int viewCount;
  String name;
  String content;
  java.sql.Date modifyDate;

}
