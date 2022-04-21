package com.pompeu.user.lecture.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.domain.Ask;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureIntro;
import com.pompeu.user.lecture.dao.UserLectureDao;
import com.pompeu.user.lecture.service.UserLectureService;

@Service
public class DefaultUserLectureService implements UserLectureService{

  @Autowired
  UserLectureDao userLectureDao;

  @Override
  public List<Lecture> list() {
    return userLectureDao.findAll();
  }

  @Override
  public int add(Lecture lecture) {
    return userLectureDao.insert(lecture);
  }

  @Override
  public Lecture get(int no) {
    return userLectureDao.findByNo(no);
  }

  @Override
  public int update(Lecture lecture) {
    return userLectureDao.update(lecture);
  }


  @Override
  public int delete(int no) {
    return userLectureDao.delete(no);
  }

  @Override
  public List<Lecture> getEverything(String sort, String region) {
    return userLectureDao.findEverything(sort, region);
  }

  @Override
  public List<Lecture> getOut(String sort, String region) {
    return userLectureDao.findOut(sort, region);
  }

  @Override
  public List<Lecture> getIn(String sort, String region) {
    return userLectureDao.findIn(sort, region);
  }

  @Override
  public List<LectureIntro> lecture(int no) {
    return userLectureDao.findLecture(no);
  }

  @Override
  public List<Lecture> regist(int no) {
    return userLectureDao.registLecture(no);
  }

  @Override
  public List<Lecture> time(int no) {
    return userLectureDao.registTime(no);
  }

  @Override
  public int addAsk(Ask ask) {
    return userLectureDao.insertAsk(ask);
  }

  @Override
  public List<Lecture> img(int no) {
    return userLectureDao.addImage(no);
  }

  @Override
  public List<Lecture> map(int no) {
    return userLectureDao.mapping(no);
  }

  @Override
  public List<Lecture> si(int no) {
    return userLectureDao.siSep2(no);
  }
}