package com.pompeu.domain;

import lombok.Data;

@Data
public class LectureTime {

  int no;
  int lectureNo;
  String startTime;
  String endTime;
  int maxMember;


  LectureTime(){};

  public LectureTime(String startTime, String endTime, int maxMember){
    this.startTime = startTime;
    this.endTime = endTime;
    this.maxMember= maxMember;
  };

  public LectureTime(int no, String startTime, String endTime, int maxMember){
    this(startTime, endTime, maxMember);
    this.no = no;
  };



}
