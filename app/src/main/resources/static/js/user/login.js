const xEmail = document.querySelector('input[name=email]');
const xPassword = document.querySelector('input[name=password]');
const xBtn = document.querySelector('.login_btn')


// let fd = new FormData(document.forms.namedItem('form[name=login]'));
// const fd = new URLSearchParams();
// fd.set(xEmail.nodeName, xEmail.value);
// fd.set(xPassword.nodeName, xEmail.value);



// const fd = new FormData();
// fd.append(xEmail, xEmail.value);
// fd.append(xPassword, xPassword.value);
//    headers: {
//            'Content-Type': 'application/json'
//        },
//        body: JSON.stringify({
//            email: xEmail.value,
//            password: xPassoword.value
//        })


document.querySelector('form[name=login]').onsubmit = function () {
    if (xEmail.value == "") {
        alert("이메일을 입력해주세요.");
        $("input[type=email]").focus();

    } else if (xPassword.value == "") {
        alert("비밀번호를 입력해주세요.");
        $("input[type=password]").focus();
        return false;
    }
}


xBtn.addEventListener('click', (e) => {
    // e.preventDefault();
    e.stopPropagation();

    // console.log(save);
    fetch('/user/login', {
            method: 'POST',
            // headers: {
            //     'Content-Type': 'application/json'
            // },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            // body: JSON.stringify({
            //     email: xEmail.value,
            //     password: xPassword.value
            // })
            body: new URLSearchParams({
                email: xEmail.value,
                password: xPassword.value
            })
        })
        .then(function (resp) {
            console.log(resp);
            return resp.text();
        })
        .then(function (text) {
            location.replace = '/user/login/login.html';
            if (text == "admin") {
                location.href = "/admin/main/admin-main.html";
            } else if (text == "creator") {
                location.href = "/creator2/nouse/creator_original_form.html";
            } else if (text == "user") {
                location.href = "/user/main/user-main.html"
            } else if (text == "fail") {
                alert("다시 로그인해주세요");
            }
        })
    // .then(function (text) {
    //     if (text == "success") {
    //         alert("로그인 되었습니다.");
    //         location.href = "/user/main/user-main.html";
    //     } else {
    //         window.alert("로그인 실패");
    //     }
    // })
})