package com.pompeu.domain;

public class MemberType {

  int memberTypeNo;
  int memberType;

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
  public int getMemberType() {
    return memberType;
  }
  public void setMemberType(int memberType) {
    this.memberType = memberType;
  }




}
