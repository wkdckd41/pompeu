package com.pompeu.admin.lecture.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.lecture.service.AdminLectureService;
import com.pompeu.creator.lecture.dao.CreatorLectureDao;
import com.pompeu.domain.Lecture;

@Service
public class DefaultAdminLectureService implements AdminLectureService {

  @Autowired
  CreatorLectureDao lectureDao;

  @Override
  public int countAll() {
    return lectureDao.countAll();
  }
  @Override
  public List<Lecture> list() {
    return lectureDao.findAll();
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
