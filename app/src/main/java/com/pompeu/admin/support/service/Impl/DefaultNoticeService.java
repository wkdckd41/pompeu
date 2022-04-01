package com.pompeu.admin.support.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.support.dao.NoticeDao;
import com.pompeu.admin.support.service.NoticeService;
import com.pompeu.domain.Notice;

@Service
public class DefaultNoticeService implements NoticeService{

  @Autowired
  NoticeDao noticeDao;

  @Override
  public int add(Notice notice) {
    return noticeDao.insert(notice);
  }

  @Override
  public List<Notice> list(Notice notice) { //서비스에서 넘어온 객체
    return noticeDao.findAll(notice); //noticeDao에 findAll 매서드를 호출하면서 notice 객체를 가지고간다
  }

  @Override
  public Notice get(int no) {
    return noticeDao.findByNo(no);
  }

  @Override
  public int update(Notice notice) {
    return noticeDao.update(notice);
  }

  @Override
  public int delete(int no) {
    return noticeDao.delete(no);
  }

  @Override
  public int deleteAll(String str) {
    String[] strArray = str.split(",");
    int result = 0;
    for(int i=0; i< strArray.length; i++) {      
      result = noticeDao.delete(Integer.parseInt(strArray[i]));

      if(result == 0) {
        return 0;
      }
    }
    return result;
  }

}
