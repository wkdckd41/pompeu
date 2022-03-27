

  var memberTypeNo = document.querySelector("#member_type_no");
  var naame = document.querySelector("#name");
  var nickname = document.querySelector("#nickName");
  var email = document.querySelector("#email");
  var phone = document.querySelector("#phone");
  var joinDate = document.querySelector("#join_date");
  var loginDate = document.querySelector("#login_date");

document.addEventListener("DOMContentLoaded", function(){
  fetch(`/member/list`)
    .then(function(response) {
      return response.json();
    })
      .then(function(result) {
	      console.log(result[0]);
      // 4 연락처 상세 정보를 화면에 출력한다.
      memberTypeNo.value = result[0].memberTypeNo;
      naame.value = result[0].name;
      nickname.value = result[0].nickName;
      email.value = result[0].email;
      phone.value = result[0].phone;
      joinDate.value = result[0].joinDate;
      loginDate = result[0].loginDate;
    });
});
    
