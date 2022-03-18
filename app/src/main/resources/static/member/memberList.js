document.addEventListener("DOMContentLoaded", function(){
   fetch("/member/findCount")
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
      for (var rst of result) {
        var tr = document.createElement("tr");
        tr.innerHTML = `<td>${rst.total}</td>
        <td>${rst.creator}</a></td>
        <td>${rst.user}</td>`;
        document.querySelector("#tbody1").appendChild(tr);
      }
    });
});

var btn = document.getElementById("srchBtn");
btn.addEventListener('click', function() {
  var nickName = document.querySelector("#nick_name").value;
  var phone = document.querySelector("phone").value;
  var email = document.querySelector("email").value;
  var useCheck = document.querySelector("use_check").value;
  
  console.log("nickName : " + nickName);
  console.log("phone : " + phone);
  console.log("email : " + email);
  console.log("useCheck : " + useCheck);
  
  fetch("/member/srchMember?nickName=${nickName}&phone=${phone}&email=${email}&useCheck=${useCheck}")
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
      for (var rst of result) {
        var tr = document.createElement("tr");
        tr.innerHTML = `<td>${rst.total}</td>
        <td>${rst.creator}</a></td>
        <td>${rst.user}</td>`;
        document.querySelector("#tbody1").appendChild(tr);
      }
    });
  
});