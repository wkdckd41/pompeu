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
  int maxMember;
  String inOutEx;
  Date modifyDate;
  String image;

  PartyClaim partyClaim;
  Member member;
  String searchType;
  String tag;
}
