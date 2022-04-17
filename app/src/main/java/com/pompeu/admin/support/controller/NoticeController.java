package com.pompeu.admin.support.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.admin.support.service.NoticeService;
import com.pompeu.domain.FileNames;
import com.pompeu.domain.Notice;

@RestController 
public class NoticeController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(NoticeController.class);


  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 NoticeController 객체를 만들 때 NoticeDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  NoticeService noticeService;

  @RequestMapping("/notice/list")
  public Object list(Notice notice) {
    System.out.println("memberTypeNo : " + notice.getMemberTypeNo()); //컨트롤러 까지만 온 데이터
    return noticeService.list(notice);  
  }

  @RequestMapping("/notice/add")
  public Object add(Notice notice, List<MultipartFile> files) {
    System.out.println("memberTypeNo : " + notice.getMemberTypeNo() +  " name: " + notice.getName() + 
        " criticalCheck:" +  notice.getCriticalCheck() + " content:"  + notice.getContent());
    try {

      notice.setFNames(saveFileMulti(files));

    }catch(Exception e){

    }

    int count = noticeService.add(notice);
    System.out.println("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }


  @RequestMapping("/notice/get")
  public Object get(int no) {
    Notice notice = noticeService.get(no);
    notice.setFNames(noticeService.getFNames(no));
    if (notice == null) {
      return "";
    }

    return notice;
  }

  @RequestMapping("/notice/update")
  public Object update(Notice notice) {
    log.info("name :"+ notice.getName());
    System.out.println("content :"+notice.getContent());
    System.out.println("criticalCheck :"+notice.getCriticalCheck());

    int count = noticeService.update(notice);

    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/notice/delete")
  public Object delete(int no) {
    return noticeService.delete(no);
  }

  @RequestMapping("/notice/deleteAll")
  public Object deleteAll(String memberTypeNo) {
    System.out.println("memberTypeNo : " + memberTypeNo);

    int count = noticeService.deleteAll(memberTypeNo);

    if (count == 1) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }

  }

  private List<FileNames> saveFileMulti(List<MultipartFile> files) throws Exception {
    List<FileNames> list = new ArrayList<FileNames>();
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
        System.out.println("A");
        files.get(i).transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.
        System.out.println("B");
        // 썸네일 이미지 파일 생성
        //        Thumbnails.of(photoFile)
        //        .size(50, 50)
        //        .crop(Positions.CENTER)
        //        .outputFormat("jpg")
        //        .toFile(new File("./upload/book/" + "50x50_" + filename));
        //        System.out.println("C");
        //        //return imageList.add("");
        //        System.out.println("filename = " + filename);

        FileNames filenm = new FileNames(files.get(i).getOriginalFilename(), filename);
        list.add(filenm);
        //return filename;

      } else {

      }
    }

    return list;

  }

  @RequestMapping("/notice/fileDownLoad")
  public void noticeFileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
    System.out.println("?????????????????");
    String filename = request.getParameter("orgFile");
    String pathName = "";
    String realFilename=request.getParameter("realFile");
    System.out.println("#### : " + filename);
    System.out.println("@@@@ : " + realFilename);

    try {
      String browser = request.getHeader("User-Agent"); 
      //파일 인코딩 

      if (browser.contains("MSIE") || browser.contains("Trident")
          || browser.contains("Chrome")) {
        filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+","%20");
        realFilename = URLEncoder.encode(realFilename, "UTF-8").replaceAll("\\+","%20");
      } else {
        filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        realFilename = new String(realFilename.getBytes("UTF-8"), "ISO-8859-1");
      }
    } catch (UnsupportedEncodingException ex) {
      System.out.println("UnsupportedEncodingException");
    }

    pathName = "./upload/lecture_image/" + realFilename;
    System.out.println(pathName);
    File file1 = new File(pathName);
    if (!file1.exists()) {
      return ;
    }

    // 파일명 지정        
    response.setContentType("application/octer-stream");
    response.setHeader("Content-Transfer-Encoding", "binary;");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
    try {
      OutputStream os = response.getOutputStream();
      FileInputStream fis = new FileInputStream(pathName);

      int ncount = 0;
      byte[] bytes = new byte[512];

      while ((ncount = fis.read(bytes)) != -1 ) {
        os.write(bytes, 0, ncount);
      }
      fis.close();
      os.close();
    } catch (Exception e) {
      System.out.println("FileNotFoundException : " + e);
    }

  }

}
