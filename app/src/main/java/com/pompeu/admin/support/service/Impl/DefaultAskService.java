package com.pompeu.admin.support.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.support.dao.AskDao;
import com.pompeu.admin.support.service.AskService;
import com.pompeu.domain.Ask;

@Service
public class DefaultAskService implements AskService{

  @Autowired
  AskDao askDao;

  @Override
  public int add(Ask ask) {
    return askDao.insert(ask);
  }

  @Override
  public List<Ask> list() {
    return askDao.findAll();
  }

  @Override
  public Ask get(int no) {
    return askDao.findByNo(no);
  }

  @Override
  public int update(Ask ask) {
    return askDao.update(ask);
  }

  @Override
  public int delete(int no) {
    return askDao.delete(no);
  }

}
