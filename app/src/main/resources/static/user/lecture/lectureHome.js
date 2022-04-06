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



  var btnOut = document.getElementById("btn-out");

btnOut.addEventListener('click', function() {
  
  var exName = document.querySelector("#exercise");
  var name = document.querySelector("#lecture-name");
  var lecturePrice = document.querySelector("#lecture-price");
  
  console.log("exname : " + exName);
  console.log("name : " + name);
  console.log("price : " + lecturePrice);
  
  fetch(`/userLecture/findOut`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      for (var rst of result) {
      console.log(rst);
      console.log(rst.lecturePrice)
      
      exName.innerHTML = rst.exName;
      name.innerHTML = rst.name;
      lecturePrice.innerHTML = rst.lecturePrice;
}
})
})