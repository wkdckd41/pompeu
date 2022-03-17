package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Ask;

@Mapper
public interface AskDao {

  int countAll();

  List<Ask> usersFindAll();

  List<Ask> creatorFindAll();

  int insert(Ask ask);

  Ask usersFindByNo(int no);

  Ask creatorFindByNo(int no);

  int askUpdate(Ask ask);

  int answer(Ask ask);

  int answerUpdate(Ask ask);

  int delete(int no);

}


