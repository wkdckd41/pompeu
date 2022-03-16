package com.pompeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.UsersDao;
import com.pompeu.domain.Users;

@RestController 
public class UsersController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UsersController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  UsersDao usersDao;

  @RequestMapping("/users/list")
  public Object list() {
    return usersDao.findAll();
  }

  @RequestMapping("/users/add")
  public Object add(Users users) {
    return usersDao.insert(users);
  }


  @RequestMapping("/users/get")
  public Object get(int no) {
    Users users = usersDao.findByNo(no);
    if (users == null) {
      return "";
    }
    return users;
  }

  @RequestMapping("/users/update")
  public Object update(Users users) {
    return usersDao.update(users);
  }

  @RequestMapping("/users/delete")
  public Object delete(int no) {
    return usersDao.delete(no);
  }

}
