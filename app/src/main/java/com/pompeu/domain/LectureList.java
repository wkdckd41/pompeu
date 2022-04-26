package com.pompeu.domain;

import java.sql.Date;
import java.util.List;
import lombok.Data;

@Data
public class LectureList {
  int lectureNo;
  String classTitle;
  Date startDate;
  Date endDate;
  int status;
  int maxMember;
  int membercount;
  List<LectureTime> times;
}