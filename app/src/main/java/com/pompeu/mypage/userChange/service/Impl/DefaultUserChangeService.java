package com.pompeu.mypage.userChange.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.domain.Member;
import com.pompeu.mypage.userChange.dao.UserChangeDao;
import com.pompeu.mypage.userChange.service.UserChangeService;

@Service
public class DefaultUserChangeService implements UserChangeService{

  @Autowired
  UserChangeDao userChangeDao;

  @Override
  public List<Member> list() {
    return userChangeDao.findAll();
  }

  @Override
  public int add(Member member) {
    return userChangeDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return userChangeDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return userChangeDao.update(member);
  }


  @Override
  public int delete(int no) {
    return userChangeDao.delete(no);
  }
}