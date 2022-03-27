

  var memberTypeNo = document.querySelector("#member_type_nos");
  var naame = document.querySelector("#names");
  var nickname = document.querySelector("#nickNames");
  var email = document.querySelector("#emails");
  var phone = document.querySelector("#phones");
  var joinDate = document.querySelector("#join_dates");
  var loginDate = document.querySelector("#login_dates");

document.addEventListener("DOMContentLoaded", function(){
  fetch(`/member/get?no={no}`)
    .then(function(response) {
      return response.json();
    })
      .then(function(result) {
	      console.log(result);
      // 4 연락처 상세 정보를 화면에 출력한다.
      memberTypeNo.innerHTML = result.memberTypeNo;
      naame.innerHTML = result.name;
      nickname.innerHTML = result.nickName;
      email.innerHTML = result.email;
      phone.innerHTML = result.phone;
      joinDate.innerHTML = result.joinDate;
      loginDate.innerHTML = result.loginDate;
    });
});
    
