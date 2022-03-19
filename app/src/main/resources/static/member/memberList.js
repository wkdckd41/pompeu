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
  var phone = document.querySelector("#phone").value;
  var email = document.querySelector("#email").value;
  var memberTypeNo = document.querySelector("#member_type_no").value;
  
  

  
  console.log("nickName : " + nickName);
  console.log("phone : " + phone);
  console.log("email : " + email);
  console.log("memberTypeNo : " + memberTypeNo);
  
  if( memberTypeNo == "" || memberTypeNo == null || memberTypeNo == undefined || ( memberTypeNo != null && typeof memberTypeNo == "object" && !Object.keys(memberTypeNo).length ) ){ 
    memberTypeNo = null; 
  }

  
  fetch(`/member/srchMember?nickName=${nickName}&phone=${phone}&email=${email}&memberTypeNo=${memberTypeNo}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
      var count = 0;
      
      for (var rst of result) {
        count = count + 1;
        
        
      }
    });
  
});