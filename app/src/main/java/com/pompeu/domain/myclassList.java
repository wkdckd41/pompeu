package com.pompeu.domain;

import java.sql.Date;

public class myclassList {

  int myclassListNo;
  int usersNo;
  int classTimeNo;
  int registerMember;
  int payStatus;
  String content;
  Date registerDate;
  double rate;

  @Override
  public String toString() {
    return "myclassList [myclassListNo=" + myclassListNo + ", usersNo=" + usersNo + ", classTimeNo="
        + classTimeNo + ", registerMember=" + registerMember + ", payStatus=" + payStatus
        + ", content=" + content + ", registerDate=" + registerDate + ", rate=" + rate + "]";
  }

  public int getMyclassListNo() {
    return myclassListNo;
  }
  public void setMyclassListNo(int myclassListNo) {
    this.myclassListNo = myclassListNo;
  }
  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }
  public int getClassTimeNo() {
    return classTimeNo;
  }
  public void setClassTimeNo(int classTimeNo) {
    this.classTimeNo = classTimeNo;
  }
  public int getRegisterMember() {
    return registerMember;
  }
  public void setRegisterMember(int registerMember) {
    this.registerMember = registerMember;
  }
  public int getPayStatus() {
    return payStatus;
  }
  public void setPayStatus(int payStatus) {
    this.payStatus = payStatus;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public double getRate() {
    return rate;
  }
  public void setRate(double rate) {
    this.rate = rate;
  }



}
