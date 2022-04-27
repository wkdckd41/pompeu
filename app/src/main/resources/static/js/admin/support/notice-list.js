var memberTypeNo = 3; // memberTypeNo가 3인 전체조회를 하기 위해서 미리 선언해줌

$(document).ready(function () {    //html문서가 다 로드된후에 자바스크립트가 자동으로 실행되는 함수

    init();
    //alert( "ready!" );

    selectNoticeList(memberTypeNo); // 조회를 하기 위한 함수 호출 (조회를 하기위해 3번을던진다 이용자인지 크리에이터인지 전체인지 구분하기위해)

});

/*
*/

function selectMemberTypeNo(t_num) {
    memberTypeNo = t_num;

    selectNoticeList(memberTypeNo);

    //alert(memberTypeNo);
}

function selectNoticeList(no) { // 함수 호출부에서 전달 받은 데이터를 가지고 조회를 하기위한 함수 선언부
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

    param.set('memberTypeNo', no); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해

    fetch("/notice/list", { // 컨트롤러고 가기위한 경로
        method: "POST",
        body: param         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) { //긴 여행을 거쳐 컨트롤러에서 다시넘어온 결과값이다.
        console.log(result);
        var count = 0;
        for (var rst of result) {
            var tr = document.createElement("tr");
            tr.innerHTML = `<td><input type="checkbox" id = "chk_` + count
                + `" name="_selected_" value="ROW_` + count + `"></td>
          <td style="display:none"><input type="text" id= "no_` + count
                + `" value="${rst.no}""></td>
          <td>${rst.no}</td>
          <td>${rst.memberType}</td>
          <td onclick="moveView(${rst.no});">${rst.name}</td>
          <td>${rst.registerDate}</td>`;
            document.querySelector("#tbody1").appendChild(tr);
            count++;
        }
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



