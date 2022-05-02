package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pompeu.domain.Faq;

@Mapper
public interface FaqDao {

  int countAll(Faq faq);

  List<Faq> findAll( @Param("memberTypeNo") int memberTypeNo, @Param("rowCount") int rowCount, @Param("offset") int offset); // Dao에서 객체를 받음 

  List<Faq> userFindAll( @Param("memberTypeNo") int memberTypeNo, @Param("rowCount") int rowCount, @Param("offset") int offset); // Dao에서 객체를 받음 

  int insert(Faq faq);

  Faq findByNo(int no);

  int update(Faq faq);

  int delete(int no);

  int deleteAll(String str);

}




