package com.pompeu.user.party.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Party;
import com.pompeu.user.party.dao.UserPartyDao;

@RestController 
public class UserPartyController {

  // log를 출력하는 도구 준비
  private static final Logger log = LoggerFactory.getLogger(UserPartyController.class);

  @Autowired
  UserPartyDao userPartyDao;

  /**
   * 게시판 목록
   * @return
   */
  @RequestMapping("/userparty/list")
  public Object list() {
    log.info("게시글 목록조회!"); // 운영자가 확인하기를 원하는 정보
    List<Party> list =  userPartyDao.findAll();
    log.debug(list.toString()); // 개발자가 확인하기를 원하는 정보
    return list;
  }

  /**
   * 게시판 등록
   * @param party
   * @return
   */
  @RequestMapping("/userparty/add")
  public Object add(Party party) {
    return userPartyDao.insert(party);
  }

  /**
   * 게시판 상세
   * @param no
   * @return
   */
  @RequestMapping("/userparty/get")
  public Object get(int no) {
    Party party = userPartyDao.findByNo(no);
    return party != null ? party : "";
  }

  /**
   * 게시판 수정
   * @param party
   * @return
   */
  @RequestMapping("/userparty/update")
  public Object update(Party party) {
    return userPartyDao.update(party);
  }

  /**
   * 게시판 삭제
   * @param no
   * @return
   */
  @RequestMapping("/userparty/delete")
  public Object delete(int no) {
    return userPartyDao.delete(no);
  }


}