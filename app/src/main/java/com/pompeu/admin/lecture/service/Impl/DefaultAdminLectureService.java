package com.pompeu.admin.lecture.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.lecture.dao.AdminLectureDao;
import com.pompeu.admin.lecture.service.AdminLectureService;
import com.pompeu.domain.Lecture;

@Service
public class DefaultAdminLectureService implements AdminLectureService {

  @Autowired
  AdminLectureDao adminlectureDao;

  @Override
  public int countAll() {
    return adminlectureDao.countAll();
  }
  @Override
  public List<Lecture> list() {
    return adminlectureDao.findAll();
  }
  @Override
  public Lecture get(int no) {
    return adminlectureDao.findByNo(no);
  }

  @Override
  public int update(Lecture lecture) {
    return adminlectureDao.update(lecture);
  }

}
