var memberTypeNo = 1;
var pageNo = 1; //default
var pageSize = 6; //default
var totalPageSize = 0; //default
var bottomSize = 3; //default

$(document).ready(function () {



  /*    var arr = location.href.split("?");
    console.log(arr);

    var qs = arr[1];
    console.log("qs : " + qs);

    // 2) 쿼리 스트링에서 no 값을 추출한다.
    var params = new URLSearchParams(qs);
    var no = params.get("no");
    console.log("faqNo : " + no);
    로그인시에 멤버타입입 넘버를 받기 위한 세팅 */



  selectFaqList(1, pageNo); //파라미터로 받은값을 넣어준다

  init();
});

function selectFaqList(no, pgNo) {
  // while (tbody1.hasChildNodes()) {
  //     tbody1.removeChild(tbody1.firstChild);
  //  }
  console.log("memberTypeNo : " + no);
  console.log("pageNo : " + pgNo);
  console.log("pageSize : " + pageSize);

  var param = new URLSearchParams();

  param.set('memberTypeNo', no);
  param.set('pageNo', pgNo);
  param.set('pageSize', pageSize);

  console.log(param);

  fetch("/faq/userList", {
    method: "POST",
    body: param
  }).then(function (response) {
    return response.json();
  })
    .then(function (result) {
      console.log(result);
      var count = 0;
      var acco = document.querySelector("#Accordion_wrap")
      var str = ``;
      for (var rst of result.faqList) {
        str +=
          `<div class="que"><span>${rst.ask}</span></div>` +
          `<div class="anw"><span>${rst.answer}</span></div>`
      }
      acco.innerHTML = str;

      $(".que").on({
        "click": function () {
          $(this).next(".anw").stop().slideToggle(300);
          $(this).toggleClass('on').siblings().removeClass('on');
          $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
        }
      });
      totalPageSize = result.totalPageSize;
      console.log("totalPageSize : " + totalPageSize);
      pageNo = result.pageNo;
      pageSize = result.pageSize;

      makePageNavi(totalPageSize, bottomSize, pageNo);
    });
}
function makePageNavi(totalPageSize, bottomSize, pageNo){
  var pagination = document.querySelector("#pagination");
  while (pagination.hasChildNodes()) {
      pagination.removeChild(pagination.firstChild);
  }
  
  var pageInfo = getPageInfo(totalPageSize, bottomSize, pageNo);
  
  var li = document.createElement("li");
  
  if(pageInfo.firstBottomNumber==1) li.innerHTML=`<a class="page-link" href="#" style="pointer-events:none;" >&lt;</a>`;
  else li.innerHTML=`<a class="page-link" href="#" onclick="selectFaqList(${memberTypeNo}, ${pageInfo.firstBottomNumber - 1})">&lt;</a>`;
  
  li.setAttribute("class", "page-item");    
  document.querySelector("#pagination").appendChild(li);
  
  for(var i=pageInfo.firstBottomNumber; i<=pageInfo.lastBottomNumber; i++){
    li = document.createElement("li");
    
    if(i==pageInfo.cursor){
      console.log("현재페이지 : " + i);
      li.innerHTML=`<a class="page-link" href="#" style="color:#04CF5C">`+ i +`</a>`;
    }else{
      li.innerHTML=`<a class="page-link" href="#" onclick="selectFaqList(${memberTypeNo}, ${i})">`+ i +`</a>`;
    }
    li.setAttribute("class", "page-item");    
    document.querySelector("#pagination").appendChild(li);
  }
  
  if(pageInfo.firstBottomNumber > pageInfo.lastBottomNumber){
    li = document.createElement("li");
    li.innerHTML=`<a class="page-link" href="#" style="color: #04CF5C">`+ i +`</a>`;
    li.setAttribute("class", "page-item");    
    document.querySelector("#pagination").appendChild(li);
  }

  li = document.createElement("li");

  
  if(pageInfo.totalSize > pageInfo.lastBottomNumber) li.innerHTML=`<a class="page-link" href="#" onclick="selectFaqList(${memberTypeNo}, ${pageInfo.lastBottomNumber + 1})">&gt;</a>`;
  else li.innerHTML=`<a class="page-link" href="#" style="pointer-events:none;" >&gt;</a>`;

  li.setAttribute("class", "page-item");  
  document.querySelector("#pagination").appendChild(li);
    
}
function getPageInfo(totalSize, bottomSize, cursor){
  console.log("totalSize : " + totalSize);
  console.log("bottomSize : " + bottomSize);
  console.log("cursor : " + cursor);
  
  console.log("cursor % bottomSize : " + cursor % bottomSize);
  
  
  
  var firstBottomNumber = 0;
  if(cursor % bottomSize == 0 && cursor / bottomSize == 1){
    console.log("A");
    firstBottomNumber = cursor - (cursor-1);  //하단 최초 숫자
  }else{
    console.log("B");
    firstBottomNumber = cursor - cursor % bottomSize + 1;  //하단 최초 숫자
  }
  
  var lastBottomNumber = 0;
  if(cursor == bottomSize){
    lastBottomNumber = cursor;
  }else{
    lastBottomNumber = cursor - cursor % bottomSize + bottomSize;  //하단 마지막 숫자
  }

  console.log("firstBottomNumber : " + firstBottomNumber);
  console.log("lastBottomNumber : " + lastBottomNumber);
  
  if(lastBottomNumber > totalSize) lastBottomNumber = totalSize  //총 갯수보다 큰 경우 방지

  return {
      firstBottomNumber,
      lastBottomNumber,
      totalSize,
      cursor
  }
  
}

function init() {
  /*
  $(".que").click(function () {
      $(this).next(".anw").stop().slideToggle(300);
      $(this).toggleClass('on').siblings().removeClass('on');
      $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
  });  
  */

  $(".que").on({
    "click": function () {
      $(this).next(".anw").stop().slideToggle(300);
      $(this).toggleClass('on').siblings().removeClass('on');
      $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
    }
  });











}