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
    log.info("memberTypeNo : " + notice.getMemberTypeNo()); //컨트롤러 까지만 온 데이터
    log.info("pageNo : " + notice.getPageNo());
    log.info("pageSize : " + notice.getPageSize());
    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (notice.getPageSize() < 10 || notice.getPageSize() > 100) {
        notice.setPageSize(10);
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int noticeSize = noticeService.size(); 
    totalPageSize = noticeSize / notice.getPageSize(); // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((noticeSize % notice.getPageSize()) > 0) {
      totalPageSize++;
    }


    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (notice.getPageNo() < 1 || notice.getPageNo() > totalPageSize) {// pageNo 유효성 검증
        notice.setPageNo(1);
      }
    } catch (Exception e) {}

    log.info("totalPageSize =" + totalPageSize);
    log.info("PageNo =" + notice.getPageNo());
    log.info("PageSize =" + notice.getPageSize());

    ResultMap resultMap = new ResultMap();
    resultMap.setPageNo(notice.getPageNo());
    resultMap.setPageSize(notice.getPageSize());
    resultMap.setTotalPageSize(totalPageSize);
    resultMap.setNoticeList(noticeService.list(notice));

    return resultMap;  
  }


  @RequestMapping("/notice/add")
  public Object add(Notice notice, List<MultipartFile> files) {
    log.info("memberTypeNo : " + notice.getMemberTypeNo() +  " name: " + notice.getName() + 
        " criticalCheck:" +  notice.getCriticalCheck() + " content:"  + notice.getContent());
    try {

      notice.setFNames(saveFileMulti(files));

    }catch(Exception e){

    }

    int count = 0;
    if (notice.getMemberTypeNo()==3) {
      notice.setMemberTypeNo(1);
      count += noticeService.add(notice);
      notice.setMemberTypeNo(2);
      count += noticeService.add(notice);
    }else {
      count = noticeService.add(notice);
    }
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }


  @SuppressWarnings("unused")
  @RequestMapping("/notice/get")
  public Object get(int no) {
    Notice notice = noticeService.get(no);
    notice.setFNames(noticeService.getFNames(no));
    if (notice == null) {
      return "";
    }

    return notice;
  }

  @RequestMapping("/notice/fileRemove")
  public Object fileRemove(Notice notice) {
    int count = noticeService.fileRemove(notice);
    log.info("count = " + count);
    if (count != 0) {
      return new ResultMap().setStatus("success");
    } else {
      return new ResultMap().setStatus("fail").setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @SuppressWarnings("unused")
  @RequestMapping("/notice/getfilename")
  public Object getfilename(int no) {
    Notice notice = new Notice();
    notice.setFNames(noticeService.getFNames(no));
    if (notice == null) {
      return "";
    }

    return notice;
  }



  @RequestMapping("/notice/update")
  public Object update(Notice notice, List<MultipartFile> addFile) {
    log.info("MemberTypeNo :"+ notice.getMemberTypeNo());
    log.info("name :"+ notice.getName());
    log.info("CriticalCheck :"+ notice.getCriticalCheck());
    log.info("content :"+ notice.getContent());
    log.info("filename :"+ notice.getFNames());
    try {

      notice.setFNames(saveFileMulti(addFile));

    }catch(Exception e){

    }

    int count = noticeService.update(notice);
    System.out.println("count = " + count);
    if (count != 0) {
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
    log.info("memberTypeNo : " + memberTypeNo);

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

  @RequestMapping("/notice/fileDownLoad")
  public void noticeFileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
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

    pathName = "./upload/notice-files/" + realFilename;
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
      log.info("FileNotFoundException : " + e);
    }

  }

}
