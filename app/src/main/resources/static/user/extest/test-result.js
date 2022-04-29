	var btn1 = document.querySelector("#test-select-btn-1");
	var btn2 = document.querySelector("#test-select-btn-2");
	var btn3 = document.querySelector("#test-select-btn-3");
	
	var btnGo = document.querySelector("#test-gogo");
		
	var title = document.querySelector("#test-result-title");
	var img = document.querySelector("#test-result-img");
	var detail = document.querySelector("#test-result-detail");
		
	btn1.onclick = function() {  
		
		title.innerHTML = "스케이트보드";
		
		img.src = "/user/extest/image/boardriding.jpg";
		
		while (detail.hasChildNodes())
		{
		detail.removeChild(detail.firstChild);      
    }
	  var li1 = document.createElement("li");
	  li1.innerHTML = "대충 스케이트보드 첫번째 내용"
	  detail.appendChild(li1);
	  var li2 = document.createElement("li");
	  li2.innerHTML = "대충 스케이트보드 두번째 내용"
	  detail.appendChild(li2);
	  var li3 = document.createElement("li");
	  li3.innerHTML = "대충 스케이트보드 세번째 내용"
	  detail.appendChild(li3);
		
	}
	
	 btn2.onclick = function() {  
    
    title.innerHTML = "산악자전거";
    
    img.src = "/user/extest/image/mtb.jpg";
    
    while (detail.hasChildNodes())
    {
    detail.removeChild(detail.firstChild);      
    }
    
    var li1 = document.createElement("li");
    li1.innerHTML = "대충 산악자전거 첫번째 내용"
    detail.appendChild(li1);
    var li2 = document.createElement("li");
    li2.innerHTML = "대충 산악자전거 두번째 내용"
    detail.appendChild(li2);
    var li3 = document.createElement("li");
    li3.innerHTML = "대충 산악자전거 세번째 내용"
    detail.appendChild(li3);
    
  }
  
    btn3.onclick = function() {  
    
    title.innerHTML = "서핑";
    
    img.src = "/user/extest/image/surfing.jpg";
    
    while (detail.hasChildNodes())
    {
    detail.removeChild(detail.firstChild);      
    }
    
    var li1 = document.createElement("li");
    li1.innerHTML = "대충 서핑 첫번째 내용"
    detail.appendChild(li1);
    var li2 = document.createElement("li");
    li2.innerHTML = "대충 서핑 두번째 내용"
    detail.appendChild(li2);
    var li3 = document.createElement("li");
    li3.innerHTML = "대충 서핑 세번째 내용"
    detail.appendChild(li3);
    
  }
  
    btnGo.onclick = function() {  
    
    window.location.href = "/user/lecture/lecture-home.html";
    
  }
	
