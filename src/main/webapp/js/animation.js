let notiContainer = document.getElementById("noti-container");
let cellViewButton = document.getElementById("CellViewButton");
let listViewButton = document.getElementById("ListViewButton");
let viewCSS = document.getElementById("viewMode");
let accountOverlayButton = document.getElementById("AccountOverlayButton");
let accountOverlay = document.getElementById("AccountOverlay");

function hideNoti() {
    notiContainer.style.animation = "fadeOut 1s ease";
    setTimeout(() => {
        notiContainer.style.opacity = "0";
        notiContainer.style.visibility = "hidden";
    }, 1000);
}

function preventSubmit(event) {
    event.preventDefault();
}

function showNoti(event) {
    preventSubmit(event);

    notiContainer.style.visibility = "visible";
    notiContainer.style.animation = "fadeIn 0.5s ease";
    setTimeout(() => {
        notiContainer.style.opacity = "1";
    }, 400);
}

function displayCellView() {
    viewCSS.href = "../../css/searchProductCellView.css";
}

function displayListView() {
    viewCSS.href = "../../css/searchProductListView.css";
}

function displayAccountOverlay() {
    accountOverlay.style.opacity = "1";
    accountOverlay.style.visibility = "visible";
    accountOverlay.style.display = "flex";
}

function inDisplayAccountOverlay() {
    accountOverlay.style.opacity = "0";
    // accountOverlay.style.visibility = "hidden";
    accountOverlay.style.display = "none";
}

function inDisplayAccountOverlay2() {
    accountOverlay.style.opacity = "0";
    accountOverlay.style.visibility = "hidden";
    // accountOverlay.style.display = "none";
}

function displayOrangeAccountButton() {
    accountOverlayButton.style.color = "#f25c05";
}

function inDisplayOrangeAccountButton() {
    accountOverlayButton.style.color = "#9d9d9d";
}


document.getElementById("hide-noti").addEventListener("click", hideNoti);
accountOverlayButton.addEventListener("mouseover", displayAccountOverlay);
accountOverlayButton.addEventListener("mouseout", inDisplayAccountOverlay2);
accountOverlay.addEventListener("mouseover", displayAccountOverlay, displayOrangeAccountButton);
accountOverlay.addEventListener("mouseout", inDisplayAccountOverlay, inDisplayOrangeAccountButton);

cellViewButton.addEventListener("click", displayCellView);
listViewButton.addEventListener("click", displayListView);