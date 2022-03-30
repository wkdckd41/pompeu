package com.pompeu.domain;

import lombok.Data;

@Data
public class Ask {

  int no;
  int memberNo;
  String name;
  String askContent;
  String answerContent;
  java.sql.Date registerDate;
  java.sql.Date answerDate;
  Boolean answerCheck;
  /**/
  String answerCheckName;
  int memberTypeNo;
  String memberType;

}
