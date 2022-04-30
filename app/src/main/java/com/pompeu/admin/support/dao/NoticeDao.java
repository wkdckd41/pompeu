package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.FileNames;
import com.pompeu.domain.Notice;

@Mapper
public interface NoticeDao {

  int countAll();

  List<Notice> findAll( @Param("memberTypeNo") int memberTypeNo, @Param("rowCount") int rowCount, @Param("offset") int offset); // Dao에서 객체를 받음 

  int insert(Notice notice);

  int insertFiles(@Param("noticeNo") int noticeNo, @Param("fNames") List<FileNames> fNames);

  Notice findByNo(int no);

  List<FileNames> findByFNamesNo(int no);

  int update(Notice notice);

  int delete(int no);

  int deleteAll(String str);

  int fileRemove(Notice notice);

}




