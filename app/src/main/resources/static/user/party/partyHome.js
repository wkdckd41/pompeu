$(document).ready(function(){
  console.log("start");
  selectBtnTypeNo("");
});

// 템플릿 엔진에서 사용할 HTML 조각을 가져오기
var trTemplate = document.querySelector("#tr-template");

//템플릿 엔진 준비
var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);

function selectBtnTypeNo (type) {
  console.log(type);
  $("#inOutEx").val (type);
  
  var params = { 
   "inOutEx":  $("#inOutEx").val()
}; 

var paramData = Object.keys(params) 
            .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k])) 
            .join('&'); 

var url = '/userparty/list?' + paramData;

  
  //fetch("/userparty/list")
   fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      $("#party-index").html(htmlGenerator(result));

    });
}


function moveView(no) {
  location.href = 'party-detail.html?no=' + no
}

function moveRegist() {
  location.href = 'party-regist.html'
}