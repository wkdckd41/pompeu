package com.pompeu.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class PartyUser {

  int usersNo;
  int partyNo;
  Date joinDate;
}
