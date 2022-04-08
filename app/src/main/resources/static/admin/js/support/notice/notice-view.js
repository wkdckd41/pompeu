$(document).ready(function () {

    init();
    // 1) URL에서 쿼리스트링(query string)을 추출한다.
    var arr = location.href.split("?");
    console.log(arr);

    if (arr.length == 1) {
        alert("요청 형식이 옳바르지 않습니다.")
        throw "URL 형식 오류!";
    }

    var qs = arr[1];
    console.log("qs : " +qs);

    // 2) 쿼리 스트링에서 no 값을 추출한다.
    var params = new URLSearchParams(qs);
    var no = params.get("no");
    console.log("noticeNo : " + no);
    onclick="moveView(no);"
    var xNo = document.querySelector("#x-no");
    var xName = document.querySelector("#x-name");
    var xContent = document.querySelector("#x-content");
    var xRegisterDate = document.querySelector("#x-register-date");
    
    fetch(`/notice/get?no=${no}`)
        .then(function (response) {
            return response.json();
        })
        .then(function (result) {
            console.log(result);
            // 4 연락처 상세 정보를 화면에 출력한다.
            xNo.innerHTML = result.no;
            xName.innerHTML = result.name;
            xContent.innerHTML = result.content;
            xRegisterDate.innerHTML = result.registerDate;
            
        });
    /*
    var arr2 = no.split("=");
    if (arr2.length == 1) {
      alert("요청 형식이 옳바르지 않습니다.22222")
      throw "URL 형식 오류!222222222";
    }
    var noticeNo = arr2[1];

    console.log("noticeNo : " + noticeNo);
    */
    
  
});


function init() {

    $("#btnModify").on("click", function () {
        location.href='notice-modify.html?no='+no
 
    })

    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html'
    })

}
