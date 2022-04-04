package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class PartyClaim {

  int partyNo;
  int usersNo;
  int claimReasonNo;
  Date claimDate;
  int status;
}