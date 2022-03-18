package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.PartyWishlist;

@Mapper
public interface PartyWishlistDao {

  int countAll();

  List<PartyWishlist> findAll();

  int insert(PartyWishlist partyWishlist);

  List<PartyWishlist> findByNo(PartyWishlist partyWishlist);

  int update(PartyWishlist partyWishlist);

  int delete(PartyWishlist partyWishlist);

}











