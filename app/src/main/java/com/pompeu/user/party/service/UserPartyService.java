package com.pompeu.user.party.service;

import java.util.List;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyIntro;

public interface UserPartyService {

  /**
   * 게시판 목록
   * @return
   */
  List<Party> list(String sort, String inOutEx);

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
  List<PartyIntro> get(int no);

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

  /**
   *  운동 Tag 목록 가져오기
   * @param no
   * @return
   */
  List<Party> tag(Party party);
}