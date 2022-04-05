package com.pompeu.admin.board.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.board.dao.PartyDao;
import com.pompeu.admin.board.service.PartyService;
import com.pompeu.domain.Party;

@Service
public class DefaultPartyService implements PartyService{

  @Autowired
  PartyDao partyDao;

  @Override
  public List<Party> list() {
    return partyDao.findAll();
  }

  @Override
  public int add(Party party) {
    return partyDao.insert(party);
  }

  @Override
  public Party get(int no) {
    return partyDao.findByNo(no);
  }

  @Override
  public int update(Party party) {
    return partyDao.update(party);
  }

  @Override
  public int delete(int no) {
    return partyDao.delete(no);
  }

  @Override
  public List<Party> srchParty(Party party) {
    return partyDao.srchParty(party);
  }

  @Override
  public List<Map<Object, Object>> findPartyClaim() {
    return partyDao.findPartyClaim();
  }

  @Override
  public List<Map<Object, Object>> findPartyList() {
    return partyDao.findPartyList();
  }



}