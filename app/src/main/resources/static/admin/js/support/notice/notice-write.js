$(document).ready(function () {    //html문서가 다 로드된후에 자바스크립트가 자동으로 실행되는 함수

    init();

});

function init() {
    $("#btnWrite").on("click", function () {

        var member_type_no = $('#member_type_no').val();
        var name = $('#name').val();
        var critical_check = null;
        if ($('input:checkbox[id="critical_check"]').is(":checked") == true) {
            critical_check = 1;
        } else {
            critical_check = 0;
        }

        var content = $('#content').val();

        console.log(member_type_no);
        console.log(name);
        console.log(critical_check);
        console.log(content);


        var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

        param.set('memberTypeNo', member_type_no); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해
        param.set('name', name);
        param.set('criticalCheck', critical_check);
        param.set('content', content);


        fetch("/notice/add", { // 컨트롤러고 가기위한 경로
            method: "POST",
            body: param         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
        }).then(function (response) {
            return response.json();
        })
            .then(function (result) { //긴 여행을 거쳐 컨트롤러에서 다시넘어온 결과값이다.
                if (result.status == "success") {
                    location.href = "notice-list.html";
                } else {
                    window.alert("게시글 등록 실패!");
                    console.log(result.data);
                }

            });

    });
}


 

