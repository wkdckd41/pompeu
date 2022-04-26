package com.pompeu.admin.support.service;

import java.util.List;
import com.pompeu.domain.Ask;
import com.pompeu.domain.FileNames;

public interface AskService {

  int add(Ask ask);

  List<Ask> list(Ask ask);

  List<Ask> userList(Ask ask);

  Ask get(int no);

  List<FileNames> getFNames(int no);

  int update(Ask ask);

  int delete(int no);

  int deleteAll(String str);

  int fileRemove(Ask ask);

}
