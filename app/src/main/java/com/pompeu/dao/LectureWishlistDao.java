package com.pompeu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pompeu.domain.LectureWishlist;

@Mapper
public interface LectureWishlistDao {

  int countAll();

  List<LectureWishlist> findAll();

  int insert(LectureWishlist classwishlist);

  List<LectureWishlist> findByNo(LectureWishlist classwishlist);

  //  int update(ChallengeLike classwishlist);

  int delete(LectureWishlist classwishlist);

}











