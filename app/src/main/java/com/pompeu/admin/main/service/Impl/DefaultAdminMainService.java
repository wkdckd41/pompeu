package com.pompeu.admin.main.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.main.dao.AdminMainDao;
import com.pompeu.admin.main.service.AdminMainService;
import com.pompeu.domain.Member;

@Service
public class DefaultAdminMainService implements AdminMainService{

  @Autowired
  AdminMainDao adminMainDao;

  @Override
  public List<Member> list() {
    return adminMainDao.findAll();
  }

  @Override
  public int add(Member member) {
    return adminMainDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return adminMainDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return adminMainDao.update(member);
  }


  @Override
  public int delete(int no) {
    return adminMainDao.delete(no);
  }

  @Override
  public Object memberStatus() {
    return adminMainDao.memberStatus();
  }

  @Override
  public Object lectureStatus() {
    return adminMainDao.lectureStatus();
  }

  @Override
  public Object undoStatusApply() {
    return adminMainDao.undoStatusApply();
  }

  @Override
  public Object undoStatusClaim() {
    return adminMainDao.undoStatusClaim();
  }

  //  @Override
  //  public List<Integer> memberList() {
  //    return memberDao.findCount();
  //  }
  //
  //  @Override
  //  public List<Member> srchMember(Member member) {
  //    return memberDao.srchMember(member);
  //  }
  //
  //  @Override
  //  public List<Map<Object, Object>> getLecture(int no) {
  //    return memberDao.findUserLecture(no);
  //  }
  //
  //  @Override
  //  public List<Map<Object, Object>> creatorLecture(int no) {
  //    return memberDao.findCreatorLecture(no);
  //  }
  //
  //  @Override
  //  public List<Map<Object, Object>> applyingLecture(int no) {
  //    return memberDao.findApplyingLecture(no);
  //  }



}