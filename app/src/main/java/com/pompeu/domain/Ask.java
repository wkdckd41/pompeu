package com.pompeu.domain;

import lombok.Data;

@Data
public class Ask {

  int no;
  int usersNo;
  int creatorNo;
  java.sql.Date registerDate;
  String askContent;
  String display;
  String image;
  java.sql.Date askModifyDate;
  String answerContent;
  java.sql.Date answerDate;
  java.sql.Date answerModifyDate;


}
