package com.pompeu.user.main.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.domain.LectureLike;
import com.pompeu.domain.Member;
import com.pompeu.user.main.dao.UserMainDao;
import com.pompeu.user.main.service.UserMainService;

@Service
public class DefaultUserMainService implements UserMainService{

  @Autowired
  UserMainDao userMainDao;

  @Override
  public List<Member> list() {
    return userMainDao.findAll();
  }

  @Override
  public int add(Member member) {
    return userMainDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return userMainDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return userMainDao.update(member);
  }


  @Override
  public int delete(int no) {
    return userMainDao.delete(no);
  }

  @Override
  public List<Map<Object, Object>> findTopLecture(int no) {
    return userMainDao.findTopLecture(no);
  }

  @Override
  public List<Map<Object, Object>> findNewLecture(int no) {
    return userMainDao.findNewLecture(no);
  }

  @Override
  public int didICount(LectureLike lectureLike) {
    return userMainDao.didICount(lectureLike);
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

}