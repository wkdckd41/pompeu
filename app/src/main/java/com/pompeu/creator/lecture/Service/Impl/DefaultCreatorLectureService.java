package com.pompeu.creator.lecture.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.creator.lecture.dao.CreatorLectureDao;
import com.pompeu.domain.Lecture;

@Service
public class DefaultCreatorLectureService implements CreatorLectureService {

  @Autowired
  CreatorLectureDao creatorlectureDao;

  @Override
  public int countAll() {
    return creatorlectureDao.countAll();
  }

  @Override
  public List<Lecture> list() {
    return creatorlectureDao.findAll();
  }

  @Override
  public int add(Lecture lecture) {
    creatorlectureDao.insert(lecture);
    creatorlectureDao.insertTimes(lecture.getNo(), lecture.getTimes());
    return 1;
  }

  @Override
  public Lecture get(int no) {
    return creatorlectureDao.findByNo(no);
  }

  @Override
  public int update(Lecture lecture) {
    return creatorlectureDao.update(lecture);
  }

}
