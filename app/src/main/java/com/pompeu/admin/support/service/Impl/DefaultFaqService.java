package com.pompeu.admin.support.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.support.dao.FaqDao;
import com.pompeu.admin.support.service.FaqService;
import com.pompeu.domain.Faq;

@Service
public class DefaultFaqService implements FaqService{

  @Autowired
  FaqDao faqDao;

  @Override
  public int add(Faq faq) {
    return faqDao.insert(faq);
  }

  @Override
  public List<Faq> list() {
    return faqDao.findAll();
  }

  @Override
  public Faq get(int no) {
    return faqDao.findByNo(no);
  }

  @Override
  public int update(Faq faq) {
    return faqDao.update(faq);
  }

  @Override
  public int delete(int no) {
    return faqDao.delete(no);
  }

}
