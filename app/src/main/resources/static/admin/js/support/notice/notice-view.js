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
    console.log("qs : " + qs);

    // 2) 쿼리 스트링에서 no 값을 추출한다.
    var params = new URLSearchParams(qs);
    var no = params.get("no");
    console.log("noticeNo : " + no);

    var xNo = document.querySelector("#x-no")
    var xName = document.querySelector("#x-name")
    var xContent = document.querySelector("#x-content")
    var xRegisterDate = document.querySelector("#x-register-date")

    var xFnames = document.querySelector("#fnames")

    fetch(`/notice/get?no=${no}`)
    .then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);
        // 4 연락처 상세 정보를 화면에 출력한다.
        var str = ""
        for (var i = 0; i < result.fnames.length; i++) {

            //str+=`<a href="#this" onclick="fileDownLoad('${result.fnames[i].orgFile}','${result.fnames[i].realFile}')">${result.fnames[i].orgFile}</a>`

            str += `<label><a href="/notice/fileDownLoad?orgFile=${result.fnames[i].orgFile}&realFile=${result.fnames[i].realFile}" >${result.fnames[i].orgFile}</a></label>&nbsp`
  
        }
        
        xFnames.innerHTML = str;
        xNo.innerHTML = result.no;
        xName.innerHTML = result.name;
        xContent.innerHTML = result.content;
        xRegisterDate.innerHTML = result.registerDate;

        console.log("no =" + result.no);
        console.log("name =" + result.name);
        console.log("content =" + result.content)
        console.log("criticalCheck =" + result.criticalCheck);
        console.log("str = " + str);

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
        var no = document.querySelector("#x-no").innerHTML
        location.href = 'notice-modify.html?no=' + no

    })

    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html'
    })

}

/*
function fileDownLoad(orgFile, realFile){
    console.log("orgFile : " + orgFile);
    console.log("realFile : " + realFile);
    var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

    param.set('orgFile', orgFile); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해
    param.set('realFile', realFile);
   
    
    fetch("/notice/fileDownLoad", { // 컨트롤러고 가기위한 경로
        method: "POST",
        body: param         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) { //긴 여행을 거쳐 컨트롤러에서 다시넘어온 결과값이다.
        if (result.status == "success") {
            alert("다운로드 되었습니다.");
        } else {
            console.log(result.data);
        }

    });
}
*/