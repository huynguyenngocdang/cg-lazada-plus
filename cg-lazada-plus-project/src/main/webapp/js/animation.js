let notiContainer = document.getElementById("noti-container");

function hideNoti() {
  notiContainer.style.animation = "fadeOut 1s ease";
  setTimeout(() => {
    notiContainer.style.opacity = "0";
    notiContainer.style.visibility = "hidden";
  }, 1000);
}

function showNoti(event) {
  event.preventDefault();

  notiContainer.style.visibility = "visible";
  notiContainer.style.animation = "fadeIn 0.5s ease";
  setTimeout(() => {
    notiContainer.style.opacity = "1";
  }, 400);
}

function cartUpdate() {

}


document.getElementById("hide-noti").addEventListener("click", hideNoti);

