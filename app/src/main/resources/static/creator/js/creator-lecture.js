/**
 * 단일파일 업로드
 * 썸네일
 */
function readImage(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = (e) => {
            const previewImage = document.getElementById('previewImage');
            previewImage.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImage').addEventListener('change', (e) => {
    readImage(e.target);
})

/**
 * 단일파일 업로드
 * 이미지1
 */

function readImageSt(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = (e) => {
            const previewImageSt = document.getElementById('previewImageSt');
            previewImageSt.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImageSt').addEventListener('change', (e) => {
    readImageSt(e.target);
})

/**
 * 단일파일 업로드
 * 이미지2
 */

function readImageNd(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = (e) => {
            const previewImageNd = document.getElementById('previewImageNd');
            previewImageNd.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImageNd').addEventListener('change', (e) => {
    readImageNd(e.target);
})


/**
 * 단일파일 업로드
 * 이미지3
 */

function readImageRd(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = (e) => {
            const previewImageRd = document.getElementById('previewImageRd');
            previewImageRd.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImageRd').addEventListener('change', (e) => {
    readImageRd(e.target);
})


/**
 * 단일파일 업로드
 * 이미지4
 */

function readImageTh(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = (e) => {
            const previewImageTh = document.getElementById('previewImageTh');
            previewImageTh.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImageTh').addEventListener('change', (e) => {
    readImageTh(e.target);
})

/**
 * 주소 검색API
 * 
 */

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;

            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}









/**
 * 멀티파일 업로드
 */
// function readMultipleImage(input) {
//     const multipleContainer = document.getElementById('multipleContainer')

//     if (input.files) {
//         console.log(input.files)
//         const fileArr = Array.from(input.files)
//         const $colDiv1 = document.createElement('div')
//         const $colDiv2 = document.createElement('div')
//         $colDiv1.classList.add('column')
//         $colDiv2.classList.add('column')
//         fileArr.forEach((file, index) => {
//             const reader = new FileReader()
//             const $imgDiv = document.createElement('div')
//             const $img = document.createElement('img')
//             $img.classList.add('image')
//             const $label = document.createElement('label')
//             $label.classList.add('image-label')
//             $label.textContent = file.name
//             $imgDiv.appendChild($img)
//             $imgDiv.appendChild($label)
//             reader.onload = e => {
//                 $img.src = e.target.result

//                 //$imgDiv.style.width = ($img.naturalWidth) * 0.2 + "px"
//                 //$imgDiv.style.height = ($img.naturalHeight) * 0.2 + "px"
//             }

//             console.log(file.name)
//             if (index % 2 == 0) {
//                 $colDiv1.appendChild($imgDiv)
//             } else {
//                 $colDiv2.appendChild($imgDiv)
//             }

//             reader.readAsDataURL(file)
//         })
//         multipleContainer.appendChild($colDiv1)
//         multipleContainer.appendChild($colDiv2)
//     }
// }
// // 이벤트 리스너
// document.getElementById('inputMultipleImage').addEventListener('change', (e) => {
//     readMultipleImage(e.target);
// })