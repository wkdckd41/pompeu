package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class ClassTime {

  int no;
  int classNo;
  Date startTime;
  Date endTime;
  int maxMember;

}
