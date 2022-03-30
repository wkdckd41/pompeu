package com.pompeu.admin.support.service;

import java.util.List;
import com.pompeu.domain.Ask;

public interface AskService {

  int add(Ask ask);

  List<Ask> list();

  Ask get(int no);

  int update(Ask ask);

  int delete(int no);
}
