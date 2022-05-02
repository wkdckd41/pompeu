var memberTypeNo = 1; 
var pageNo = 1; //default
var pageSize = 8; //default
var totalPageSize = 0; //default
var bottomSize = 3; //default


$(document).ready(function () {    

    init();
    //alert( "ready!" );

    selectNoticeList(memberTypeNo, pageNo); 

});

function selectNoticeList(no, pgNo) { 
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();

    param.set('memberTypeNo', no);
    param.set('pageNo', pgNo);
    param.set('pageSize', pageSize);

    console.log(param);

    fetch("/notice/list", { 
        method: "POST",
        body: param         
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);
        var count = 0;
        for (var rst of result.noticeList) {
            var tr = document.createElement("tr");
            tr.innerHTML = `
          <td style="display:none"><input type="text" id= "no_` + count
                + `" value="${rst.no}""></td>
          <td style="text-align: center" class="td_notice_td"><span class="label label-success td_notice">공지</span></td>
          <td onclick="moveView(${rst.no});" class="td_tt">${rst.name}</td>
          <td class="td_date">${rst.registerDate}</td>`;
            document.querySelector("#tbody1").appendChild(tr);
            count++;
        }

        totalPageSize = result.totalPageSize;
        console.log("totalPageSize : " + totalPageSize);
        pageNo = result.pageNo;
        pageSize = result.pageSize;
        
        makePageNavi(totalPageSize, bottomSize, pageNo);        
    });
//<td>${rst.no}</td>
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
        console.log("i : " + i);
        li.innerHTML=`<a class="page-link" href="#" onclick="selectNoticeList(${memberTypeNo}, ${i})">`+ i +`</a>`;
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
            var result = Swal.fire({
                title: '삭제하시겠습니까?',
                icon: 'warning',
                showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
                confirmButtonText: '승인', // confirm 버튼 텍스트 지정
                cancelButtonText: '취소', // cancel 버튼 텍스트 지정
                reverseButtons: true, // 버튼 순서 거꾸로
                })
       
        }

        var param = new URLSearchParams(); 

        param.set('memberTypeNo', str.substr(0, str.length - 1)); 

        fetch("/notice/deleteAll", { 
            method: "POST",
            body: param 
        }).then(function (response) {
            return response.json();
        })
        .then(function (result) { 
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

  

