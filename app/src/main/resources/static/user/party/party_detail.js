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
  
  
  var claimName = document.querySelector("#claim_name");
  var claimDate = document.querySelector("#claim_date");

  
  fetch(`/party/partyClaim?party_no=${partyNo}&party_name=${partyName}&name=${name}&register_date=${registerDate}&status=${status}`)
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

/* 카카오 지도 api */
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
  center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
  level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴