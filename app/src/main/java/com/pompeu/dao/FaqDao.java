package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Faq;
import com.pompeu.domain.Member;

@Mapper
public interface FaqDao {

  int countAll();

  List<Member> findAll();

  int insert(Faq faq);

  Member findByNo(int no);

  int update(Faq faq);

  int delete(int no);

}




