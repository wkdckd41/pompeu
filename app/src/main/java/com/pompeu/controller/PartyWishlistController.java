package com.pompeu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.dao.PartyWishlistDao;
import com.pompeu.domain.PartyWishlist;


@RestController 
public class PartyWishlistController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 UsersController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  PartyWishlistDao partyWishlistDao;

  @RequestMapping("/partyWishlist/list")
  public Object list() {
    return partyWishlistDao.findAll();
  }

  @RequestMapping("/partyWishlist/add")
  public Object add(PartyWishlist partyWishlist) {
    return partyWishlistDao.insert(partyWishlist);
  }


  @RequestMapping("/partyWishlist/get")
  public Object get(PartyWishlist partyWishlist) {
    List<PartyWishlist> partyWish = partyWishlistDao.findByNo(partyWishlist);
    if (partyWish == null) {
      return "";
    }
    return partyWish;
  }

  @RequestMapping("/partyWishlist/update")
  public Object update(PartyWishlist partyWishlist) {
    return partyWishlistDao.update(partyWishlist);
  }

  @RequestMapping("/partyWishlist/delete")
  public Object delete(PartyWishlist partyWishlist) {
    return partyWishlistDao.delete(partyWishlist);
  }

}
