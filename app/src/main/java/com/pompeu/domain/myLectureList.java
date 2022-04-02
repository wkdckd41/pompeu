package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class myLectureList {

  int no;
  int usersNo;
  int lectureTimeNo;
  int registerMember;
  int payStatus;
  String content;
  Date registerDate;
  double rate;

}
