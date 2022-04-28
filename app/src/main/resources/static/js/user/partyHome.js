$(document).ready(function(){
  
  console.log("start");
});

// 템플릿 엔진에서 사용할 HTML 조각을 가져오기
var trTemplate = document.querySelector("#tr-template");

//템플릿 엔진 준비
var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);

document.querySelector("input[name=fruit][value=all]").checked = true;
loadList();

function onClickRegion(e) {
  console.log(e.currentTarget);
  var selectedRegion = document.querySelector(".region-selected");
  if (selectedRegion != undefined) {
    selectedRegion.classList.remove("region-selected");
  }
  e.currentTarget.classList.add("region-selected");
  loadList();
}

function loadList() {
  var region = "all";
  var selectedRegion = document.querySelector(".region-selected div");
  if (selectedRegion != undefined) {
    region = selectedRegion.innerHTML;
  }
  var sort = document.querySelector("#inputTag").value;
  var inOutEx = document.querySelector("input[name=fruit]:checked").value;
  console.log(region,sort,inOutEx);
  
    fetch(`/userparty/list?sort=${sort}&inOutEx=${inOutEx}&region=${region}`)
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


function readImage() {
  for (var i = 0;  i < `${maxMember}`; i++){
    document.write("<img src="/user/party/img/crew.png/">");
    //`<a><img src="/user/party/img/crew.png/" style="width:45px; height:45px;"/></a>`
  }
}