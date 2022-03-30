package com.pompeu.admin.support.service;

import java.util.List;
import com.pompeu.domain.Notice;

public interface NoticeService {

  int add(Notice notice);

  List<Notice> list();

  Notice get(int no);

  int update(Notice notice);

  int delete(int no);

  int increaseViewCount(int no);
}

