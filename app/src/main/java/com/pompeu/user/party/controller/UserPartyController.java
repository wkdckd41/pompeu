package com.pompeu.user.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pompeu.domain.Party;
import com.pompeu.user.party.dao.UserPartyDao;

//@RestController 
public class UserPartyController {


  @Autowired
  UserPartyDao UserPartyDao;

  /**
   * 게시판 목록
   * @return
   */
  @RequestMapping("/party/list")
  public Object list() {
    return UserPartyDao.findAll();
  }

  /**
   * 게시판 등록
   * @param party
   * @return
   */
  @RequestMapping("/party/add")
  public Object add(Party party) {
    return UserPartyDao.insert(party);
  }

  /**
   * 게시판 상세
   * @param no
   * @return
   */
  @RequestMapping("/party/get")
  public Object get(int no) {
    Party party = UserPartyDao.findByNo(no);
    return party != null ? party : "";
  }

  /**
   * 게시판 수정
   * @param party
   * @return
   */
  @RequestMapping("/party/update")
  public Object update(Party party) {
    return UserPartyDao.update(party);
  }

  /**
   * 게시판 삭제
   * @param no
   * @return
   */
  @RequestMapping("/party/delete")
  public Object delete(int no) {
    return UserPartyDao.delete(no);
  }


}