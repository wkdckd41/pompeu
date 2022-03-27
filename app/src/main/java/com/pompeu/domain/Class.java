package com.pompeu.domain;

import java.sql.Date;

public class Class {

  int classNo;
  int locationNo;
  int creatorNo;
  int exNo;
  String name;
  Date startDate;
  Date endDate;
  int classPrice;
  String classInfo;
  Date registerDate;
  int status;
  String adminMessage;
  double totalRate;
  int inOutEx;

  @Override
  public String toString() {
    return "Class [classNo=" + classNo + ", locationNo=" + locationNo + ", creatorNo=" + creatorNo
        + ", exNo=" + exNo + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
        + ", classPrice=" + classPrice + ", classInfo=" + classInfo + ", registerDate="
        + registerDate + ", status=" + status + ", adminMessage=" + adminMessage + ", totalRate="
        + totalRate + ", inOutEx=" + inOutEx + "]";
  }

  public int getClassNo() {
    return classNo;
  }
  public void setClassNo(int classNo) {
    this.classNo = classNo;
  }
  public int getLocationNo() {
    return locationNo;
  }
  public void setLocationNo(int locationNo) {
    this.locationNo = locationNo;
  }
  public int getCreatorNo() {
    return creatorNo;
  }
  public void setCreatorNo(int creatorNo) {
    this.creatorNo = creatorNo;
  }
  public int getExNo() {
    return exNo;
  }
  public void setExNo(int exNo) {
    this.exNo = exNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getClassPrice() {
    return classPrice;
  }
  public void setClassPrice(int classPrice) {
    this.classPrice = classPrice;
  }
  public String getClassInfo() {
    return classInfo;
  }
  public void setClassInfo(String classInfo) {
    this.classInfo = classInfo;
  }
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getAdminMessage() {
    return adminMessage;
  }
  public void setAdminMessage(String adminMessage) {
    this.adminMessage = adminMessage;
  }
  public double getTotalRate() {
    return totalRate;
  }
  public void setTotalRate(double totalRate) {
    this.totalRate = totalRate;
  }
  public int getInOutEx() {
    return inOutEx;
  }
  public void setInOutEx(int inOutEx) {
    this.inOutEx = inOutEx;
  }


}
