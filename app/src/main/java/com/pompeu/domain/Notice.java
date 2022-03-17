package com.pompeu.domain;

public class Notice {

  int no;
  int memberTypeNo;
  int criticalCheck;
  java.sql.Date registerDate;
  int viewCount;
  String name;
  String content;
  java.sql.Date modifyDate;

  @Override
  public String toString() {
    return "Notice [no=" + no + ", memberTypeNo=" + memberTypeNo + ", criticalCheck="
        + criticalCheck + ", registerDate=" + registerDate + ", viewCount=" + viewCount + ", name="
        + name + ", content=" + content + ", modifyDate=" + modifyDate + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getMemberTypeNo() {
    return memberTypeNo;
  }
  public void setMemberTypeNo(int memberTypeNo) {
    this.memberTypeNo = memberTypeNo;
  }
  public int getCriticalCheck() {
    return criticalCheck;
  }
  public void setCriticalCheck(int criticalCheck) {
    this.criticalCheck = criticalCheck;
  }
  public java.sql.Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(java.sql.Date registerDate) {
    this.registerDate = registerDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
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
  public java.sql.Date getModifyDate() {
    return modifyDate;
  }
  public void setModifyDate(java.sql.Date modifyDate) {
    this.modifyDate = modifyDate;
  }


}
