$(document).ready(function(){
  
  
  console.log("start");
  selectBtnTypeNo("");
  
    
});

// 템플릿 엔진에서 사용할 HTML 조각을 가져오기
var trTemplate = document.querySelector("#tr-template");

//템플릿 엔진 준비
var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);

document.querySelector("input[name=fruit][value=all]").checked = true;
loadList();


function loadList() {
  var sort = document.querySelector("#inputTag").value;
  var inOutEx = document.querySelector("input[name=fruit]:checked").value;
  console.log(sort,inOutEx);
    fetch(`/userparty/list?sort=${sort}&inOutEx=${inOutEx}`)
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