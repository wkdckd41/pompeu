package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.CreatorDao;
import com.pompeu.domain.Creator;

@RestController 
public class CreatorController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 CreatorController 객체를 만들 때 CreatorDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  CreatorDao creatorDao;

  @RequestMapping("/creator/list")
  public Object list() {
    return creatorDao.findAll();
  }

  @RequestMapping("/creator/add")
  public Object add(Creator creator) {
    return creatorDao.insert(creator);
  }


  @RequestMapping("/creator/get")
  public Object get(int no) {
    Creator creator = creatorDao.findByNo(no);
    if (creator == null) {
      return "";
    }
    return creator;
  }

  @RequestMapping("/creator/update")
  public Object update(Creator creator) {
    return creatorDao.update(creator);
  }

  @RequestMapping("/creator/delete")
  public Object delete(int no) {
    return creatorDao.delete(no);
  }

}
