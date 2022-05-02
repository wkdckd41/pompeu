package com.pompeu.admin.support.service;

import java.util.List;
import com.pompeu.domain.Ask;

public interface AskService {

  int add(Ask ask);

  int userAdd(Ask ask);

  List<Ask> list(Ask ask);

  List<Ask> userList(Ask ask);

  Ask get(int no);

  int update(Ask ask);

  int delete(int no);

  int deleteAll(String str);

  int size(Ask ask);

}
