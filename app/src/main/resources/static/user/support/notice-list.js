var memberTypeNo = 1; 

$(document).ready(function () {    

    init();
    //alert( "ready!" );

    selectNoticeList(memberTypeNo); 

});

function selectNoticeList(no) { 
    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();

    param.set('memberTypeNo', no);

    fetch("/notice/list", { 
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
            tr.innerHTML = `
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

  

