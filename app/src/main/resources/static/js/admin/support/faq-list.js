var memberTypeNo = 3;
var pageNo = 1; //default
var pageSize = 8; //default
var totalPageSize = 0; //default
var bottomSize = 3; //default

$(document).ready(function () {

    init();
    //alert( "ready!" );

    selectFaqList(memberTypeNo, pageNo);

});

/*
*/

function selectMemberTypeNo(t_num) {
    memberTypeNo = t_num;

    selectFaqList(memberTypeNo, pageNo);

    //alert(memberTypeNo);
}

function selectFaqList(no, pgNo) {
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();

    param.set('memberTypeNo', no);
    param.set('pageNo', pgNo);
    param.set('pageSize', pageSize);

    fetch("/faq/list", {
        method: "POST",
        body: param
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);
        var count = 0;
        for (var rst of result.faqList) {
            var tr = document.createElement("tr");
            tr.innerHTML = `<td><input type="checkbox" id = "chk_` + count
                + `" name="_selected_" value="ROW_` + count + `"></td>
          <td style="display:none"><input type="text" id= "no_` + count
                + `" value="${rst.no}""></td>
          <td>${rst.no}</td>
          <td>${rst.memberType}</td>
          <td onclick="moveView(${rst.no});" class="admin_table_name">${rst.ask}</td>
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
      li.innerHTML=`<a class="page-link" href="#" style="color: red">`+ i +`</a>`;
    }else{
      li.innerHTML=`<a class="page-link" href="#" onclick="selectFaqList(${memberTypeNo}, ${i})">`+ i +`</a>`;
    }
    li.setAttribute("class", "page-item");    
    document.querySelector("#pagination").appendChild(li);
  }
  
  if(pageInfo.firstBottomNumber > pageInfo.lastBottomNumber){
    li = document.createElement("li");
    li.innerHTML=`<a class="page-link" href="#" style="color: red">`+ i +`</a>`;
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
    $("#btnWrite").on("click", function () {
        location.href = 'faq-write.html'
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

        var param = new URLSearchParams();

        param.set('memberTypeNo', str.substr(0, str.length - 1));

        fetch("/faq/deleteAll", {
            method: "POST",
            body: param
        }).then(function (response) {
            return response.json();
        })
        .then(function (result) {
            if (result.status == "success") {
                location.href = "faq-list.html";
            } else {
                window.alert("게시글 변경 실패!");
                console.log(result.data);
            }

        });

    });
}

function moveView(no) {
    location.href = 'faq-write.html?no=' + no
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



