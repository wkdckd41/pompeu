$(".headers").load("../admin2.html"); /*사이드바 관련 코드*/

// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    animationLoop: false,
    itemWidth: 100,
    itemMargin: 5,
    minItems: 8,
    maxItems: 8
  });
});
























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
  /*fetch(`/member/srchMember`)*/
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

         /* rst.memberType.memberType */

function hihi() {
  
  //document.querySelector("#name").value = '';
  //document.querySelector("#phone").value = '';
  //document.querySelector("#email").value = '';
  //document.querySelector("#member_type_no").value = 0;
location.reload();
  
}