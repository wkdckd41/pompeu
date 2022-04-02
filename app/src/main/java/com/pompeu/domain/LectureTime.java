package com.pompeu.domain;

import lombok.Data;

@Data
public class LectureTime {

  int no;
  int lectureNo;
  String startTime;
  String endTime;
  int maxMember;
  int noMember;

  LectureTime(){};

  public LectureTime(String value, String value2, int value3){
    this.startTime = value;
    this.endTime = value2;
    this.maxMember=value3;
  };


}
