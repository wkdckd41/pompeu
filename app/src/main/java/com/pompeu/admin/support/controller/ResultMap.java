package com.pompeu.admin.support.controller;
import java.util.List;
import com.pompeu.domain.Notice;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class ResultMap {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";


  private String status;
  private Object data;
  private List<Notice> noticeList;
  private int pageNo, pageSize, totalPageSize;
}
