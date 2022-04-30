$(document).ready(function () {  
  
   
  
  /*    var arr = location.href.split("?");
    console.log(arr);

    var qs = arr[1];
    console.log("qs : " + qs);

    // 2) 쿼리 스트링에서 no 값을 추출한다.
    var params = new URLSearchParams(qs);
    var no = params.get("no");
    console.log("faqNo : " + no);
    로그인시에 멤버타입입 넘버를 받기 위한 세팅 */ 
      
      
      
      selectFaqList(1); //파라미터로 받은값을 넣어준다
  
      init();
});

function selectFaqList(no) {
   // while (tbody1.hasChildNodes()) {
   //     tbody1.removeChild(tbody1.firstChild);
  //  }
    console.log("memberTypeNo : " + no);

    var param = new URLSearchParams();

    param.set('memberTypeNo', no);

    fetch("/faq/list", {
        method: "POST",
        body: param
    }).then(function (response) {
        return response.json();
    })
    .then(function (result) {
        console.log(result);
        
        var count = 0;
        var acco = document.querySelector("#Accordion_wrap")
        var str = ``;
        for (var rst of result) {
        
        str += 
         `<div class="que">&nbsp&nbsp<span>${rst.ask}</span></div>`+ 
         `<div class="anw">&nbsp&nbsp<span>${rst.answer}</span></div>`
         }
         acco.innerHTML = str;
        
        $(".que").on({"click": function(){
          $(this).next(".anw").stop().slideToggle(300);
          $(this).toggleClass('on').siblings().removeClass('on');
          $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
        } });
  /*      
    var count = 0;
        for (var rst of result) {
            var tr = document.createElement("tr");
            tr.innerHTML = `<td><input type="checkbox" id = "chk_` + count
                + `" name="_selected_" value="ROW_` + count + `"></td>
          <td style="display:none"><input type="text" id= "no_` + count
                + `" value="${rst.no}""></td>
          <td>${rst.no}</td>
          <td>${rst.memberType}</td>
          <td onclick="moveView(${rst.no});">${rst.ask}</td>
          <td>${rst.registerDate}</td>`;
            document.querySelector("#tbody1").appendChild(tr);
            count++;
        }
          */
    });

}
function init() {
/*
$(".que").click(function () {
    $(this).next(".anw").stop().slideToggle(300);
    $(this).toggleClass('on').siblings().removeClass('on');
    $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
});  
*/

  $(".que").on({"click": function(){
    $(this).next(".anw").stop().slideToggle(300);
    $(this).toggleClass('on').siblings().removeClass('on');
    $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
  } });

  
  
  
  
  
  
  
  
  

}