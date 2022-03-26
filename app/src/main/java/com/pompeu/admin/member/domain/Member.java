package com.pompeu.admin.member.domain;

import java.sql.Date;



public class Member {

  int no;
  int memberTypeNo;
  String name;
  String email;
  String phone;
  String birth;
  String nickName;
  int gender;
  int password;
  Date joinDate;
  Date loginDate;
  Date modifyDate;
  int useCheck;
  int adminCheck;
  int snsNo;

  @Override
  public String toString() {
    return "Member [no=" + no + ", memberTypeNo=" + memberTypeNo + ", name=" + name + ", email="
        + email + ", phone=" + phone + ", birth=" + birth + ", nickName=" + nickName + ", gender="
        + gender + ", password=" + password + ", joinDate=" + joinDate + ", loginDate=" + loginDate
        + ", modifyDate=" + modifyDate + ", useCheck=" + useCheck + ", adminCheck=" + adminCheck
        + ", snsNo=" + snsNo + "]";
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
  public String getBirth() {
    return birth;
  }
  public void setBirth(String birth) {
    this.birth = birth;
  }
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
  }
  public Date getJoinDate() {
    return joinDate;
  }
  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }
  public Date getLoginDate() {
    return loginDate;
  }
  public void setLoginDate(Date loginDate) {
    this.loginDate = loginDate;
  }
  public Date getModifyDate() {
    return modifyDate;
  }
  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }
  public int getUseCheck() {
    return useCheck;
  }
  public void setUseCheck(int useCheck) {
    this.useCheck = useCheck;
  }
  public int getAdminCheck() {
    return adminCheck;
  }
  public void setAdminCheck(int adminCheck) {
    this.adminCheck = adminCheck;
  }
  public int getSnsNo() {
    return snsNo;
  }
  public void setSnsNo(int snsNo) {
    this.snsNo = snsNo;
  }

}
