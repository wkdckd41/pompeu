	var btn1 = document.querySelector("#test-answer-1");
	var btn2 = document.querySelector("#test-answer-2");
	
	var count = 1;
	
	var process = document.querySelector("#test-process");
	var question = document.querySelector("#test-question");
	
	var inOut = 0;
	var poorRich = 0;
	var safeRisk = 0;
	var aloneTeam = 0;
	
	btn1.onclick = function() {  
		
			switch (count) {
  			case 1:
    		btn1.innerHTML = "2-1 대답입니다.";
    		btn2.innerHTML = "2-2 대답입니다.";
				process.innerHTML = "2/4";
				question.innerHTML = "2번 질문입니다.";
				inOut++;
				count++;
   			break;
  			case 2:
    		btn1.innerHTML = "3-1 대답입니다.";
    		btn2.innerHTML = "3-2 대답입니다.";
				process.innerHTML = "3/4";
				question.innerHTML = "3번 질문입니다.";
				poorRich++;
				count++;
   			break;
  			case 3:
    		btn1.innerHTML = "4-1 대답입니다.";
    		btn2.innerHTML = "4-2 대답입니다.";
				process.innerHTML = "4/4";
				question.innerHTML = "4번 질문입니다.";
				safeRisk++;
				count++;
   			break;
  			case 4:
    		console.log("끝나쪙1");
    		console.log(inOut);
    		console.log(poorRich);
    		console.log(safeRisk);
    		console.log(aloneTeam);
    		window.location.href = "/user/extest/test-result.html";
   			break;
  			default:
	      console.log("호에에엥1");
    		break;
		}
	}
	
		btn2.onclick = function() {  
		
			switch (count) {
  			case 1:
    		btn1.innerHTML = "2-1 대답입니다.";
    		btn2.innerHTML = "2-2 대답입니다.";
				process.innerHTML = "2/4";
				question.innerHTML = "2번 질문입니다.";
				inOut--;
				count++;
   			break;
  			case 2:
    		btn1.innerHTML = "3-1 대답입니다.";
    		btn2.innerHTML = "3-2 대답입니다.";
				process.innerHTML = "3/4";
				question.innerHTML = "3번 질문입니다.";
				poorRich--;
				count++;
   			break;
  			case 3:
    		btn1.innerHTML = "4-1 대답입니다.";
    		btn2.innerHTML = "4-2 대답입니다.";
				process.innerHTML = "4/4";
				question.innerHTML = "4번 질문입니다.";
				safeRisk--;
				count++;
   			break;
  			case 4:
    		console.log("끝나쪙2");
    		console.log(inOut);
    		console.log(poorRich);
    		console.log(safeRisk);
    		console.log(aloneTeam);
    		window.location.href = "/user/extest/test-result.html";
   			break;
  			default:
	      console.log("호에에엥2");
    		break;
		}
	}