  
  var arr = location.href.split("?");
  console.log(arr);

  if (arr.length == 1) {
    alert("요청 형식이 옳바르지 않습니다.")
    throw "URL 형식 오류!";
  }

  var qs = arr[1];
  console.log(qs);

  var params = new URLSearchParams(qs);
  var no = params.get("no");

  if (no == null) {
    alert("게시글 번호가 없습니다.");
    throw "파라미터 오류!";
  }
  console.log(no);
  
  var xAddress1 = document.querySelector("#x-address1");
  var xAddress2 = document.querySelector("#x-address2");
  var xTitle = document.querySelector("#x-title");
  var xPartyContent = document.querySelector("#x-partyContent");
  var xStartDate = document.querySelector("#x-startDate");
  var xEndDate = document.querySelector("#x-endDate");
  var xCrew = document.querySelector("#x-crew");
  var xTag = document.querySelector("#x-tag");
  var xHost = document.querySelector("#x-host");
  
  
  fetch(`/userparty/get?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      xAddress1.innerHTML = result[0].doo;
      xAddress2.innerHTML = result[0].doo;
      xTitle.innerHTML = result[0].title;
      xPartyContent.innerHTML = result[0].content;
      xStartDate.innerHTML = result[0].startDate;
      xEndDate.innerHTML = result[0].endDate;
      xCrew.innerHTML = result[0].maxMember;
      xTag.innerHTML = result[0].tag;
      xHost.innerHTML = result[0].name;
    })
    
    
    // 소모임 이미지 등록
    var xImgBox = document.querySelector("#x-img-box")

    fetch(`/userparty/addImage?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      xImgBox.innerHTML = `<img src="/userparty/image?filename=${result[0].image}" width="350px" height="210px">`;
})