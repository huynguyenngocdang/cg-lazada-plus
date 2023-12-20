let passwordBox = document.getElementById("password");
let passwordConfirmBox = document.getElementById("passwordConfirm");
let passwordNoti = document.getElementById("passwordNoti");
let form = document.getElementById("signInForm");
let submitButton = document.getElementById("submitButton");



//
function checkConfirmPassword() {
    while (document.getElementById("passwordConfirm").value !== document.getElementById("password").value) {
        passwordConfirmBox.style.outline = "solid 1px red";
        passwordConfirmBox.style.boxShadow = "0 0 7px 1px rgba(224, 5, 5, 0.58)";
        passwordNoti.style.display = "block";
        preventSubmit();
    }
    if (document.getElementById("passwordConfirm").value === document.getElementById("password").value) {
        passwordNoti.style.display = "none";
        passwordConfirmBox.style.outline = "solid 1px green";
        passwordConfirmBox.style.boxShadow = "0 0 7px 1px rgba(14, 190,146, 0.58)";
    }
}

function preventSubmit() {
    event.preventDefault();
}

passwordConfirmBox.addEventListener("input", checkConfirmPassword);
passwordBox.addEventListener("input", checkConfirmPassword);