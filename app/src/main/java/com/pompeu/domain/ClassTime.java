package com.pompeu.domain;

import java.sql.Date;

public class ClassTime {

  int classTimeNo;
  int classNo;
  Date startTime;
  Date endTime;
  int maxMember;

  @Override
  public String toString() {
    return "ClassTime [classTimeNo=" + classTimeNo + ", classNo=" + classNo + ", startTime="
        + startTime + ", endTime=" + endTime + ", maxMember=" + maxMember + "]";
  }

  public int getClassTimeNo() {
    return classTimeNo;
  }
  public void setClassTimeNo(int classTimeNo) {
    this.classTimeNo = classTimeNo;
  }
  public int getClassNo() {
    return classNo;
  }
  public void setClassNo(int classNo) {
    this.classNo = classNo;
  }
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  public Date getEndTime() {
    return endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
  public int getMaxMember() {
    return maxMember;
  }
  public void setMaxMember(int maxMember) {
    this.maxMember = maxMember;
  }


}
