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
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pompeu.admin.support.service.AskService;
import com.pompeu.domain.Ask;
import com.pompeu.domain.FileNames;

@RestController 
public class AskController {

  // log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(NoticeController.class);

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 AskController 객체를 만들 때 AskDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  AskService askService;

  @RequestMapping("/ask/list")
  public Object list(Ask ask) {
    return askService.list(ask);  
  }

  @RequestMapping("/user-ask/list")
  public Object userList(HttpSession session, HttpServletRequest request) {

    //session = request.getSession();

    Ask ask = new Ask();

    //    ask.setMemberNo((int)session.getAttribute("memberNo"));
    ask.setMemberNo(5);

    return askService.userList(ask);
  }

  @RequestMapping("/ask/add")
  public Object add(Ask ask, List<MultipartFile> files) {

    try {

      ask.setFNames(saveFileMulti(files));

    }catch(Exception e){

    }

    int count = askService.add(ask);
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }




  @RequestMapping("/ask/get")
  public Object get(int no) {
    Ask ask = askService.get(no);
    if (ask == null) {
      return "";
    }
    return ask;
  }

  @RequestMapping("/ask/fileRemove")
  public Object fileRemove(Ask ask) {
    int count = askService.fileRemove(ask);
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @SuppressWarnings("unused")
  @RequestMapping("/ask/getfilename")
  public Object getfilename(int no) {
    Ask ask = new Ask();
    ask.setFNames(askService.getFNames(no));
    if (ask == null) {
      return "";
    }

    return ask;
  }

  @RequestMapping("/ask/update")
  public Object update(Ask ask) {
    return askService.update(ask);
  }


  @RequestMapping("/ask/delete")
  public Object delete(int no) {
    return askService.delete(no);
  }

  @RequestMapping("/ask/deleteAll")
  public Object deleteAll(String memberTypeNo) {
    log.info("memberTypeNo : " + memberTypeNo);

    int count = askService.deleteAll(memberTypeNo);

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

        File photoFile = new File("./upload/notice-files/" + filename); // App 클래스를 실행하는 프로젝트 폴더
        log.info("A");
        files.get(i).transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.
        log.info("B");
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

  @RequestMapping("/ask/fileDownLoad")
  public void askFileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
    log.info("?????????????????");
    String filename = request.getParameter("orgFile");
    String pathName = "";
    String realFilename=request.getParameter("realFile");
    log.info("#### : " + filename);
    log.info("@@@@ : " + realFilename);

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
      log.info("UnsupportedEncodingException");
    }

    pathName = "./upload/ask-files/" + realFilename;
    log.info(pathName);
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
      log.info("FileNotFoundException : " + e);
    }

  }
}
