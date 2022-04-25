const xName = document.querySelector('input[name=name]');
const xNickName = document.querySelector('input[name=nickName]');
const xJoinEmail = document.querySelector('input[name=email]');
const xJoinPassword = document.querySelector('input[name=password]');
const xJoinPhone = document.querySelector('input[name=phone]');


const data = () => {
    name: xName.value,
    nickn
};




// let index = {
//     init: function () {
//         xBtn.addEventListener('click', (e) => {
//             this.save();
//         });
//     },
//     save: function () {
//         name: xName.value,
//         nickName: xNickName.value,
//         email: xJoinEmail.value,
//         password: xJoinPassword.value,
//         phone: xJoinPhone.value
//     }
// };
// index.init;






const xBtn = document.querySelector('.btn_submit');


xBtn.addEventListener('click', (e) => {
    e.preventDefault();



    fetch('http://localhost:8080/user/join', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: xName.value,
                nickName: xNickName.value,
                email: xJoinEmail.value,
                password: xJoinPassword.value,
                phone: xJoinPhone.value
            })
        })
        .then((response) => {
            console.log(response);
            return response.text();
        })
        .then((text) => {
            console.log(text);
        })
})