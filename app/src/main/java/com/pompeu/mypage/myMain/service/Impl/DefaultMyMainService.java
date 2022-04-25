package com.pompeu.mypage.myMain.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.domain.Member;
import com.pompeu.mypage.myMain.dao.MyMainDao;
import com.pompeu.mypage.myMain.service.MyMainService;

@Service
public class DefaultMyMainService implements MyMainService{

  @Autowired
  MyMainDao myMainDao;

  @Override
  public List<Member> list() {
    return myMainDao.findAll();
  }

  @Override
  public int add(Member member) {
    return myMainDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return myMainDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return myMainDao.update(member);
  }

  @Override
  public int delete(int no) {
    return myMainDao.delete(no);
  }

  @Override
  public List<Map<String, Object>> myGoingLecture(int no) {
    return myMainDao.myGoingLecture(no);
  }

  @Override
  public List<Map<String, Object>> myWishLecture(int no) {
    return myMainDao.myWishLecture(no);
  }

  @Override
  public List<Map<String, Object>> myGoingParty(int no) {
    return myMainDao.myGoingParty(no);
  }

  @Override
  public List<Map<String, Object>> myWishParty(int no) {
    return myMainDao.myWishParty(no);
  }

  //  @Override
  //  public Object memberStatus() {
  //    return adminMainDao.memberStatus();
  //  }
  //
  //  @Override
  //  public Object lectureStatus() {
  //    return adminMainDao.lectureStatus();
  //  }
  //
  //  @Override
  //  public Object undoStatusApply() {
  //    return adminMainDao.undoStatusApply();
  //  }
  //
  //  @Override
  //  public Object undoStatusClaim() {
  //    return adminMainDao.undoStatusClaim();
  //  }
  //
  //  @Override
  //  public Object memberSummary(int month) {
  //    return adminMainDao.memberSummary(month);
  //  }

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