var memberTypeNo = 3; // memberTypeNo가 3인 전체조회를 하기 위해서 미리 선언해줌
var pageNo = 1; //default
var pageSize = 8; //default
var totalPageSize = 0; //default
var bottomSize = 3; //default

$(document).ready(function () {    //html문서가 다 로드된후에 자바스크립트가 자동으로 실행되는 함수

    init();
    //alert( "ready!" );

    selectNoticeList(memberTypeNo, pageNo); // 조회를 하기 위한 함수 호출 (조회를 하기위해 3번을던진다 이용자인지 크리에이터인지 전체인지 구분하기위해)

});

/*
*/

function selectMemberTypeNo(t_num) {
    memberTypeNo = t_num;

    selectNoticeList(memberTypeNo, pageNo);

    //alert(memberTypeNo);
}

function selectNoticeList(no, pgNo) { // 함수 호출부에서 전달 받은 데이터를 가지고 조회를 하기위한 함수 선언부
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();
    
    param.set('memberTypeNo', no);
    param.set('pageNo', pgNo);
    param.set('pageSize', pageSize);

    console.log(param);

    fetch("/notice/list", { // 컨트롤러고 가기위한 경로
        method: "POST",
        body: param         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) { //긴 여행을 거쳐 컨트롤러에서 다시넘어온 결과값이다.
        console.log(result);
        var count = 0;
        for (var rst of result.noticeList) {
            var tr = document.createElement("tr");
            tr.innerHTML = `<td><input type="checkbox" id = "chk_` + count
                + `" name="_selected_" value="ROW_` + count + `"></td>
          <td style="display:none"><input type="text" id= "no_` + count
                + `" value="${rst.no}""></td>
          <td>${rst.no}</td>
          <td>${rst.memberType}</td>
          <td onclick="moveView(${rst.no});" class="admin_table_name">${rst.name}</td>
          <td>${rst.registerDate}</td>`;
            document.querySelector("#tbody1").appendChild(tr);
            count++;
        }
        
        totalPageSize = result.totalPageSize;
        console.log("totalPageSize : " + totalPageSize);
        pageNo = result.pageNo;
        pageSize = result.pageSize;
        
        makePageNavi(totalPageSize, bottomSize, pageNo);
        
    });

    /*
    fetch(`/notice/list?memberTypeNo=${memberTypeNo}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
      for (var rst of result) {
        var tr = document.createElement("tr");
        tr.innerHTML = `<td>${rst.total}</td>
        <td>${rst.creator}</a></td>
        <td>${rst.user}</td>`;
        document.querySelector("#tbody1").appendChild(tr);
      }
    });
    */

}

function makePageNavi(totalPageSize, bottomSize, pageNo){
  var pagination = document.querySelector("#pagination");
  while (pagination.hasChildNodes()) {
      pagination.removeChild(pagination.firstChild);
  }
  
  var pageInfo = getPageInfo(totalPageSize, bottomSize, pageNo);
  
  var li = document.createElement("li");
  
  if(pageInfo.firstBottomNumber==1) li.innerHTML=`<a class="page-link" href="#" style="pointer-events:none;" >&lt;</a>`;
  else li.innerHTML=`<a class="page-link" href="#" onclick="selectNoticeList(${memberTypeNo}, ${pageInfo.firstBottomNumber - 1})">&lt;</a>`;
  
  li.setAttribute("class", "page-item");    
  document.querySelector("#pagination").appendChild(li);
  
  for(var i=pageInfo.firstBottomNumber; i<=pageInfo.lastBottomNumber; i++){
    li = document.createElement("li");
    
    if(i==pageInfo.cursor){
      console.log("현재페이지 : " + i);
      li.innerHTML=`<a class="page-link" href="#" style="color: red">`+ i +`</a>`;
    }else{
      li.innerHTML=`<a class="page-link" href="#" onclick="selectNoticeList(${memberTypeNo}, ${i})">`+ i +`</a>`;
    }
    li.setAttribute("class", "page-item");    
    document.querySelector("#pagination").appendChild(li);
  }
  li = document.createElement("li");

  
  if(pageInfo.totalSize > pageInfo.lastBottomNumber) li.innerHTML=`<a class="page-link" href="#" onclick="selectNoticeList(${memberTypeNo}, ${pageInfo.lastBottomNumber + 1})">&gt;</a>`;
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
    $("#btnWrite").on("click", function () {
        location.href = 'notice-write.html'
    })

    $("#btnDelete").on("click", function () {

        var chkId = '#chk_';
        var noId = '#no_';
        var str = '';

        for (var i = 0; i < $('#tbody1').children().length; i++) {
            if ($(chkId + i).is(':checked') == true) {
                str = str + "" + $(noId + i).val() + ",";
            }
        }

        if (str == '') {
            alert("선택된 내역이 없습니다.");
            return;
        } else {
            var result = confirm('삭제하시겠습니까?');
            if (!result) { //yes
                return;
            }
        }

        var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

        param.set('memberTypeNo', str.substr(0, str.length - 1)); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해

        fetch("/notice/deleteAll", { // 컨트롤러고 가기위한 경로
            method: "POST",
            body: param         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
        }).then(function (response) {
            return response.json();
        })
        .then(function (result) { //긴 여행을 거쳐 컨트롤러에서 다시넘어온 결과값이다.
            if (result.status == "success") {
                location.href = "notice-list.html";
            } else {
                window.alert("게시글 변경 실패!");
                console.log(result.data);
            }

        });

    });
}

function moveView(no) {
    location.href = 'notice-view.html?no=' + no
}

//체크박스 전체선택 및 해제 기능은

$('input[name=_selected_all_]').on('change', function () {
    $('input[name=_selected_]').prop('checked', this.checked);
});

var arr = $('input[name=_selected_]:checked').serializeArray().map(
    function (item) {
        return item.value
    });
//var str = $('input[name=_selected_]:checked').serialize(); // 이건 QueryString 방식으로



