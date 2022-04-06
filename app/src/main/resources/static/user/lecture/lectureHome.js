$(".headers").load("../admin2.html"); /*사이드바 관련 코드*/

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


function selectLectureTypeNo (type) {
    console.log(type);
  $("#inOutEx").val(type);
  
  var params = { 
   "inOutEx":  $("#inOutEx").val()
}; 

var paramData = Object.keys(params) 
            .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k])) 
            .join('&'); 

var url = '/userLecture/list?' + paramData;

  var exName = document.getElementById("exercise");
  var name = document.getElementById("lecture-name");
  var lecturePrice = document.getElementById("lecture-price");


var body1 = document.querySelector("#body1");

    while (body1.hasChildNodes()) {
        body1.removeChild(body1.firstChild);
    }

   fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      for (var rst of result){
          console.log(rst);
          
     exName= rst.exName
     name= rst.name
     lecturePrice= rst.lecturePrice
     }
     exName.innerHTML = exName
     name.innerHTML = exName
     lecturePrice.innerHTML = exName
  })
}
      