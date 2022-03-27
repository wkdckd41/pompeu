

  var partyNo = document.querySelector("#party_no");
  var name = document.querySelector("#name");
  // var nickname = document.querySelector("#");
  // var email = document.querySelector("#");
  var registerDate = document.querySelector("#register_date");
  var status = document.querySelector("#status");

  fetch(`/party/get?no=${no}`)
    .then(function(response) {
      return response.json();
    })
      .then(function(party) {
      no.value = party.partyNo;
      name.value = party.name;
      // nickname.value = member.nickName;
      // email.value = member.email;
      registerDate.value = party.registerDate;
      status.value = party.status;
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