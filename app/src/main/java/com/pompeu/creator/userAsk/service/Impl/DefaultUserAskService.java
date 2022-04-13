package com.pompeu.creator.userAsk.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.creator.userAsk.dao.UserAskDao;
import com.pompeu.creator.userAsk.service.UserAskService;
import com.pompeu.domain.Lecture;

@Service
public class DefaultUserAskService implements UserAskService{

  @Autowired
  UserAskDao userAskDao;

  @Override
  public List<Lecture> list() {
    return userAskDao.findAll();
  }
}