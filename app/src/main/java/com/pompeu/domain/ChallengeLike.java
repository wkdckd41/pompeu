package com.pompeu.domain;

public class ChallengeLike {

  int usersNo;
  int challengeNo;

  @Override
  public String toString() {
    return "ChallengeLike [usersNo=" + usersNo + ", challengeNo=" + challengeNo + "]";
  }

  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }
  public int getChallengeNo() {
    return challengeNo;
  }
  public void setChallengeNo(int challengeNo) {
    this.challengeNo = challengeNo;
  }



}
