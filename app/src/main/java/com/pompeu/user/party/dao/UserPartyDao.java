package com.pompeu.user.party.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Party;


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
  List<Party> findAll(Party party);

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
  Party findByNo(int no);

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

}