package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Ask;

@Mapper
public interface AskDao {

  int countAll();

  List<Ask> findAll();

  int insert(Ask ask);

  Ask findByNo(int no);

  int update(Ask ask);

  int delete(int no);
}
