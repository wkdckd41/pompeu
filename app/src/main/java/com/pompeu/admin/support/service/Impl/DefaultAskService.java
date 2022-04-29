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
  public int userAdd(Ask ask) {
    System.out.println("service no : " + ask.getMemberNo());
    return askDao.userInsert(ask);
  }

  @Override
  public List<Ask> list(Ask ask) {
    return askDao.findAll(ask);
  }

  @Override
  public List<Ask> userList(Ask ask) {
    System.out.println("service no : " + ask.getMemberNo());
    return askDao.userFindAll(ask);
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

  @Override
  public int deleteAll(String str) {
    String[] strArray = str.split(",");
    int result = 0;
    for(int i=0; i< strArray.length; i++) {      
      result = askDao.delete(Integer.parseInt(strArray[i]));

      if(result == 0) {
        return 0;
      }
    }
    return result;
  }

}
