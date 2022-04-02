package com.pompeu.creator.lecture.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.creator.lecture.Service.LectureService;
import com.pompeu.creator.lecture.dao.LectureDao;
import com.pompeu.domain.Lecture;

@Service
public class DefaultLectureService implements LectureService{

  @Autowired
  LectureDao lectureDao;

  @Override
  public int countAll() {
    return lectureDao.countAll();
  }

  @Override
  public List<Lecture> list() {
    return lectureDao.findAll();
  }

  @Override
  public Lecture add(Lecture lecture) {
    return lectureDao.insert(lecture);
  }

  @Override
  public Lecture get(int no) {
    return lectureDao.findByNo(no);
  }

  @Override
  public int update(Lecture lecture) {
    return lectureDao.update(lecture);
  }

}
