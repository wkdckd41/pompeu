var userNo=23;

var uImg = document.querySelector("#user-img-actual");
var uName = document.querySelector("#user-name");
var uEmail = document.querySelector("#user-email");

fetch(`/userChange/getUser?no=${userNo}`)
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
	console.log(result);
      uName.innerHTML = result.name;
      uEmail.innerHTML = result.email;
      
      if (result.image != null) {
    	  uImg.src = "/userChange/image?filename=" + result.image;
      } else if (result.image == null){
				uImg.src = "/userChange/image?filename=default.jpg";
			}

  });
