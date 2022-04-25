var count = 0;
$(document).ready(function () {    //html문서가 다 로드된후에 자바스크립트가 자동으로 실행되는 함수

    init();

});

function init() {

    var fileTarget = $('.filebox .upload-hidden');

    fileTarget.on('change', function (e) {
        if (window.FileReader) {
            console.log($(this)[0].files);
            var filename = "";

            filename = $(this)[0].files[0].name;

            if ($(this)[0].files.length > 1) {
                filename += " 외 " + ($(this)[0].files.length - 1) + "건";
            }

        } else {
            // Old IE 파일명 추출
            var filename = $(this).val().split('/').pop().split('\\').pop();
        }
        ;

        $(this).siblings('.upload-name').val(filename);
    });

    //preview image
    var imgTarget = $('.preview-image .upload-hidden');

    imgTarget.on('change', function () {
        var parent = $(this).parent();
        parent.children('.upload-display').remove();

        if (window.FileReader) {
            //image 파일만
            for (var i = 0; i < $(this)[0].files.length; i++) {
                if (!$(this)[0].files[i].type.match(/image\//)) {
                    return;
                }
                var reader = new FileReader();
                reader.onload = function (e) {
                    console.log(e.target)
                    var src = e.target.result;
                    console.log(src);
                    parent.prepend(
                        '<div class="upload-display"><div class="upload-thumb-wrap"><img src="'
                        + src
                        + '" class="upload-thumb" style="height:50px;" ></div></div>');
                }
                reader.readAsDataURL($(this)[0].files[i]);
            }

        } else {
            $(this)[0].select();
            $(this)[0].blur();
            var imgSrc = document.selection.createRange().text;
            parent.prepend(
                '<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

            var img = $(this).siblings('.upload-display').find('img');
            img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""
                + imgSrc + "\")";
        }
    });

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

        console.log("memberTypeNo =" + member_type_no);
        console.log("name =" + name);
        console.log("criticalCheck =" + critical_check);
        console.log("content = " + content);
        /*
        var param = new URLSearchParams(); // 파라미터를 가지고 가기위해 객체생성을 해준것

        param.set('memberTypeNo', member_type_no); //meberTypeNo 도메인에 정의되있는 변수명으로 맵핑을해준다 why? 도메인롬북이 읽게하기위해
        param.set('name', name);
        param.set('criticalCheck', critical_check);
        param.set('content', content);
        */
        var fd = new FormData(document.forms.namedItem("frm"));
        fd.append("criticalCheck", critical_check)

        fetch("/ask/add", { // 컨트롤러고 가기위한 경로
            method: "POST",
            body: fd         // 파라미터 객체를 세팅해준다. 커트롤러로 고고!!
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
    $("#btnCancel").on("click", function () {
        location.href = 'notice-list.html'
    })

}


 

