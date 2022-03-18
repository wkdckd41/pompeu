package com.pompeu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.ClassWishlistDao;
import com.pompeu.domain.ClassWishlist;


@RestController 
public class ClassWishlistController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UsersController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  ClassWishlistDao classWishlistDao;

  @RequestMapping("/classWishlist/list")
  public Object list() {
    return classWishlistDao.findAll();
  }

  @RequestMapping("/classWishlist/add")
  public Object add(ClassWishlist classwishlist) {
    return classWishlistDao.insert(classwishlist);
  }


  @RequestMapping("/classWishlist/get")
  public Object get(ClassWishlist classwishlist) {
    List<ClassWishlist> like = classWishlistDao.findByNo(classwishlist);
    if (like == null) {
      return "";
    }
    return like;
  }

  //  @RequestMapping("/classWishlist/update")
  //  public Object update(ClassWishlist classwishlist) {
  //    return classWishlistDao.update(classwishlist);
  //  }

  @RequestMapping("/classWishlist/delete")
  public Object delete(ClassWishlist classwishlist) {
    return classWishlistDao.delete(classwishlist);
  }

}
