package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Party;

@Mapper
public interface PartyDao {

  int countAll();

  List<Party> findAll();

  int insert(Party party);

  Party findByNo(int no);

  int update(Party party);

  int delete(int no);

}




