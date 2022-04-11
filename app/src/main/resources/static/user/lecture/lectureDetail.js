

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
   var askContent = document.querySelector("#ask-content")

    fetch(`/userLecture/findLecture?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      console.log(result[0].lectureInfo)
      lectureInfo.innerHTML = result[0].lectureInfo;
      info.innerHTML = result[0].info;
      
       if (result[0].askContent != null) {
        askContent.innerHTML = `${result[0].askContent}`;
        }
     })
     
     fetch(`/userLecture/registLecture?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
     

     })