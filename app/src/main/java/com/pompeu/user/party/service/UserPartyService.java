package com.pompeu.user.party.service;

import java.util.List;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyClaim;
import com.pompeu.domain.PartyIntro;
import com.pompeu.domain.PartyUser;
import com.pompeu.domain.PartyWishlist;

public interface UserPartyService {

  /**
   * 소모임 목록
   * @return
   */
  List<Party> list(String region, String sort, String inOutEx);

  /**
   * 소모임 등록
   * @param party
   * @return
   */
  int add(Party party);

  /**
   * 소모임 참가
   * @param partyuser
   * @return
   */
  int crewAdd(PartyUser partyuser);

  /**
   * 소모임 찜하기
   * @param parywishlist
   * @return
   */
  int wishlistAdd(PartyWishlist partywishlist);

  /**
   * 소모임 신고
   * @param partyclaim
   * @return
   */
  int claimAdd(PartyClaim partyclaim);

  /**
   * 소모임 상세
   * @param no
   * @return
   */
  List<PartyIntro> get(int no);

  /**
   * 소모임 수정
   * @param party
   * @return
   */
  int update(Party party);

  /**
   * 소모임 삭제
   */
  int delete(int no);

  /**
   *  운동 Tag 목록 가져오기
   * @param no
   * @return
   */
  List<Party> tag(Party party);

  /**
   * 주소 가져오기
   * @param no
   * @return
   */
  List<Party> map(int no);

  /**
   * 주소 Tag 가져오기
   * @param no
   * @return
   */
  List<Party> si(int no);
}