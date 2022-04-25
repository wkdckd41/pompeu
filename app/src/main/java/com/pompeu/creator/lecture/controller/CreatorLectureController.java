package com.pompeu.creator.lecture.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureImage;

@RestController
@RequestMapping("/creatorLecture/")
public class CreatorLectureController {
  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(CreatorLectureController.class);

  @Autowired
  CreatorLectureService creatorLectureService;

  //클래스 목록조회
  @RequestMapping("list")
  public Object list() {
    log.debug(creatorLectureService.list().toString());
    return creatorLectureService.list();
  }

  //클래스 등록
  @RequestMapping("add")
  public void add(Lecture lecture/* String[] time, List <MultipartFile> files*/) {
    log.debug(lecture.toString());
    creatorLectureService.add(lecture);



    //    //강의 시간 데이터
    //    try {
    //      ArrayList<LectureTime> timesList = new ArrayList<>();
    //      for(int i= 0; i< time.length; i++) {
    //        String[] value = time[i].split(",");
    //        if(value[0].length() == 0) { //시작시간
    //          continue;
    //        } 
    //        if(value[1].length() == 0) { //종료시간
    //          continue;
    //        }  
    //        LectureTime lectureTime = new LectureTime(value[0],value[1],Integer.parseInt(value[2]));
    //        timesList.add(lectureTime);
    //      }
    //      lecture.setTimes(timesList);
    //      lecture.setImages(saveFileMulti(files));
    //
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    } 
    //    return creatorLectureService.add(lecture);
  }

  //클래스 상세보기
  @RequestMapping("get")
  public Object get(int no) {
    Lecture lecture = creatorLectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  //클래스 수정
  @RequestMapping("update")
  public Object update(Lecture lecture) {
    return creatorLectureService.update(lecture);
  }

  //클래스 삭제
  @RequestMapping("delete")
  public Object delete(int no) {
    return creatorLectureService.delete(no);
  }

  //이미지파일 등록
  private List<LectureImage> saveFileMulti(List<MultipartFile> files) throws Exception {
    List<LectureImage> list = new ArrayList<LectureImage>();
    for(int i=0; i<files.size(); i++) {

      if (files.get(i) != null && files.get(i).getSize() > 0) { 
        // 파일을 저장할 때 사용할 파일명을 준비한다.
        String filename = UUID.randomUUID().toString();

        // 파일명의 확장자를 알아낸다.
        int dotIndex = files.get(i).getOriginalFilename().lastIndexOf(".");
        if (dotIndex != -1) {
          filename += files.get(i).getOriginalFilename().substring(dotIndex);
        }

        // 파일을 지정된 폴더에 저장한다.
        File photoFile = new File("./upload/lecture_image/" + filename); // App 클래스를 실행하는 프로젝트 폴더
        files.get(i).transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.

        LectureImage filenames = new LectureImage(files.get(i).getOriginalFilename(), filename);
        list.add(filenames);
      }
    } 
    return list;

  }

}