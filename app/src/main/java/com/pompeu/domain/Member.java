package com.pompeu.domain;

public class Member {

  int no;
  String name;
  String email;
  String phone;
  String nickName;
  int useCheck;
  java.sql.Date loginDate;
  java.sql.Date joinDate;
  java.sql.Date modifyDate;
  int adminCheck;
  String password;
  String birth;
  int gender;
  int snsNo;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", phone=" + phone
        + ", nickName=" + nickName + ", useCheck=" + useCheck + ", loginDate=" + loginDate
        + ", joinDate=" + joinDate + ", modifyDate=" + modifyDate + ", adminCheck=" + adminCheck
        + ", password=" + password + ", birth=" + birth + ", gender=" + gender + ", snsNo=" + snsNo
        + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public int getUseCheck() {
    return useCheck;
  }
  public void setUseCheck(int useCheck) {
    this.useCheck = useCheck;
  }
  public java.sql.Date getLoginDate() {
    return loginDate;
  }
  public void setLoginDate(java.sql.Date loginDate) {
    this.loginDate = loginDate;
  }
  public java.sql.Date getJoinDate() {
    return joinDate;
  }
  public void setJoinDate(java.sql.Date joinDate) {
    this.joinDate = joinDate;
  }
  public java.sql.Date getModifyDate() {
    return modifyDate;
  }
  public void setModifyDate(java.sql.Date modifyDate) {
    this.modifyDate = modifyDate;
  }
  public int getAdminCheck() {
    return adminCheck;
  }
  public void setAdminCheck(int adminCheck) {
    this.adminCheck = adminCheck;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getBirth() {
    return birth;
  }
  public void setBirth(String birth) {
    this.birth = birth;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public int getSnsNo() {
    return snsNo;
  }
  public void setSnsNo(int snsNo) {
    this.snsNo = snsNo;
  }



}
