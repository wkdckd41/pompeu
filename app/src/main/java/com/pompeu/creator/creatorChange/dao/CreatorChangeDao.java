package com.pompeu.creator.creatorChange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pompeu.domain.CreatorUpdate;
import com.pompeu.domain.Member;

@Mapper
public interface CreatorChangeDao {

	int countAll();

	List<Member> findAll();

	int insert(Member member);

	Member findByNo(int no);

	int update(Member member);

	int delete(int no);

	CreatorUpdate getCreator(int no);

	int updateCreator(CreatorUpdate cUpdate);

	int checkNickname(String nickname);

	int deleteCreator(Member member);

	int deleteCreatorDetail(int no);
}

