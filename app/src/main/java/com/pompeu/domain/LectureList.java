package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class LectureList {
  int lectureNo;
  String creatorWriter;
  String classTitle;
  Date startDate;
  Date endDate;
  int status;
  Date registerDate;
  String times_check;
  String upload_img;
}