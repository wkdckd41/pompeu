package com.pompeu.user.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pompeu.domain.Party;
import com.pompeu.user.party.dao.UserPartyDao;

//@RestController 
public class UserPartyController {


  @Autowired
  UserPartyDao UserPartyDao;

  @RequestMapping("/party/list")
  public Object list() {
    return UserPartyDao.findAll();
  }

  @RequestMapping("/party/add")
  public Object add(Party party) {
    return UserPartyDao.insert(party);
  }

  @RequestMapping("/party/get")
  public Object get(int no) {
    Party party = UserPartyDao.findByNo(no);
    return party != null ? party : "";
  }

  @RequestMapping("/party/update")
  public Object update(Party party) {
    return UserPartyDao.update(party);
  }

  @RequestMapping("/party/delete")
  public Object delete(int no) {
    return UserPartyDao.delete(no);
  }


}