package com.pompeu.domain;

public class Party {

  int no;
  int locationNo;
  String name;
  String content;
  java.sql.Date startDate;
  java.sql.Date endDate;
  int maxMember;
  int inOutEx;
  java.sql.Date registerDate;
  java.sql.Date modifyDate;



  @Override
  public String toString() {
    return "Party [no=" + no + ", locationNo=" + locationNo + ", name=" + name + ", content="
        + content + ", startDate=" + startDate + ", endDate=" + endDate + ", maxMember=" + maxMember
        + ", inOutEx=" + inOutEx + ", registerDate=" + registerDate + ", modifyDate=" + modifyDate
        + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getLocationNo() {
    return locationNo;
  }
  public void setLocationNo(int locationNo) {
    this.locationNo = locationNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public java.sql.Date getStartDate() {
    return startDate;
  }
  public void setStartDate(java.sql.Date startDate) {
    this.startDate = startDate;
  }
  public java.sql.Date getEndDate() {
    return endDate;
  }
  public void setEndDate(java.sql.Date endDate) {
    this.endDate = endDate;
  }
  public int getMaxMember() {
    return maxMember;
  }
  public void setMaxMember(int maxMember) {
    this.maxMember = maxMember;
  }
  public int getInOutEx() {
    return inOutEx;
  }
  public void setInOutEx(int inOutEx) {
    this.inOutEx = inOutEx;
  }
  public java.sql.Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(java.sql.Date registerDate) {
    this.registerDate = registerDate;
  }
  public java.sql.Date getModifyDate() {
    return modifyDate;
  }
  public void setModifyDate(java.sql.Date modifyDate) {
    this.modifyDate = modifyDate;
  }


}
