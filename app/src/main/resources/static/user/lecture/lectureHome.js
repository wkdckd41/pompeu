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

  btnEverything.addEventListener('click', function() {
  
  var exName = document.querySelector("#exercise");
  var name = document.querySelector("#lecture-name");
  var lecturePrice  = document.querySelector("#lecture-price");
  
  
  console.log("exname : " + exName);
  console.log("name : " + name);
  console.log("price : " + lecturePrice);
    
  fetch(`/userLecture/findEverything`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      $("#class-box").html(htmlGenerator(result));
})
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

function loadList() {
  var inOut = document.querySelector("input[name=inout]:checked").value;
  var sort = document.querySelector("#inputTag").value;
  
  console.log(inOut, sort);
  
  var url = "/userLecture/findEverything";
  if (inOut == "in") {
    url = "/userLecture/findIn";
  } else if (inOut == "out") {
    url = "/userLecture/findOut";
  }
  
  fetch(`${url}?sort=${sort}`)
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





