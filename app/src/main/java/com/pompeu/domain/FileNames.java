package com.pompeu.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileNames {

  String orgFile = "";
  String realFile = "";

  public FileNames() {}

  public FileNames(String orgFile, String realFile) {
    this.orgFile = orgFile;
    this.realFile = realFile;
  }

}
