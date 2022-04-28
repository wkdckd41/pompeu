package com.pompeu.creator.creatorChange.service;

import java.util.List;

import com.pompeu.domain.CreatorUpdate;
import com.pompeu.domain.Member;

public interface CreatorChangeService {

	List<Member> list();

	int add(Member member);

	Member get(int no);

	int update(Member member);

	int delete(int no);

	CreatorUpdate getCreator(int no);

	int updateCreator(CreatorUpdate cUpdate);

	int checkNickname(String nickname);

	int deleteCreator(Member member);

	int deleteCreatorDetail(int no);
}