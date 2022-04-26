    var newImg = [6];
    var newEx = [6];
    var newName = [6];
    var newPrice = [6];
    var newLikey = [6];
    var newThumb = [6];
    var newBox = [6];
    
    var userNo = 1;
    
    newImg[0] = document.getElementById("new-img-0");
    newEx[0] = document.getElementById("new-ex-0");
    newName[0] = document.getElementById("new-name-0");
    newPrice[0] = document.getElementById("new-price-0");
    newLikey[0] = document.getElementById("new-likey-0");
    newThumb[0] = document.getElementById("new-thumb-0");
    newBox[0] = document.getElementById("new-box-0");
                                                           
    newImg[1] = document.getElementById("new-img-1");
    newEx[1] = document.getElementById("new-ex-1");
    newName[1] = document.getElementById("new-name-1");
    newPrice[1] = document.getElementById("new-price-1");
    newLikey[1] = document.getElementById("new-likey-1");
    newThumb[1] = document.getElementById("new-thumb-1");
    newBox[1] = document.getElementById("new-box-1");
                                                           
    newImg[2] = document.getElementById("new-img-2");
    newEx[2] = document.getElementById("new-ex-2");
    newName[2] = document.getElementById("new-name-2");
    newPrice[2] = document.getElementById("new-price-2");
    newLikey[2] = document.getElementById("new-likey-2");
    newThumb[2] = document.getElementById("new-thumb-2");
    newBox[2] = document.getElementById("new-box-2");
                                                           
    newImg[3] = document.getElementById("new-img-3");
    newEx[3] = document.getElementById("new-ex-3");
    newName[3] = document.getElementById("new-name-3");
    newPrice[3] = document.getElementById("new-price-3");
    newLikey[3] = document.getElementById("new-likey-3");
    newThumb[3] = document.getElementById("new-thumb-3");
    newBox[3] = document.getElementById("new-box-3");
                                                           
    newImg[4] = document.getElementById("new-img-4");
    newEx[4] = document.getElementById("new-ex-4");
    newName[4] = document.getElementById("new-name-4");
    newPrice[4] = document.getElementById("new-price-4");
    newLikey[4] = document.getElementById("new-likey-4");
    newThumb[4] = document.getElementById("new-thumb-4");
    newBox[4] = document.getElementById("new-box-4");
                                                           
    newImg[5] = document.getElementById("new-img-5");
    newEx[5] = document.getElementById("new-ex-5");
    newName[5] = document.getElementById("new-name-5");
    newPrice[5] = document.getElementById("new-price-5");
    newLikey[5] = document.getElementById("new-likey-5");
    newThumb[5] = document.getElementById("new-thumb-5");
    newBox[5] = document.getElementById("new-box-5");

    fetch(`/userMain/newLecture?no=${userNo}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
        
        for(i=0; i < 6; i++) {
        	
          if (result[i].image == null) {
          	result[i].image = "default.jpg";
          }
          
          newImg[i].innerHTML = `<img src="/userMain/image?filename=${result[i].image}" width="350px" height="210px">`;
      	  newEx[i].innerHTML = result[i].exName;
      	  newName[i].innerHTML = result[i].lName;
      	  newPrice[i].innerHTML = result[i].price + "원";
      	  newLikey[i].innerHTML = result[i].likey;
      	  newBox[i].dataset.value = result[i].lNo;
          
	   	     if (result[i].liked == 0) {
 	   		    newThumb[i].style.color = "black";
 	   	     } else {
 	   		    newThumb[i].style.color = "red";
 	   	     }
	   	     
        };
      });