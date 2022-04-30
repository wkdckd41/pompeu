package com.pompeu.user.party.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyClaim;
import com.pompeu.domain.PartyIntro;
import com.pompeu.domain.PartyUser;
import com.pompeu.domain.PartyWishlist;


@Mapper
public interface UserPartyDao {

  /**
   * 소모임 목록 총 갯수
   * @return
   */
  int countAll();

  /**
   * 소모임 목록
   * @return
   */
  List<Party> findAll(@Param("region") String region, @Param("sort") String sort,
      @Param("inOutEx") String inOutEx);

  /**
   * 소모임 등록
   * @param party
   * @return
   */
  int insert(Party party);

  /**
   * 소모임 참가
   * @param partyuser
   * @return
   */
  int crewInsert(PartyUser partyuser);

  /**
   * 소모임 찜하기
   * @param parywishlist
   * @return
   */
  int wishlistInsert(PartyWishlist partywishlist);

  /**
   * 소모임 신고
   * @param partyclaim
   * @return
   */
  int claimInsert(PartyClaim partyclaim);

  /**
   * 소모임 상세
   * @param no
   * @return
   */
  List<PartyIntro> findByNo(int no);

  /**
   * 소모임 수정
   * @param party
   * @return
   */
  int update(Party party);

  /**
   * 소모임 삭제
   * @param no
   * @return
   */
  int delete(int no);

  /**
   * 운동 Tag 목록 가져오기
   * @return
   */
  List<Party> findByExTag(Party party);

  /**
   * 주소 가져오기
   * @param no
   * @return
   */
  List<Party> mapping(int no);

  /**
   * 주소 Tag 가져오기
   * @param no
   * @return
   */
  List<Party> siSep(int no);

}

