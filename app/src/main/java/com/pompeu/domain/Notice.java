package com.pompeu.domain;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Notice {

  int no;
  int memberTypeNo;
  String memberType;
  int criticalCheck;
  java.sql.Date registerDate;
  int viewCount;
  String name;
  String content;
  java.sql.Date modifyDate;
  List<FileNames> fNames;
}
