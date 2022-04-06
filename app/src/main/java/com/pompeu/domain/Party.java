package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Party {

  int partyNo;
  int locationNo;
  String name;
  String content;
  Date registerDate;
  Date startDate;
  Date endDate;
  int maxMember;
  int inOutEx;
  Date modifyDate;

  PartyClaim partyClaim;
  Member member;
  String searchType;


}
