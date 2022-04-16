package com.pompeu.creator.userAsk.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Lecture;

@Mapper
public interface UserAskDao {

  List<Lecture> findAll();

  int insert(Lecture lecture);

  Lecture findByNo(int no);

  int update(Lecture lecture);

  int delete(int no);

  List<Lecture> askDrop(int no);

} 
