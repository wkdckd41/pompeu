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
	  li1.innerHTML = "평평하고 넓은 공간이 있다면 어디서든지 탈 수 있어요"
	  detail.appendChild(li1);
	  var li2 = document.createElement("li");
	  li2.innerHTML = "롱보드, 스케이트보드, 크루저보드 등 여러 형태로 즐길 수 있어요"
	  detail.appendChild(li2);
	  var li3 = document.createElement("li");
	  li3.innerHTML = "숙달되면 여러 트릭들을 구사할 수 있어요"
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
    li1.innerHTML = "험지나 산악을 마이웨이로 돌파하며 쾌감을 느낄 수 있어요"
    detail.appendChild(li1);
    var li2 = document.createElement("li");
    li2.innerHTML = "다른 자전거취미보다 장비가 상당히 고가에요"
    detail.appendChild(li2);
    var li3 = document.createElement("li");
    li3.innerHTML = "보통 위험성이 높은 곳을 주행하므로 안전장비 착용은 필수에요"
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
    li1.innerHTML = "바다뿐만 아니라 파도가 있는 곳이라면 호수나 강, 인공풀에서도 즐길수 있어요"
    detail.appendChild(li1);
    var li2 = document.createElement("li");
    li2.innerHTML = "서핑수트가 있다면 봄 ~ 늦가을까지 즐길 수 있어요"
    detail.appendChild(li2);
    var li3 = document.createElement("li");
    li3.innerHTML = "심각한 사고는 잘 일어나지 않지만 작은 부상방지를 위해 안전수칙을 꼭 지켜야해요"
    detail.appendChild(li3);
    
  }
  
    btnGo.onclick = function() {  
    
    window.location.href = "/user/lecture/lecture-home.html";
    
  }
	
