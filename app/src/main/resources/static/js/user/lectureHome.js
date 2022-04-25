 // 템플릿 엔진에서 사용할 HTML 조각을 가져오기
  var trTemplate = document.querySelector("#tr-template");
  
  //템플릿 엔진 준비
  var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);


// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    animationLoop: false,
    itemWidth: 100,
    itemMargin: 5,
    minItems: 8,
    maxItems: 8
  });
});


var btnEverything = document.getElementById("btn-everything");
btnEverything.addEventListener('click', function () {
  loadList();
})


  var btnOut = document.getElementById("btn-out");
btnOut.addEventListener('click', function() {
  loadList();
})


  var btnIn = document.getElementById("btn-in");
btnIn.addEventListener('click', function() {
  loadList();
})

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
  var inOut = document.querySelector("input[name=inout]:checked").value;
  var sort = document.querySelector("#inputTag").value;
 
  console.log(region, inOut, sort);
 
  var url = "/userLecture/findEverything";
  if (inOut == "in") {
    url = "/userLecture/findIn";
  } else if (inOut == "out") {
    url = "/userLecture/findOut";
  }
 
  fetch(`${url}?sort=${sort}&region=${region}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
     
      $("#class-box").html(htmlGenerator(result));
    })
}



  $("#btn-everything").click();

  function moveView(no) {
  location.href = 'lecture-detail.html?no='+no
}
