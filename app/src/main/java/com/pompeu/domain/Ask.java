package com.pompeu.domain;

import lombok.Data;

@Data
public class Ask {

  int no;
  int memberNo;
  String askContent;
  String answerContent;
  java.sql.Date registerDate;
  java.sql.Date answerDate;
}
