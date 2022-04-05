package com.pompeu.user.party.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pompeu.domain.Party;
import com.pompeu.user.party.dao.UserPartyDao;
import com.pompeu.user.party.service.UserPartyService;

@Service
public class DefaultUserPartyService implements UserPartyService{

  @Autowired
  UserPartyDao userPartyDao;

  @Override
  public List<Party> list() {
    return userPartyDao.findAll();
  }

  @Override
  @Transactional
  public int add(Party party) {
    return userPartyDao.insert(party);
  }

  @Override
  public Party get(int no) {
    return userPartyDao.findByNo(no);
  }

  @Override
  @Transactional
  public int update(Party party) {
    return userPartyDao.update(party);
  }

  @Override
  @Transactional
  public int delete(int no) {
    return userPartyDao.delete(no);
  }

}