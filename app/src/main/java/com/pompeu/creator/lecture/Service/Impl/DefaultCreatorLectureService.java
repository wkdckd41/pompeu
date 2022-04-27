package com.pompeu.creator.lecture.Service.Impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.creator.lecture.controller.CreatorLectureController;
import com.pompeu.creator.lecture.dao.CreatorLectureDao;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureList;
import com.pompeu.domain.Test;

@Service
public class DefaultCreatorLectureService implements CreatorLectureService {

  private static final Logger log = LogManager.getLogger(CreatorLectureController.class);
  @Autowired
  CreatorLectureDao creatorLectureDao;

  @Override
  public int countAll() {
    return creatorLectureDao.countAll();
  }
  //강좌 목록 호출 - 강좌, 강좌시간, 강좌이미지
  @Override
  public List<LectureList> list(int no) {
    return creatorLectureDao.findAllMyclass(no);
  }

  @Override
  public int add(Lecture lecture) {
    creatorLectureDao.insert(lecture);
    //creatorLectureDao.insertTimes(lecture.getNo(), lecture.getTimes());
    //creatorLectureDao.insertImages(lecture.getNo(), lecture.getImages());
    return 1;
  }

  @Override
  public Lecture get(int no) {
    return creatorLectureDao.findByNo(no);
  }

  @Override
  public int update(Lecture lecture) {
    return creatorLectureDao.update(lecture);
  }

  @Override
  public int delete(int no) {
    return creatorLectureDao.delete(no);
  }

  @Override
  public List<Test> test() {
    return creatorLectureDao.test();
  }
}
