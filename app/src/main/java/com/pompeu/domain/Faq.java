package com.pompeu.domain;

public class Faq {

  int no;
  int memberTypeNo;
  String ask;
  String answer;
  java.sql.Date registerDate;
  java.sql.Date modifyDate;

  @Override
  public String toString() {
    return "Faq [no=" + no + ", memberTypeNo=" + memberTypeNo + ", ask=" + ask + ", answer="
        + answer + ", registerDate=" + registerDate + ", modifyDate=" + modifyDate + "]";
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
  public String getAsk() {
    return ask;
  }
  public void setAsk(String ask) {
    this.ask = ask;
  }
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
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




