var memberTypeNo = 3;

$(document).ready(function () {

    init();
    //alert( "ready!" );

    selectFaqList(memberTypeNo);

});

/*
*/

function selectMemberTypeNo(t_num) {
    memberTypeNo = t_num;

    selectFaqList(memberTypeNo);

    //alert(memberTypeNo);
}

function selectFaqList(no) {
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();

    param.set('memberTypeNo', no);

    fetch("/faq/list", {
        method: "POST",
        body: param
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) {
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
          <td onclick="moveView(${rst.no});">${rst.ask}</td>
          <td>${rst.registerDate}</td>`;
            document.querySelector("#tbody1").appendChild(tr);
            count++;
        }

    });

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



