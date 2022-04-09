package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class myLectureAsk {

  int no;
  int lectureNo;
  int usersNo;
  String askContent;
  Date registerDate;
  String answerContent;
  Date answerRegisterDate;
  int display;

}
