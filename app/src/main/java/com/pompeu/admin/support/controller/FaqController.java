package com.pompeu.admin.support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.support.service.FaqService;
import com.pompeu.domain.Faq;

@RestController 
public class FaqController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  FaqService faqService;

  @RequestMapping("/faq/list")
  public Object list() {
    return faqService.list();
  }

  @RequestMapping("/faq/add")
  public Object add(Faq faq) {
    return faqService.add(faq);
  }


  @RequestMapping("/faq/get")
  public Object get(int no) {
    Faq faq = faqService.get(no);
    if (faq == null) {
      return "";
    }
    return faq;
  }

  @RequestMapping("/faq/update")
  public Object update(Faq faq) {
    return faqService.update(faq);
  }

  @RequestMapping("/faq/delete")
  public Object delete(int no) {
    return faqService.delete(no);
  }

}
