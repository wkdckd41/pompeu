package com.pompeu.domain;

public class ChallengeClaim {

  int cno;
  int uno;
  int status;

  @Override
  public String toString() {
    return "ChallengeClaim [cno=" + cno + ", uno=" + uno + ", status=" + status + "]";
  }

  public int getCno() {
    return cno;
  }
  public void setCno(int cno) {
    this.cno = cno;
  }
  public int getUno() {
    return uno;
  }
  public void setUno(int uno) {
    this.uno = uno;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }


}
