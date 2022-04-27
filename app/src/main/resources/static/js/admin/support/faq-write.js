var gubunNo = null

$(document).ready(function () {
    init();

    var arr = location.href.split("?");
    console.log(arr);

    var qs = arr[1];
    console.log("qs : " + qs);

    // 2) 쿼리 스트링에서 no 값을 추출한다.
    var params = new URLSearchParams(qs);
    var no = params.get("no");
    gubunNo = no
    console.log("faqNo : " + no);

    if (no != null) {

        fetch(`/faq/get?no=${no}`)
        .then(function (response) {
            return response.json();
        })
        .then(function (result) {
            console.log(result);

            $('#member_type_no').val(result.memberTypeNo);
            $('#ask').val(result.ask);
            $('#answer').val(result.answer);
        });

        document.querySelector("#faqHead").innerHTML = "FAQ 수정하기";
        document.querySelector("#btnWrite").innerHTML = "수정";
    }
});

function init() {
    $("#btnWrite").on("click", function () {

        var member_type_no = $('#member_type_no').val();
        var ask = $('#ask').val();
        var answer = $('#answer').val();

        console.log(member_type_no);
        console.log(ask);
        console.log(answer);

        var param = new URLSearchParams();
        param.set('memberTypeNo', member_type_no);
        param.set('ask', ask);
        param.set('answer', answer);

        var addr = "";
        if (gubunNo == null) {

            addr = "/faq/add"
        } else {
            addr = "/faq/update"
            param.set('no', gubunNo);
        }
        console.log("addr =" + addr)

        fetch(addr, {
            method: "POST",
            body: param
        }).then(function (response) {
            return response.json();
        })
        .then(function (result) {
            if (result.status == "success") {
                location.href = "faq-list.html";
            } else {
                window.alert("게시글 등록 실패!");
                console.log(result.data);
            }

        });

    });

    $("#btnCancel").on("click", function () {
        location.href = 'faq-list.html'
    })
}


 

