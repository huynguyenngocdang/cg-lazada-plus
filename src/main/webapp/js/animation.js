let notiContainer = document.getElementById("noti-container");
let cellViewButton = document.getElementById("CellViewButton");
let listViewButton = document.getElementById("ListViewButton");
let viewCSS = document.getElementById("viewMode");

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


document.getElementById("hide-noti").addEventListener("click", hideNoti);
cellViewButton.addEventListener("click", displayCellView);
listViewButton.addEventListener("click", displayListView);
