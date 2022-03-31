package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Notice;

@Mapper
public interface NoticeDao {

  int countAll();

  List<Notice> findAll();

  int insert(Notice notice);

  Notice findByNo(int no);

  int update(Notice notice);

  int delete(int no);


}




