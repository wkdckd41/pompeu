
function moveList() {
  location.href = 'party-home.html'
}

var xTitle = document.querySelector("input[name=title]");
var xStartDate = document.querySelector("input[name=startDate]");
var xEndDate = document.querySelector("input[name=endDate]");
var xContent = document.querySelector("textarea");

document.querySelector("#x-add-btn").onclick = function() {
   if(xTitle.value == "" || 
      xStartDate.value == "" || 
      xEndDate.value == "" || 
      xContent.value == "") {
    window.alert("필수 입력 항목이 비어있습니다.");
    return;
  
  }
  
    var fd = new FormData(document.forms.namedItem("frm"));
    
    fetch("/userparty/add", { 
        method: "POST",
        body: new URLSearchParams(fd)
      }) 
      .then(function(response) {
        return response.json();
      })
      .then(function(result) {
        console.log(result);
      });
  };
  
  