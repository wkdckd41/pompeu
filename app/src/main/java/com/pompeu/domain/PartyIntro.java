package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class PartyIntro {
  private int partyNo;
  private int locationNo;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private int maxMember;
  private String tag;
  private String name;
}
