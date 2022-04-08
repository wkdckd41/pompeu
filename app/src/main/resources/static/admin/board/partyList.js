$(document).ready(function(){
  console.log("start");
  selectBoardTypeNo("");
});



function selectBoardTypeNo (type) {
    console.log(type);
  $("#searchType").val(type);
  
  var params = { 
   "searchType":  $("#searchType").val()
}; 

var paramData = Object.keys(params) 
            .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k])) 
            .join('&'); 

var url = '/party/list?' + paramData;

  

  
    var tbody1 = document.querySelector("#tbody1");


    while (tbody1.hasChildNodes()) {
        tbody1.removeChild(tbody1.firstChild);
    }
  
  
  //fetch("/party/list")
   fetch(url)
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
        st = "";
    }
    
        var tr = document.createElement("tr");
        tr.innerHTML = `
        <td>${rst.party_no}</td> 
        <td onclick="moveView(${rst.no});">${rst.name}</td>
        <td>${rst.member_name}</td>
        <td>${rst.register_date}</td>
        <td>${st}</td>`;
        tbody1.appendChild(tr);
      }
    });
}

function moveView(no) {
  location.href = 'party-detail.html?no='+no
}