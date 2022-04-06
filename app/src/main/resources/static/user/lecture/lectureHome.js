$(".headers").load("../admin2.html"); /*사이드바 관련 코드*/

// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    animationLoop: false,
    itemWidth: 100,
    itemMargin: 5,
    minItems: 8,
    maxItems: 8
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


  var exercise = document.querySelector("#exercise");
  
  fetch(`/userLecture/findExercise?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);

});