package com.pompeu.creator.lecture.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.creator.lecture.Service.CreatorLectureService;
import com.pompeu.domain.Lecture;
import com.pompeu.domain.LectureTime;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController
public class CreatorLectureController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(CreatorLectureController.class);

  @Autowired
  CreatorLectureService creatorlectureService;

  @RequestMapping("/creatorLecture/list")
  public Object list() {
    log.info("크리에이터클래스목록 조회");
    return creatorlectureService.list();
  }

  @RequestMapping("/creatorLecture/add")
  public Object add(Lecture lecture, String[] time, MultipartFile file) {
    log.debug(lecture);

    try {
      lecture.setImages(saveFile(file));
      ArrayList<LectureTime> timesList = new ArrayList<>();
      for(int i= 0; i< time.length; i++) {
        String[] value = time[i].split(",");
        if(value[0].length() == 0) { //시작시간
          continue;
        } 
        if(value[1].length() == 0) { //종료시간
          continue;
        }  

        LectureTime lectureTime = new LectureTime
            (value[0],value[1],Integer.parseInt(value[2]));

        timesList.add(lectureTime);
      }
      lecture.setTimes(timesList);

    }catch (Exception e) {

    } 

    return creatorlectureService.add(lecture);
  }


  @RequestMapping("/creatorLecture/get")
  public Object get(int no) {
    Lecture lecture = creatorlectureService.get(no);
    if (lecture == null) {
      return "";
    }
    return lecture;
  }

  @RequestMapping("/creatorLecture/update")
  public Object update(Lecture lecture) {
    return creatorlectureService.update(lecture);
  }

  @RequestMapping("/creatorLecture/delete")
  public Object delete(int no) {
    return creatorlectureService.delete(no);
  }



  private String saveFile(MultipartFile file) throws Exception {

    //List<String> imageList = new ArrayList<String>();

    if (file != null && file.getSize() > 0) { 
      // 파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("/upload/lecture_image/" + filename); // App 클래스를 실행하는 프로젝트 폴더
      file.transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.

      // 썸네일 이미지 파일 생성
      Thumbnails.of(photoFile)
      .size(50, 50)
      .crop(Positions.CENTER)
      .outputFormat("jpg")
      .toFile(new File("./upload/book/" + "50x50_" + filename));

      //return imageList.add("");
      return filename;

    } else {
      return null;
    }

  }

}
