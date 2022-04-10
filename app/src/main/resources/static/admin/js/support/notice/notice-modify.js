
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
    
    
    

    
    
    fetch(`/notice/get?no=${no}`)
        .then(function (response) {
            return response.json();
        })
        .then(function (result) {
            console.log(result);


            $('#no').val(result.no);
            $("#memberTypeNo").val(result.memberTypeNo);
            $('#name').val(result.name);
            $('#content').val(result.content);
            $('#criticalCheck').prop('checked', result.criticalCheck);

           

            

            
        console.log(result.name);
        console.log(result.criticalCheck);
        console.log(result.memberTypeNo);
            
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
    //제이쿼리 컨펌창
    var fd = new FormData(document.forms.namedItem("form1"));
    
    fetch("/notice/update", {
        method: "POST",
        body: new URLSearchParams(fd)
      }).then(function(response) {
        return response.json();
      })
      .then(function(result) {
        if (result.status == "success") {
          //완료 얼랏 창
          location.href = "notice-list.html";
        } else {
          window.alert("게시글 변경 실패!");
          console.log(result.data);
        }
      });
  });


    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html'
    })

  };
  