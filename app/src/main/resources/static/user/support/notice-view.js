$(document).ready(function () {

    init();
   
    var arr = location.href.split("?");
    console.log(arr);

    if (arr.length == 1) {
        alert("요청 형식이 옳바르지 않습니다.")
        throw "URL 형식 오류!";
    }

    var qs = arr[1];
    console.log("qs : " + qs);


    var params = new URLSearchParams(qs);
    var no = params.get("no");
    console.log("noticeNo : " + no);

    var xNo = document.querySelector("#x-no")
    var xName = document.querySelector("#x-name")
    var xContent = document.querySelector("#x-content")
    var xRegisterDate = document.querySelector("#x-register-date")

    fetch(`/notice/get?no=${no}`)
    .then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);

        xNo.innerHTML = result.no;
        xName.innerHTML = result.name;
        xContent.innerHTML = result.content;
        xRegisterDate.innerHTML = result.registerDate;

    });

});

function init() {


    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html'
    })

}
