package com.pompeu.domain;

import lombok.Data;

@Data
public class LectureImage {

  int lectureNo; //강의
  int lectureImageNo;//순번
  String image; //오리지널 이름

  public LectureImage(){}

  public LectureImage(String image) {
    this.image= image;
  }

}
