
$(document).ready(function () {    //html문서가 다 로드된후에 자바스크립트가 자동으로 실행되는 함수

    init();

});

function init() {

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
    console.log("ask : " + no);

    var memberEmail = document.querySelector("#memberEmail");
    var askName = document.querySelector("#askName");
    var askContent = document.querySelector("#askContent");
    var answerContent = document.querySelector("#answerContent");

    fetch(`/ask/get?no=${no}`)
        .then(function (response) {
            return response.json();
        })
        .then(function (result) {
            console.log(result);
            // 4 연락처 상세 정보를 화면에 출력한다.
            askName.innerHTML = result.askName;
            memberEmail.innerHTML = result.memberEmail;
            askContent.innerHTML = result.askContent;
            answerContent.innerHTML = result.answerContent;

            console.log("askName =" + result.askName);
            console.log("memberEmail =" + result.memberEmail);
            console.log("askContent =" + result.askContent);
            console.log("answerContent =" + result.answerContent);


        });


    $("#btnWrite").on("click", function () {

        console.log("ask = "+ no);
        // var askContent = $('#askContent').val();

        // console.log("askContent =" + askContent);

        // var fd = new FormData(document.forms.namedItem("frm"));



        // var askContent = $('#askContent').val();


        // console.log(askContent);

        // var param = new URLSearchParams();


        // param.set('askContent', askContent);

        // fetch("/ask/add", { 
        //     method: "post",
        //     body: param       
        // }).then(function (response) {
        //     return response.json();
        // })
        //     .then(function (result) {
        //         if (result.status == "success") {
        //             location.href = "ask-list.html";
        //         } else {
        //             window.alert("게시글 등록 실패!");
        //             console.log(result.data);
        //         }

        //     });

            //제이쿼리 컨펌창
            var fd = new FormData(document.forms.namedItem("frm"));
            fd.append('no',no);
            console.log("FormData = " + fd)
    
            fetch("/ask/update", {
                method: "POST",
                body: fd
            }).then(function (response) {
                return response.json();
            })
            .then(function (result) {
                if (result.status == "success") {
                    //완료 얼랏 창
                    location.href = "ask-list.html";
                } else {
                    window.alert("게시글 변경 실패!");
                    console.log(result.data);
                }
                ;
            });
        });



    $("#btnCancel").on("click", function () {
        location.href = 'ask-list.html'
    })

}




