
$(".headers").load("../admin2.html"); /*사이드바 관련 코드*/

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
  
  
  var tbody1 = document.querySelector("#tbody1");


    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
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
        
        var st;
             
        switch (rst.status) {
        case 1:
        st = "O";
        break;
        case undefined:
        st = "X";
        break;
        default:
        st = "값이 없쪙";
    }
    
    
        var tr = document.createElement("tr");
        tr.innerHTML = `
        <td>${rst.party_no}</td> 
        <td>${rst.name}</td>
        <td>${rst.member_name}</td>
        <td>${rst.register_date}</td>
        <td>${st}</td>`;
        tbody1.appendChild(tr);
        
      }
    });



         /* rst.memberType.memberType */

function hihi() {
  
  //document.querySelector("#name").value = '';
  //document.querySelector("#phone").value = '';
  //document.querySelector("#email").value = '';
  //document.querySelector("#member_type_no").value = 0;
location.reload();
  
}