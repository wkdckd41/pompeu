package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.SNS;

@Mapper
public interface SNSDao {

  int countAll();

  List<SNS> findAll();

  int insert(SNS sns);

  SNS findByNo(int no);

  int update(SNS sns);

  int delete(int no);

}




