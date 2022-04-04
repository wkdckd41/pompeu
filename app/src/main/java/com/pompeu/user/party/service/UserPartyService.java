package com.pompeu.user.party.service;

import java.util.List;
import com.pompeu.domain.Party;

public interface UserPartyService {

  List<Party> list();

  int add(Party party);

  Party get(int no);

  int update(Party party);

  int delete(int no);
}
