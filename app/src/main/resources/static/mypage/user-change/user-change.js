  var cThumbNail = document.querySelector("#thumbnail");
  var cName = document.querySelector("input[name=name]");
  var cNickName = document.querySelector("input[name=nickName]");
  var cEmail = document.querySelector("input[name=email]");
  var cPassword = document.querySelector("input[name=password]");
  var cPasswordCheck = document.querySelector("#passwordCheck");
  var cPhone = document.querySelector("input[name=phone]");
  var cBirth = document.querySelector("input[name=birth]");

  var CBtn = document.querySelector("#check-btn");
  var UBtn = document.querySelector("#update-btn");
  var DBtn = document.querySelector("#delete-btn");

	userNo = 35;
	
  fetch(`/userChange/getUser?no=${userNo}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
	console.log(result);
      cName.placeholder = result.name;
      cNickName.placeholder = result.nickName;
      cEmail.placeholder = result.email;
      cPhone.placeholder = result.phone;
      cBirth.placeholder = result.birth;
      
      if (result.image != null) {
    	  cThumbNail.src = "/userChange/image?filename=" + result.image;
      } else if (result.image == null){
				cThumbNail.src = "/userChange/image?filename=default.jpg";
			}
    });

	

  UBtn.onclick = function() {
		var cBirthString = cBirth.value.toString();
		var cBirthDigit = cBirthString.length;
		
	  if (cPassword.value != cPasswordCheck.value ) {
      window.alert("비밀번호와 비밀번호 확인 값이 같지 않습니다.");
      return;
    } else if (cBirthDigit != 0 && cBirthDigit != 6 ) {
      window.alert("생년월일은 6자리로 입력해주세요");
      return;
    }
	  
	  var fd = new FormData(document.forms.namedItem("form1"));
	    
    //if (xReadDate.value == "") { // 독서일을 지정하지 않았으면 서버에 보내지 않는다.
     // fd.delete("readDate");
    //}
    
    // 변경할 독서록 데이터의 PK 값을 FormData에 추가한다.
    fd.append("no", userNo);
    
    fetch("/userChange/updateUser", { 
        method: "POST",
        body: fd
      }) 
      .then(function(response) {
        return response.text();
      })
      .then(function(text) {
        console.log(text);
				window.location.reload();
      });
  };
