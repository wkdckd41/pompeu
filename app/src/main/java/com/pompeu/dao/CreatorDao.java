package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Creator;

@Mapper
public interface CreatorDao {

  int countAll();

  List<Creator> findAll();

  int insert(Creator creator);

  Creator findByNo(int no);

  int update(Creator creator);

  int delete(int no);

}




