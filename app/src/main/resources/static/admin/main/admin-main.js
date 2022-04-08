
var memT = document.getElementById("member-total");
var memC = document.getElementById("member-creator");
var memR = document.getElementById("member-rookie");


   fetch("/adminMain/memberStatus")
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {

				memT.innerHTML = result.ammTotal + "명";
				memC.innerHTML = result.ammCreator + "명";
				memR.innerHTML = result.ammRookie + "명";

    });

var lecT = document.getElementById("lecture-total");
var lecI = document.getElementById("lecture-ing");
var lecS = document.getElementById("lecture-stnby");


   fetch("/adminMain/lectureStatus")
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {

				lecT.innerHTML = result.amlTotal + "개";
				lecI.innerHTML = result.amlIng + "개";
				lecS.innerHTML = result.amlStnby + "개";

    });

var undoA = document.getElementById("undo-apply");
var undoC = document.getElementById("undo-claim");

   fetch("/adminMain/undoStatus")
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
			console.log(result);

				undoA.innerHTML = result[0].amuApply + "개";
				undoC.innerHTML = result[1].amuClaim + "개";

    });



/*
  var btn = document.getElementById("srchBtn");

btn.addEventListener('click', function() {
  
  var name = document.querySelector("#name").value;
  var phone = document.querySelector("#phone").value;
  var email = document.querySelector("#email").value;
  var memberTypeNo = document.querySelector("#member_type_no").value;
  var memberType = document.getElementById("member_type_no");
  mT = memberType.options[memberType.selectedIndex].text;

  console.log("name : " + name);
  console.log("phone : " + phone);
  console.log("email : " + email);
  console.log("memberTypeNo : " + memberTypeNo);
  console.log(mT);
  
  
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

				var mt = rst.memberType.memberType;
				console.log(mt)
				var url;
				
				switch (mt) {
  			case "이용자":
    		url = "member_user.html?no=";
   			break;
  			case "크리에이터":
    		url = "member_creator.html?no=";
   			break;
  			default:
    		url = "값이 없쪙";
}

        var tr = document.createElement("tr");
        tr.innerHTML = `<td>`+count+`</td>
        <td>${rst.memberType.memberType}</td> 
        <td><a href=${url}${rst.no}>${rst.name}</a></td>
        <td>${rst.email}</td>
        <td>${rst.phone}</td>`;
        tbody2.appendChild(tr);
        
      }
    });
});

function hihi() {
  
  //document.querySelector("#name").value = '';
  //document.querySelector("#phone").value = '';
  //document.querySelector("#email").value = '';
  //document.querySelector("#member_type_no").value = 0;
location.reload();
  
}
*/