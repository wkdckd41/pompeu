package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class myclassList {

  int myclassListNo;
  int usersNo;
  int classTimeNo;
  int registerMember;
  int payStatus;
  String content;
  Date registerDate;
  double rate;

}
