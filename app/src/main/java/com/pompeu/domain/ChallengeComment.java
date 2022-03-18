package com.pompeu.domain;

public class ChallengeComment {

  int no;
  int challengeNo;
  int usersNo;
  String content;


  @Override
  public String toString() {
    return "ChallengeComment [no=" + no + ", challengeNo=" + challengeNo + ", usersNo=" + usersNo
        + ", content=" + content + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getChallengeNo() {
    return challengeNo;
  }
  public void setChallengeNo(int challengeNo) {
    this.challengeNo = challengeNo;
  }
  public int getUsersNo() {
    return usersNo;
  }
  public void setUsersNo(int usersNo) {
    this.usersNo = usersNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }





}
