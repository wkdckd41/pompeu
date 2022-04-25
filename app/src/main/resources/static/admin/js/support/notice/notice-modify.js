$(document).ready(function () {

    init();
    // 1) URL에서 쿼리스트링(query string)을 추출한다.
    var arr = location.href.split("?");
    console.log("arr = " + arr);
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



    getFileName(no);
    
    /*
        fetch(`/notice/getfilename?no=${no}`)
    .then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);

        $("#fileDelete").on("click", function () {
            fetch(`/notice/delete?no=${no}`)
            .then(function (response) {
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
    });
*/
});

function getFileName(no) {
  var xFnames = document.querySelector("#fnames")
   fetch(`/notice/get?no=${no}`)
    .then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);

        var str = ""
        for (var i = 0; i < result.fnames.length; i++) {

            //str+=`<a href="#this" onclick="fileDownLoad('${result.fnames[i].orgFile}','${result.fnames[i].realFile}')">${result.fnames[i].orgFile}</a>`

            str += `<a href="/notice/fileDownLoad?orgFile=${result.fnames[i].orgFile}
            &realFile=${result.fnames[i].realFile}" >${result.fnames[i].orgFile}</a>
            <button type="button" class="btn btn-default btn-xs" id="fileDelete"name="fileDelete" onclick="fileRemove('${no}','${result.fnames[i].realFile}');">삭제</button>`

            str += `</br>`
        }


        xFnames.innerHTML = str;
        $('#no').val(result.no);
        $("#memberTypeNo").val(result.memberTypeNo);
        $('#name').val(result.name);
        $('#content').val(result.content);
        $('#criticalCheck').prop('checked', result.criticalCheck);

        console.log("no =" + result.no);
        console.log("memberTypeNo = " + result.memberTypeNo);
        console.log("name =" + result.name);
        console.log("criticalCheck =" + result.criticalCheck);
        console.log("str = " + str);
    });
};



function fileRemove(no, realFile) {
  window.alert("삭제하시겠습니");
  console.log("no =" + no);
  console.log("realFile =" + realFile);
  
  var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

  param.set('no', no); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해
  param.set('realFile', realFile); 
  fetch("/notice/fileRemove", { 
    method: "POST",
    body: param 
  }).then(function (response) {
    return response.json();
  }).then(function (result) { 
    if (result.status == "success") {
      getFileName(no);
    } else {
      window.alert("게시글 변경 실패!");
      console.log(result.data);
    }
  });
};

function init() {
  
    $("#btnModify").on("click", function () {
        //제이쿼리 컨펌창
        var fd = new FormData(document.forms.namedItem("frm"));
        
        console.log("FormData = " + fd)

        fetch("/notice/update", {
            method: "POST",
            body: fd
        }).then(function (response) {
            return response.json();
        })
        .then(function (result) {
            if (result.status == "success") {
                //완료 얼랏 창
                location.href = "notice-list.html";
            } else {
                window.alert("게시글 변경 실패!");
                console.log(result.data);
            };
        });
    });


    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html';
    });

};
  