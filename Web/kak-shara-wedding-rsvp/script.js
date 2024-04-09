const giftModal = document.getElementById('giftpopup');

const giftBtn = document.querySelector('.gift');

const closeBtn = document.querySelector('.popupClose');

function openGiftModal() {
  giftModal.style.display = 'block';
}

function closeGiftModal() {
  giftModal.style.display = 'none';
}

giftBtn.addEventListener('click', openGiftModal);

closeBtn.addEventListener('click', closeGiftModal);

window.addEventListener('click', function (event) {
  if (event.target === giftModal) {
    closeGiftModal();
  }
});

var form = document.getElementById('sheetdb-form');
form.addEventListener("submit", e => {
    e.preventDefault();
    fetch(form.action, {
        method: "POST",
        body: new FormData(document.getElementById("sheetdb-form")),
    }).then(response => {
        console.log(response);
        return response.json();
    }).then(data => {
        console.log(data);
        window.location.href = "end.html";
    }).catch(error => {
        console.error('Error submitting the form:', error);
        alert('There was an error submitting the form.');
    });
});

document.addEventListener("DOMContentLoaded", function() {
  const envelope = document.querySelector('.envelope');

  setTimeout(() => {
    envelope.classList.add('opened');
  }, 1000);
});

function redirectToURL(url){
  window.open(url, '_blank');
}