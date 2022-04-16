package com.pompeu.domain;

import lombok.Data;

@Data
public class Faq {

  int no;
  int memberTypeNo;
  String memberType;
  String ask;
  String answer;
  java.sql.Date registerDate;
  java.sql.Date modifyDate;


}




