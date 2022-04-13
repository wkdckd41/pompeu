package com.pompeu.admin.board.service;

import java.util.List;
import com.pompeu.domain.Party;

public interface PartyService {

  List<Party> list(Party party);

  int add(Party party);

  Party get(int no);

  int update(Party party);

  int delete(int no);


}