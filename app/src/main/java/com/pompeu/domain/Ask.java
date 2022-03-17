package com.pompeu.domain;

public class Ask {

  int no;
  int usersNo;
  int creatorNo;
  java.sql.Date registerDate;
  String askContent;
  String display;
  String image;
  java.sql.Date askModifyDate;
  String answerContent;
  java.sql.Date answerDate;
  java.sql.Date answerModifyDate;

  @Override
  public String toString() {
    return "Ask [no=" + no + ", usersNo=" + usersNo + ", creatorNo=" + creatorNo + ", registerDate="
        + registerDate + ", askContent=" + askContent + ", display=" + display + ", image=" + image
        + ", askModifyDate=" + askModifyDate + ", answerContent=" + answerContent + ", answerDate="
        + answerDate + ", answerModifyDate=" + answerModifyDate + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }
  public int getCreatorNo() {
    return creatorNo;
  }
  public void setCreatorNo(int creatorNo) {
    this.creatorNo = creatorNo;
  }
  public java.sql.Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(java.sql.Date registerDate) {
    this.registerDate = registerDate;
  }
  public String getAskContent() {
    return askContent;
  }
  public void setAskContent(String askContent) {
    this.askContent = askContent;
  }
  public String getDisplay() {
    return display;
  }
  public void setDisplay(String display) {
    this.display = display;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public java.sql.Date getAskModifyDate() {
    return askModifyDate;
  }
  public void setAskModifyDate(java.sql.Date askModifyDate) {
    this.askModifyDate = askModifyDate;
  }
  public String getAnswerContent() {
    return answerContent;
  }
  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }
  public java.sql.Date getAnswerDate() {
    return answerDate;
  }
  public void setAnswerDate(java.sql.Date answerDate) {
    this.answerDate = answerDate;
  }
  public java.sql.Date getAnswerModifyDate() {
    return answerModifyDate;
  }
  public void setAnswerModifyDate(java.sql.Date answerModifyDate) {
    this.answerModifyDate = answerModifyDate;
  }


}
