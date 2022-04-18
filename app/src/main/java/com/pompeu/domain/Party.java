package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Party {

  int partyNo;
  int locationNo;
  String title;
  String content;
  Date registerDate;
  Date startDate;
  Date endDate;
  String inOutEx;
  int maxMember;
  Date modifyDate;


  PartyClaim partyClaim;
  Member member;
  String searchType;
  String dateType;
  String tag;

}
