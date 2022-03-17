package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.FaqDao;
import com.pompeu.domain.Faq;

@RestController 
public class FaqController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  FaqDao faqDao;

  @RequestMapping("/faq/list")
  public Object list() {
    return faqDao.findAll();
  }

  @RequestMapping("/faq/add")
  public Object add(Faq faq) {
    return faqDao.insert(faq);
  }


  @RequestMapping("/faq/get")
  public Object get(int no) {
    Faq faq = faqDao.findByNo(no);
    if (faq == null) {
      return "";
    }
    return faq;
  }

  @RequestMapping("/faq/update")
  public Object update(Faq faq) {
    return faqDao.update(faq);
  }

  @RequestMapping("/faq/delete")
  public Object delete(int no) {
    return faqDao.delete(no);
  }

}
