"use strict"

var titleInput = $("#x-title-input");
titleInput.css("display", "none");

var tbody = $("#x-ask-table tbody");

$("#x-ask-input").keyup(function(e) {

  if (e.keyCode == 27) {
    $(e.target).val("");

  } else if (e.keyCode == 13) {
    if ($(e.target).val() == "") {
      //window.alert("필수 입력 항목이 비어 있습니다.");
      Swal.fire("필수 입력 항목이 비어 있습니다.");
      return;
    }

    fetch(`/ask/add?title=${e.target.value}`)
      .then(function(response) {
        return response.text();
      })
      .then(function(text) {
        console.log(text);
        location.reload();
      });
  }
});

fetch("/ask/list")
  .then(function(response) {
    return response.json();
  })
  .then(function(askList) {
    console.log(askList);
    for (var ask of askList) {
      var checkedOption = "";
      var titleTdOption = "";
      if (ask.done) {
        checkedOption = "checked";
        titleTdOption = "lecture='ask-checked'";
      }
      $("<tr>").attr("data-no", ask.no)
               .html(`<td><input type="checkbox" ${checkedOption} onchange="checkTodo(${ask.no}, event.target.checked)"></td>
                      <td class="ask-title"><span ${titleTdOption}>${ask.title}</span></td>
                      <td><button type="button" class="btn btn-primary btn-sm" onclick="updateTodo(${ask.no})">변경</button></td>
                      <td><button type="button" class="btn btn-primary btn-sm" onclick="deleteTodo(${ask.no})">삭제</button></td>`)
               .appendTo(tbody);
    }
    $("#x-ask-input").focus();
  });

function deleteTodo(no) {
   fetch(`/ask/delete?no=${no}`)
     .then(function(response) {
       return response.json();
     })
     .then(function(result) {
       if (result == 0) {
         window.alert("삭제하지 못했습니다!");
       } else {
         location.reload();
       }
     });
 }

function checkTodo(no, checked) {
   console.log(no, checked);
   fetch(`/ask/check?no=${no}&done=${checked}`)
     .then(function(response) {
       return response.json();
     })
     .then(function(result) {
       if (result == 0) {
         window.alert("변경하지 못했습니다!");
       } else {
         var titleSpan = $(`tr[data-no="${no}"] > td.ask-title > span`);
         if (checked) {
           titleSpan.addClass("ask-checked");
         } else {
           titleSpan.removeClass("ask-checked")
         }
       }
     });
}

function updateTodo(no) {
   // 현재 Todo 항목을 편집 중인 상태에서 변경 버튼을 눌렀다면
   if (titleInput.parent()[0] instanceof HTMLTableCellElement) {
     // 다른 항목을 편집하기 위해 이동하기 전에 편집 전의 상태로 되돌린다.
     titleInput.parent().find("span").css("display", "");
   }
   var titleTd = $(`tr[data-no="${no}"] > td.ask-title`);
   var titleSpan = titleTd.find("span");
   titleSpan.css( "display", "none" );
   titleInput.val( titleSpan.html() );
   titleInput.attr("data-no", no);
   titleTd.append(titleInput);
   titleInput.css("display", "");
}

titleInput.keyup(function(e) {
   var no = titleInput.attr("data-no");
   var titleSpan = titleInput.parent().find("span");
   var originTitle = titleSpan.html();

   if (e.keyCode == 27) { // ESC 키를 눌러 편집을 취소한다면
     cancelTodoEditing();
   } else if (e.keyCode == 13 && titleInput.value != "" && originTitle != titleInput.value) {
     fetch(`/ask/update?no=${no}&title=${titleInput.val()}`)
       .then(function(response) {
         return response.json();
       })
       .then(function(result) {
         if (result == 0) {
           window.alert("변경하지 못했습니다!");
         } else {
           console.log("변경했습니다.");
           titleSpan.html( titleInput.val() );
           cancelTodoEditing();
         }
       });
   }
 });

function cancelTodoEditing() {
   titleInput.parent().find("span").css("display", "");
   titleInput.css("display", "none");
   $(document.body).append(titleInput);
}