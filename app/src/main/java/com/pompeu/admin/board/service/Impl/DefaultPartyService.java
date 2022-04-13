package com.pompeu.admin.board.service.Impl;

import java.util.List;
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
  public List<Party> list(Party party) {
    return partyDao.findAll(party);
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


}