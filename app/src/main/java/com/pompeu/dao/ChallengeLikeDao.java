package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.ChallengeLike;

@Mapper
public interface ChallengeLikeDao {

  int countAll();

  List<ChallengeLike> findAll();

  int insert(ChallengeLike challengelike);

  List<ChallengeLike> findByNo(ChallengeLike challengelike);

  int update(ChallengeLike challengelike);

  int delete(ChallengeLike challengelike);

}











