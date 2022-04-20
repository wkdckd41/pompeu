var deleteReally = 0;
var deleteReason = 1;
var deleteText= document.querySelector("#user-delete-text");

var DBtn= document.querySelector("#delete-btn");
var CBtn= document.querySelector("#cancel-btn");

var MDBtn= document.querySelector("#modal-delete-btn");
var MCBtn= document.querySelector("#modal-cancel-btn");

	userNo = 35;

function getCheckbox(event)  {
  if(event.target.checked)  {
    deleteReally = 1;
console.log(deleteReally);
  } else {
    deleteReally = 0;
console.log(deleteReally);
  }
}

function getReason(event) {
   deleteReason = event.target.value;
   console.log(deleteReason);
}

console.log(deleteText.innerHTML);
 
  //$(".modal_content").click(function(){
   // $(".modal").fadeOut();
  //});

	DBtn.onclick = function() {  
		if (deleteReally == 0) {
			window.alert("먼저 안내사항을 읽고 체크박스에 체크해주세요");
      return;
		} else {
			$(".modal").fadeIn();
		}
	}
	
	CBtn.onclick = function() {  
	    window.location.href = "user-change.html";
	}
	
	MDBtn.onclick = function() {  
		fetch(`/userChange/deleteUser?no=${userNo}&deleteType=${deleteReason}&deleteDetail=${deleteText.value}`)
      .then(function(response) {
        return response.text();
      })
      .then(function(text) {
        console.log(text);
	    window.location.href = "/user/main/user-main.html";
    });
	}
	
  MCBtn.onclick = function() {  
		$(".modal").fadeOut();
	}
	
	

