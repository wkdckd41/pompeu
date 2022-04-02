package com.pompeu.domain;

public class LectureWishlist {

  int usersNo;
  int classNo;

  @Override
  public String toString() {
    return "ClassWishlist [usersNo=" + usersNo + ", classNo=" + classNo + "]";
  }

  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }
  public int getClassNo() {
    return classNo;
  }
  public void setClassNo(int classNo) {
    this.classNo = classNo;
  }



}
