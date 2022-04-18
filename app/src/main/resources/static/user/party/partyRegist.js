// 템플릿 엔진에서 사용할 HTML 조각을 가져오기
var trTemplate = document.querySelector("#tr-template");

//템플릿 엔진 준비
var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);

// 운동 Tag 목록 가져오기
 fetch("/userparty/tag")
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
    $("#x-ex-tag").html(htmlGenerator(result));
  });
  
  // 실내외선택
$("select[name=inOutEx]").change(function() {
  console.log($(this).val());  // value 값 가져오기
  console.log($("select[name=inOutEx] option:selected").text());  // text 값 가져오기
});
  
// 운동 선택
  $("select[name=tag]").change(function() {
  console.log($(this).val());   //value값 가져오기
  console.log($("select[name=tag] option:selected").text());  // text 값 가져오기
});

// 모집인원
$("select[name=maxMember]").change(function() {
  console.log($(this).val());  // value 값 가져오기
  console.log($("select[name=maxMember] option:selected").text());  // text 값 가져오기
});

var xTitle = document.querySelector("input[name=title]");
var xStartDate = document.querySelector("input[name=startDate]");
var xEndDate = document.querySelector("input[name=endDate]");
var xContent = document.querySelector("textarea");
var xInOutEx = document.querySelector("select[name=inOutEx]");
var xCrew = document.querySelector("select[name=maxMember]");
var xExTag = document.querySelector("select[name=tag]");

document.querySelector("#x-add-btn").onclick = function() {
  
   if(xTitle.value == "" || 
      xStartDate.value == "" || 
      xEndDate.value == "" || 
      xContent.value == "" ||
      xInOutEx.value == "" ||
      xExTag.value == "" ||
      xCrew.value == "") {
    window.alert("필수 입력 항목이 비어있습니다.");
    return;
  }
  
    var fd = new FormData(document.forms.namedItem("frm"));

    fetch("/userparty/add", { 
        method: "POST",
        body: new URLSearchParams(fd)
      }) 
      .then(function(response) {
        return response.json();
      })
      .then(function(result) {
        console.log(result);
      });
     // location.href = 'party-home.html'
  };
  

// 취소버튼
function moveList() {
  location.href = 'party-home.html'
}
  