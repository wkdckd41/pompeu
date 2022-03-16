package com.pompeu.domain;

public class Creator {

  int no;
  String info;
  String bank;
  String account;

  @Override
  public String toString() {
    return "Creator [no=" + no + ", info=" + info + ", bank=" + bank + ", account=" + account + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getInfo() {
    return info;
  }
  public void setInfo(String info) {
    this.info = info;
  }
  public String getBank() {
    return bank;
  }
  public void setBank(String bank) {
    this.bank = bank;
  }
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

}
