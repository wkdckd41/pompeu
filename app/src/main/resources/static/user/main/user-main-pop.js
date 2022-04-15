    var popImg = [6];
    var popEx = [6];
    var popName = [6];
    var popPrice = [6];
    var popLikey = [6];
    var popThumb = [6];
    
    var userNo = 1;
    
    popImg[0] = document.getElementById("pop-img-0");
    popEx[0] = document.getElementById("pop-ex-0");
    popName[0] = document.getElementById("pop-name-0");
    popPrice[0] = document.getElementById("pop-price-0");
    popLikey[0] = document.getElementById("pop-likey-0");
    popThumb[0] = document.getElementById("pop-thumb-0");
                                                           
    popImg[1] = document.getElementById("pop-img-1");
    popEx[1] = document.getElementById("pop-ex-1");
    popName[1] = document.getElementById("pop-name-1");
    popPrice[1] = document.getElementById("pop-price-1");
    popLikey[1] = document.getElementById("pop-likey-1");
    popThumb[1] = document.getElementById("pop-thumb-1");
                                                           
    popImg[2] = document.getElementById("pop-img-2");
    popEx[2] = document.getElementById("pop-ex-2");
    popName[2] = document.getElementById("pop-name-2");
    popPrice[2] = document.getElementById("pop-price-2");
    popLikey[2] = document.getElementById("pop-likey-2");
    popThumb[2] = document.getElementById("pop-thumb-2");
                                                           
    popImg[3] = document.getElementById("pop-img-3");
    popEx[3] = document.getElementById("pop-ex-3");
    popName[3] = document.getElementById("pop-name-3");
    popPrice[3] = document.getElementById("pop-price-3");
    popLikey[3] = document.getElementById("pop-likey-3");
    popThumb[3] = document.getElementById("pop-thumb-3");
                                                           
    popImg[4] = document.getElementById("pop-img-4");
    popEx[4] = document.getElementById("pop-ex-4");
    popName[4] = document.getElementById("pop-name-4");
    popPrice[4] = document.getElementById("pop-price-4");
    popLikey[4] = document.getElementById("pop-likey-4");
    popThumb[4] = document.getElementById("pop-thumb-4");
                                                           
    popImg[5] = document.getElementById("pop-img-5");
    popEx[5] = document.getElementById("pop-ex-5");
    popName[5] = document.getElementById("pop-name-5");
    popPrice[5] = document.getElementById("pop-price-5");
    popLikey[5] = document.getElementById("pop-likey-5");
    popThumb[5] = document.getElementById("pop-thumb-5");

    fetch(`/userMain/topLecture?no=${userNo}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      console.log(result);
        
        for(i=0; i < 6; i++) {
        	
          if (result[i].image == null) {
          	result[i].image = "default.jpg";
          }
          
          popImg[i].innerHTML = `<img src="/userMain/image?filename=${result[i].image}" width="350px" height="210px">`;
      	  popEx[i].innerHTML = result[i].exName;
      	  popName[i].innerHTML = result[i].lName;
      	  popPrice[i].innerHTML = result[i].price + "원";
      	  popLikey[i].innerHTML = result[i].likey;
      	  popName[i].dataset.value = result[i].lNo;
          console.log(popThumb[i]);
          
	   	     if (result[i].liked == 0) {
 	   		    popThumb[i].style.color = "black";
 	   	     } else {
 	   		    popThumb[i].style.color = "red";
 	   	     }
	   	     
        };
      });