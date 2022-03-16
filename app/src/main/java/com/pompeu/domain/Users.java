package com.pompeu.domain;

public class Users {

  int no;
  String image;
  String exTypeName;

  @Override
  public String toString() {
    return "Users [no=" + no + ", image=" + image + ", exTypeName=" + exTypeName + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public String getExTypeName() {
    return exTypeName;
  }
  public void setExTypeName(String exTypeName) {
    this.exTypeName = exTypeName;
  }

}
