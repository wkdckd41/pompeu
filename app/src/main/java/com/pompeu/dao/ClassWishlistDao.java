package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.ClassWishlist;

@Mapper
public interface ClassWishlistDao {

  int countAll();

  List<ClassWishlist> findAll();

  int insert(ClassWishlist classwishlist);

  List<ClassWishlist> findByNo(ClassWishlist classwishlist);

  //  int update(ChallengeLike classwishlist);

  int delete(ClassWishlist classwishlist);

}











