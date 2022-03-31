
  var partyNo = document.querySelector("#party_no").value;
  var partyName = document.querySelector("#party_name").value;
  var user = document.querySelector("#user").value;
  var registerDate = document.querySelector("#register_date").value;
  var status = document.querySelector("#status").value;

  
  var claimUser = document.querySelector("#claim_user");


    while (tbody2.hasChildNodes()) {
        tbody2.removeChild(tbody2.firstChild);
    }
  
  fetch(`/party/srchParty?party_no=${partyNo}&party_name=${partyName}&=${user}&register_date=${registerDate}&status=${status}`)
  /*fetch(`/member/srchMember`)*/
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log("AAA");
      console.log(result);
      
      for (var rst of result) {

        var mt = rst.memberType.memberType;
        console.log(mt)
      

        var tr = document.createElement("tr");
        tr.innerHTML = `
        <td>${rst.partyNo}</td> 
        <td><a href=${url}${rst.no}>${rst.name}</a></td>
        <td>${rst.registerDate}</td>
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