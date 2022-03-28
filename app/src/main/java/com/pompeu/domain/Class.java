package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;
@Data
public class Class {

  int no;
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

}
