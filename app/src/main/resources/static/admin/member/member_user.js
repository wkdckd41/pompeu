

  var memberType = document.querySelector("#member_type_nos");
  var naame = document.querySelector("#names");
  var nickname = document.querySelector("#nickNames");
  var email = document.querySelector("#emails");
  var phone = document.querySelector("#phones");
  var joinDate = document.querySelector("#join_dates");
  var loginDate = document.querySelector("#login_dates");


  // 1) URL에서 쿼리스트링(query string)을 추출한다.
  var arr = location.href.split("?");
  console.log(arr);

  if (arr.length == 1) {
    alert("요청 형식이 옳바르지 않습니다.")
    throw "URL 형식 오류!";
  }

  var qs = arr[1];
  console.log(qs);

  // 2) 쿼리 스트링에서 email 값을 추출한다.
  var params = new URLSearchParams(qs);
  var no = params.get("no");

  if (no == null) {
    alert("독서록 번호가 없습니다.");
    throw "파라미터 오류!";
  }
  console.log(no);

  fetch(`/member/get?no=${no}`)
    .then(function(response) {
      return response.json();
    })
      .then(function(result) {
	      console.log(result);
      // 4 연락처 상세 정보를 화면에 출력한다.
      memberType.innerHTML = result.memberType.memberType;
      naame.innerHTML = result.name;
      nickname.innerHTML = result.nickName;
      email.innerHTML = result.email;
      phone.innerHTML = result.phone;
      joinDate.innerHTML = result.joinDate;
      loginDate.innerHTML = result.loginDate;
    });

    
