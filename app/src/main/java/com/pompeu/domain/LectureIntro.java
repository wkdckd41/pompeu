package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class LectureIntro {
  private String lectureInfo;
  private String info;
  private String content;
  private String askContent;
  private Date registerDate;
}
