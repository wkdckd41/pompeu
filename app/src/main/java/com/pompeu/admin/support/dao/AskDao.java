package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Ask;
import com.pompeu.domain.FileNames;

@Mapper
public interface AskDao {

  int countAll();

  List<Ask> findAll(Ask ask);

  List<Ask> userFindAll(Ask ask);

  List<FileNames> findByFNamesNo(int no);

  int insert(Ask ask);

  Ask findByNo(int no);

  int update(Ask ask);

  int delete(int no);

  int fileRemove(Ask ask);

}
