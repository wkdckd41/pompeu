package com.pompeu.creator.creatorChange.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.creator.creatorChange.dao.CreatorChangeDao;
import com.pompeu.creator.creatorChange.service.CreatorChangeService;
import com.pompeu.domain.CreatorUpdate;
import com.pompeu.domain.Member;

@Service
public class DefaultCreatorChangeService implements CreatorChangeService{

  @Autowired
  CreatorChangeDao creatorChangeDao;

  @Override
  public List<Member> list() {
    return creatorChangeDao.findAll();
  }

  @Override
  public int add(Member member) {
    return creatorChangeDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return creatorChangeDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return creatorChangeDao.update(member);
  }


  @Override
  public int delete(int no) {
    return creatorChangeDao.delete(no);
  }

  @Override
  public Map<Object,Object> getCreator(int no) {
    return creatorChangeDao.getCreator(no);
  }

  @Override
  public int updateCreator(CreatorUpdate cUpdate) {
    return creatorChangeDao.updateCreator(cUpdate);
  }

  @Override
  public int checkNickname(String nickname) {
    return creatorChangeDao.checkNickname(nickname);
  }

  @Override
  public int deleteCreator(Member member) {
    return creatorChangeDao.deleteCreator(member);
  }

  @Override
  public int deleteCreatorDetail(int no) {
    return creatorChangeDao.deleteCreatorDetail(no);
  }

}