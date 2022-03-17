package com.pompeu.domain;

public class Challenge {

  int no;
  int classNo;
  int usersNo;
  String name;
  String content;
  String image;
  java.sql.Date registerDate;
  java.sql.Date modifyDate;
  int viewCount;

  @Override
  public String toString() {
    return "Challenge [no=" + no + ", classNo=" + classNo + ", usersNo=" + usersNo + ", name="
        + name + ", content=" + content + ", image=" + image + ", registerDate=" + registerDate
        + ", modifyDate=" + modifyDate + ", viewCount=" + viewCount + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getClassNo() {
    return classNo;
  }
  public void setClassNo(int classNo) {
    this.classNo = classNo;
  }
  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
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
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
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
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }



}
