var btn = document.getElementById("regiBtn");
btn.addEventListener('click', function() {
  var name = document.querySelector("#name").value;
  var email = document.querySelector("#email").value;
  var password = document.querySelector("#password").value;
  var phone = document.querySelector("#phone").value;
  var nickName = document.querySelector("#nick_name").value;
  var birth = document.querySelector("#birth").value;
  var gender = document.querySelector("#gender").value;
  
  
    
  console.log("name : " + name);
  console.log("email : " + email);
  console.log("password : " + password);
  console.log("phone : " + phone);
  console.log("nickName : " + nickName);
  console.log("birth : " + birth);
  console.log("gender : " + gender);
  
  
  if (birth == "" || email == "" || password == "") {    
    window.alert("필수 입력 항목이 비어 있습니다.");
    return;
  }
  
  
  fetch(`/member/memberRegi?name=${name}&email=${email}&phone=${phone}&nickName=${nickName}&birth=${birth}&gender=${gender}&password=${password}`)
    .then(function(response) {
        return response.text();
      })
      .then(function(text) {
        console.log(text);
        location.href = "memberList.html";
      });
  
});