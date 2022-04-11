  // 템플릿 엔진에서 사용할 HTML 조각을 가져오기
  var trTemplate = document.querySelector("#tr-template");
  
  //템플릿 엔진 준비
  var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);


// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide"
  });
});

 // 1) URL에서 쿼리스트링(query string)을 추출한다.
  var arr = location.href.split("?");
  console.log(arr);

  if (arr.length == 1) {
    alert("요청 형식이 옳바르지 않습니다.")
    throw "URL 형식 오류!";
  }

  var qs = arr[1];
  console.log(qs);

  // 2) 쿼리 스트링에서 email 값을 추출한다.
  var params = new URLSearchParams(qs);
  var no = params.get("no");

  if (no == null) {
    alert("독서록 번호가 없습니다.");
    throw "파라미터 오류!";
  }
  console.log(no);

   var lectureInfo = document.querySelector("#lecture-introduce");
   var info = document.querySelector("#teacher-introduce");
   var askContent = document.querySelector("#ask-content");

    fetch(`/userLecture/findLecture?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      lectureInfo.innerHTML = result[0].lectureInfo;
      info.innerHTML = result[0].info;
      
       if (result[0].askContent != null) {
        askContent.innerHTML = `${result[0].askContent}`;
        }
     })
     
     
     
    var exercise = document.querySelector("#exercise");
    var lectureName = document.querySelector("#lecture-name");
    var maxMember = document.querySelector("#max-member");
    var lecturePrice = document.querySelector("#lecture-price");
    
     fetch(`/userLecture/registLecture?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
     
<<<<<<< HEAD

=======
     exercise.innerHTML = result[0].exName;
     lectureName.innerHTML = result[0].name;
     maxMember.innerHTML = `최대인원: ${result[0].maxMember} 명`;
     lecturePrice.innerHTML = `수강금액: ${result[0].lecturePrice}원`;
     })
     
     
    var lectureDate = document.querySelector("#lecture-date");
    var lectureTime = document.querySelector("#lecture-time");
    
     fetch(`/userLecture/registTime?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      $("#time-box").html(htmlGenerator(result));
>>>>>>> branch 'main' of https://github.com/linarano/pompeu.git
     })