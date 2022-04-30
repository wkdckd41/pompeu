package com.pompeu.admin.support.service;

import java.util.List;
import com.pompeu.domain.Faq;

public interface FaqService {

  int add(Faq faq);

  List<Faq> list(Faq faq);

  List<Faq> userList(Faq faq);

  Faq get(int no);

  int update(Faq faq);

  int delete(int no);

  int deleteAll(String str);

}
