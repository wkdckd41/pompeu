

  var memberTypeNo = document.querySelector("#member_type_no");
  var name = document.querySelector("#name");
  var nickname = document.querySelector("#nickName");
  var email = document.querySelector("#email");
  var phone = document.querySelector("#phone");
  var joinDate = document.querySelector("#join_date");
  var loginDate = document.querySelector("#login_date");

  fetch(`/member/get?no=${no}`)
    .then(function(response) {
      return response.json();
    })
      .then(function(member) {
      // 4) 연락처 상세 정보를 화면에 출력한다.
      member.value = member.memberTypeNo;
      name.value = member.name;
      nickname.value = member.nickName;
      email.value = member.email;
      xPrice.value = member.phone;
      xReadDate.value = member.joinDate;
      xFeed.value = member.loginDate;
    });
    
    
    
    
    

    











































  var btn = document.getElementById("srchBtn");

btn.addEventListener('click', function() {
  
  var name = document.querySelector("#name").value;
  var phone = document.querySelector("#phone").value;
  var email = document.querySelector("#email").value;
  var memberTypeNo = document.querySelector("#member_type_no").value;

  console.log("name : " + name);
  console.log("phone : " + phone);
  console.log("email : " + email);
  console.log("memberTypeNo : " + memberTypeNo);
  
  var tbody2 = document.querySelector("#tbody2");


    while (tbody2.hasChildNodes()) {
        tbody2.removeChild(tbody2.firstChild);
    }
  
  fetch(`/member/srchMember?memberTypeNo=${memberTypeNo}&name=${name}&phone=${phone}&email=${email}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      var count = 0;
      
      for (var rst of result) {
        count = count + 1;

        var tr = document.createElement("tr");
        tr.innerHTML = `<td>`+count+`</td>
        <td>${rst.member_type_no_name}</a></td>
        <td>${rst.name}</td>
        <td>${rst.email}</td>
        <td>${rst.phone}</td>`;
        tbody2.appendChild(tr);
        
      }
    });
});

function hihi() {
  
  document.querySelector("#name").value = '';
  document.querySelector("#phone").value = '';
  document.querySelector("#email").value = '';
  document.querySelector("#member_type_no").value = 0;
  
}