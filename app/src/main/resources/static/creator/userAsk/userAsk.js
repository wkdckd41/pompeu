  // 템플릿 엔진에서 사용할 HTML 조각을 가져오기
  var trTemplate = document.querySelector("#tr-template");
  
  //템플릿 엔진 준비
  var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);


   var lectureDropdown = document.querySelector("#lecture-dropdown");
   
    fetch(`/userAsk/askDrop?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
     })
     
     