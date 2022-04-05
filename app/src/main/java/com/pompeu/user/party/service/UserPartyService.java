package com.pompeu.user.party.service;

import java.util.List;
import com.pompeu.domain.Party;

public interface UserPartyService {

  /**
   * 게시판 목록
   * @return
   */
  List<Party> list();

  /**
   * 게시판 등록
   * @param party
   * @return
   */
  int add(Party party);

  /**
   * 게시판 상세
   * @param no
   * @return
   */
  Party get(int no);

  /**
   * 게시판 수정
   * @param party
   * @return
   */
  int update(Party party);

  /**
   * 게시판 삭제
   */
  int delete(int no);
}