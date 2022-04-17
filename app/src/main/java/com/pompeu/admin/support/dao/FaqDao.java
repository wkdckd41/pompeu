package com.pompeu.admin.support.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Faq;

@Mapper
public interface FaqDao {

  int countAll();

  List<Faq> findAll(Faq faq);

  int insert(Faq faq);

  Faq findByNo(int no);

  int update(Faq faq);

  int delete(int no);

  int deleteAll(String str);

}




