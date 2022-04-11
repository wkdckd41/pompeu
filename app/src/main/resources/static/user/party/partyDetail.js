  
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

  var xCrew = document.querySelector("#x-crew");
  var xAddress = document.querySelector("#x-address");
  var xPartyContent = document.querSelector("#x-party-content");
  var xTitle = document.querySelector("#x-title");
  var xTag = document.querySelector("#x-tag");
  var xHost = document.querySelector("#x-Host");
  var xStartDate = document.querySelector("#x-startDate");
  var xEndDate = document.querySelector("#x-endDate");
  

  fetch(`/userparty/get?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);

      }
    })

