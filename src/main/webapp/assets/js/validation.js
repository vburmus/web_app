const EMAIL_REGEX = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/;
const PASSWORD_REGEX = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
const NAME_REGEX = /^.*[a-zA-zА-Яа-я]{2,45}$/;
const MOBILE_REGEX = /^(\+\d{1,3}[- ]?)?\d{10}$/;
let inputEmail = document.getElementById('email');
let inputPassword = document.getElementById('password');
let inputMobile = document.getElementById('mobile');
let inputName = document.getElementById('name');
let inputSurname = document.getElementById('surname');
let submit = document.getElementById('submit')
function onEmailInput() {
    if (isEmailValid(inputEmail.value)) {
        inputEmail.style.borderColor = 'green';
        if(inputPassword==null) {
            submit.disabled = false;
        }
    } else {
        inputEmail.style.borderColor = 'red';
        submit.disabled =  true;
    }
}
function onPassInput(){
    if (isPasswordValid(inputPassword.value)) {
        inputPassword.style.borderColor = 'green';
        if(isEmailValid(inputEmail.value)){
            submit.disabled =  false;
        }else{
            submit.disabled =  true;
        }
    } else {
        inputPassword.style.borderColor = 'red';
        submit.disabled =  true;
    }
}
function onNameInput() {
    if (isNamedValid(inputName.value)) {
        inputName.style.borderColor = 'green';
        if(isPasswordValid(inputPassword.value) && isSurnameValid(inputSurname.value) && isMobileValid(inputMobile.value) && isEmailValid(inputEmail.value)){
            submit.disabled = false;
        }
    } else {
        inputName.style.borderColor = 'red';
    }
}
function onSurnameInput() {
    if (isSurnameValid(inputSurname.value)) {
        inputSurname.style.borderColor = 'green';
    } else {
        inputSurname.style.borderColor = 'red';
    }
}
function onMobileInput() {
    if (isMobileValid(inputMobile.value)) {
        inputMobile.style.borderColor = 'green';
    } else {
        inputMobile.style.borderColor = 'red';
    }
}

function isEmailValid(value) {
    return EMAIL_REGEX.test(value);
}
function isPasswordValid(value) {
    return PASSWORD_REGEX.test(value);
}
function isNamedValid(value) {
    return NAME_REGEX.test(value);
}
function isMobileValid(value) {
    return MOBILE_REGEX.test(value);
}
function isSurnameValid(value) {
    return NAME_REGEX.test(value);
}
if(inputEmail!=null) {
    inputEmail.addEventListener('input', onEmailInput);
}
if(inputPassword!=null){
inputPassword.addEventListener('input', onPassInput);
}
if(inputName!=null) {
    inputName.addEventListener('input', onNameInput);
}
if(inputMobile!=null){
    inputMobile.addEventListener('input', onMobileInput);
}
if(inputSurname!=null){
    inputSurname.addEventListener('input',onSurnameInput );
}
