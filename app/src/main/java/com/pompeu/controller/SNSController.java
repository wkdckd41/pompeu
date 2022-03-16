package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.SNSDao;
import com.pompeu.domain.SNS;

@RestController 
public class SNSController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 SNSController 객체를 만들 때 SNSDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  SNSDao snsDao;

  @RequestMapping("/sns/list")
  public Object list() {
    return snsDao.findAll();
  }

  @RequestMapping("/sns/add")
  public Object add(SNS sns) {
    return snsDao.insert(sns);
  }


  @RequestMapping("/sns/get")
  public Object get(int no) {
    SNS sns = snsDao.findByNo(no);
    if (sns == null) {
      return "";
    }
    return sns;
  }

  @RequestMapping("/sns/update")
  public Object update(SNS sns) {
    return snsDao.update(sns);
  }

  @RequestMapping("/sns/delete")
  public Object delete(int no) {
    return snsDao.delete(no);
  }

}
