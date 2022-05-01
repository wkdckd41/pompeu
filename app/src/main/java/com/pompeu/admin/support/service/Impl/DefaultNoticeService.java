package com.pompeu.admin.support.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.support.dao.NoticeDao;
import com.pompeu.admin.support.service.NoticeService;
import com.pompeu.domain.FileNames;
import com.pompeu.domain.Notice;

@Service
public class DefaultNoticeService implements NoticeService{

  @Autowired
  NoticeDao noticeDao;

  @Override
  public int add(Notice notice) {
    System.out.println("memberTypeNos : " + notice.getMemberTypeNo() +  " names: " + notice.getName() +  " criticalChecks:" +  notice.getCriticalCheck() + " contents:"  + notice.getContent());
    int rs = noticeDao.insert(notice);

    System.out.println("A# : " + notice.getNo());
    System.out.println("B# : " + notice.getFNames());
    if(notice.getFNames().size()!=0) {
      rs = noticeDao.insertFiles(notice.getNo(), notice.getFNames());

    }
    return rs;
  }

  @Override
  public List<Notice> list(Notice notice) { //서비스에서 넘어온 객체
    return noticeDao.findAll(notice.getMemberTypeNo(), notice.getPageSize(), ((notice.getPageNo() - 1) * notice.getPageSize())); //noticeDao에 findAll 매서드를 호출하면서 notice 객체를 가지고간다
  }

  @Override
  public int size(Notice notice) {
    return noticeDao.countAll(notice);
  }  

  @Override
  public Notice get(int no) {
    return noticeDao.findByNo(no);
  }

  @Override
  public List<FileNames> getFNames(int no) {
    return noticeDao.findByFNamesNo(no);
  }

  @Override
  public int update(Notice notice) {

    int rs = noticeDao.update(notice);

    if(notice.getFNames().size()!=0) {
      rs = noticeDao.insertFiles(notice.getNo(), notice.getFNames());

      System.out.println("getFnamesSize : " + notice.getFNames().size());
    }
    return rs;
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

  @Override
  public int fileRemove(Notice notice) {
    return noticeDao.fileRemove(notice);
  }

}
