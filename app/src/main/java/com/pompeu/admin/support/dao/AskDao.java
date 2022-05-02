package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Ask;

@Mapper
public interface AskDao {

  int countAll(Ask ask);

  List<Ask> findAll( @Param("memberTypeNo") int memberTypeNo, @Param("rowCount") int rowCount, @Param("offset") int offset);

  List<Ask> userFindAll( @Param("memberNo") int memberNo, @Param("memberTypeNo") int memberTypeNo, @Param("rowCount") int rowCount, @Param("offset") int offset);

  int insert(Ask ask);

  int userInsert(Ask ask);

  Ask findByNo(int no);

  int update(Ask ask);

  int delete(int no);


}
