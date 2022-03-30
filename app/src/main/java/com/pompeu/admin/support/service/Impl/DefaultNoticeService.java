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
  public List<Notice> list() {
    return noticeDao.findAll();
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
    return 0;
  }

  @Override
  public int increaseViewCount(int no) {
    return noticeDao.increaseViewCount(no);
  }

}
