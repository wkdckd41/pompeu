package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class LectureTime {

  int no;
  int classNo;
  Date startTime;
  Date endTime;
  int maxMember;
  int noMember;

}
