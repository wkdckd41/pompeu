package com.pompeu.domain;

public class MemberType {

  int memberTypeNo;
  String memberType;

  @Override
  public String toString() {
    return "MemberType [memberTypeNo=" + memberTypeNo + ", memberType=" + memberType + "]";
  }
  public int getMemberTypeNo() {
    return memberTypeNo;
  }
  public void setMemberTypeNo(int memberTypeNo) {
    this.memberTypeNo = memberTypeNo;
  }
  public String getMemberType() {
    return memberType;
  }
  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }



}
