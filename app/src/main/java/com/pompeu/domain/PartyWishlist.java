package com.pompeu.domain;

public class PartyWishlist {

  int partyNo;
  int usersNo;

  @Override
  public String toString() {
    return "PartyWishlist [partyNo=" + partyNo + ", usersNo=" + usersNo + "]";
  }

  public int getPartyNo() {
    return partyNo;
  }
  public void setPartyNo(int partyNo) {
    this.partyNo = partyNo;
  }
  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }



}
