  var btn = document.getElementById("search");

btn.addEventListener('click', function() {
  
  var partyNo = document.querySelector("#party_no").value;
  var partyName = document.querySelector("#party_name").value;
  var name = document.querySelector("#name").value;
  var registerDate = document.querySelector("#register_date").value;
  var status = document.querySelector("#status").value;

  console.log("no. : " + partyNo);
  console.log("제목 : " + partyName);
  console.log("작성자 : " + name);
  console.log("등록일 : " + registerDate);
  console.log("신고여부 : " + status);
  
  
  var tbody2 = document.querySelector("#tbody2");


    while (tbody2.hasChildNodes()) {
        tbody2.removeChild(tbody2.firstChild);
    }
  
  
  fetch(`/party/list`)
  /*fetch(`/member/srchMember`)*/
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      for (var rst of result) {
      console.log(rst);

        var tr = document.createElement("tr");
        tr.innerHTML = `
        <td>${rst.party_no}</td> 
        <td>${rst.name}</td>
        <td>${rst.member_name}</td>
        <td>${rst.register_date}</td>
        <td>${rst.status}</td>`;
        tbody2.appendChild(tr);
        
      }
    });
    
});


         /* rst.memberType.memberType */

function hihi() {
  
  //document.querySelector("#name").value = '';
  //document.querySelector("#phone").value = '';
  //document.querySelector("#email").value = '';
  //document.querySelector("#member_type_no").value = 0;
location.reload();
  
}