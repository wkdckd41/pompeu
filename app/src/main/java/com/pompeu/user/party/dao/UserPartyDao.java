package com.pompeu.user.party.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyIntro;


@Mapper  
public interface UserPartyDao {

  /**
   * 게시판 목록 총 갯수
   * @return
   */
  int countAll();

  /**
   * 게시판 목록
   * @return
   */
  List<Party> findAll(@Param("sort") String sort, @Param("inOutEx") String inOutEx);

  /**
   * 게시판 등록
   * @param party
   * @return
   */
  int insert(Party party);

  /**
   * 게시판 상세
   * @param no
   * @return
   */
  List<PartyIntro> findByNo(int no);

  /**
   * 게시판 수정
   * @param party
   * @return
   */
  int update(Party party);

  /**
   * 게시판 삭제
   * @param no
   * @return
   */
  int delete(int no);

  /**
   * 이미지 파일명 가져오기
   * @param no
   * @return
   */
  List<Party> addImage(int no);

  /**
   * 운동 Tag 목록 가져오기
   * @return
   */
  List<Party> findByExTag(Party party);
}

