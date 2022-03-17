package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.ChallengeClaim;

@Mapper
public interface ChallengeClaimDao {

  int countAll();

  List<ChallengeClaim> findAll();

  int insert(ChallengeClaim challengeclaim);

  ChallengeClaim findByNo(ChallengeClaim challengeclaim);

  int update(ChallengeClaim challengeclaim);

  int delete(ChallengeClaim challengeclaim);

}











