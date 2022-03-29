package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Party {

  int no;
  int locationNo;
  String name;
  String content;
  Date registerDate;
  Date startDate;
  Date endDate;
  int maxMember;
  int inOutEx;
  Date modifyDate;




}
