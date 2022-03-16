package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.Users;

@Mapper
public interface UsersDao {

  int countAll();

  List<Users> findAll();

  int insert(Users users);

  Users findByNo(int no);

  int update(Users users);

  int delete(int no);

}











