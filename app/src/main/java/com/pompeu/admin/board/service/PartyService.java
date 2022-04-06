package com.pompeu.admin.board.service;

import java.util.List;
import java.util.Map;
import com.pompeu.domain.Party;

public interface PartyService {

  List<Party> list(Party party);

  int add(Party party);

  Party get(int no);

  int update(Party party);

  int delete(int no);

  List<Party> srchParty(Party party);

  List<Map<Object, Object>> findPartyClaim();

  List<Map<Object, Object>> findPartyList();
}