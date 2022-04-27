// $('head').append($('<link rel="stylesheet"/>').attr('href', '/css/user_common.css'));
// $('head').append($('<link rel="stylesheet"/>').attr('href', '/user/login/layout.css'));
$("#header").load("/form/user/header.html");
$("#footer").load("/form/user/footer.html");

function css(selector, name, value) {
    let el = document.querySelectorAll(selector);
    for (const e of el) {
        e.style[name] = value;
    }
}

fetch("/login/getLoginUser")
    .then((response) => {
        return response.text();
    })
    .then((result) => {
        if (result == "success") {
            css(".notLoginUser", "display", "none");
            css(".loginUser", "display", "inline");
        }
    });