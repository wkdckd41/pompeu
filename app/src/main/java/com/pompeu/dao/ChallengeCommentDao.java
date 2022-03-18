package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.ChallengeComment;

@Mapper
public interface ChallengeCommentDao {

  int countAll();

  List<ChallengeComment> findAll();

  int insert(ChallengeComment challengeComment);

  ChallengeComment findByNo(int no);

  int update(ChallengeComment challengeComment);

  int delete(int no);
}




