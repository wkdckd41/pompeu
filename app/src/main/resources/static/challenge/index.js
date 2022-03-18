 
  var chRegion = document.querySelector("ch-region");
  var chName = document.querySelector("ch-name");
  var xCompany = document.querySelector("#x-company");
  var xTelDivContainer = document.querySelector("#x-tel-div-container");
  
  document.querySelector("#x-add-btn").onclick = function() {
    var xTelDivList = xTelDivContainer.querySelectorAll(".x-tel-div");
    var firstTel = xTelDivList[0].querySelector("input"); // 첫번째 전화번호
    //var firstTel = document.querySelector(".x-tel-div > input");
    
    if (xName.value == "" || xEmail.value == "" || firstTel.value == "") {
      window.alert("필수 입력 항목이 비어 있습니다.");
      return;
    }
    
    var qs = `name=${xName.value}&email=${xEmail.value}&company=${xCompany.value}`;
    for (var xTelDiv of xTelDivList) {
      var xTelType = xTelDiv.querySelector("select");
      var xTel = xTelDiv.querySelector("input");
      
      qs += `&tel=${xTelType.value}_${xTel.value}`;
    }
    console.log(qs);
    
    fetch(`/contact/add?${qs}`)
      .then(function(response) {
        return response.text();
      })
      .then(function(text) {
        console.log(text);
        location.href = "index.html";
      });
  };

  document.querySelector("#x-cancel-btn").onclick = function() {
    window.location.href = "index.html";
  };
  
  document.querySelector("#x-add-tel-btn").onclick = function() {
    var telDiv = xTelDivContainer.querySelector(".x-tel-div").cloneNode(true);
    telDiv.querySelector("select").value = 1;
    telDiv.querySelector("input").value = "";
    xTelDivContainer.appendChild(telDiv);
  };
  
  function deleteDiv(e) {
    if (xTelDivContainer.childElementCount > 1) {
      xTelDivContainer.removeChild(e.target.parentNode);
    }
  }
