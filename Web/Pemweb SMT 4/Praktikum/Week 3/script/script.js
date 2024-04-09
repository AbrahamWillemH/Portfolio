// Penambahan dan pengurangan jumlah order
document.addEventListener("DOMContentLoaded", function() {
    var orderButtons = document.querySelectorAll(".btn-order");
    var checkoutButton = document.querySelector(".btn-checkout");
    var orderNumberElements = document.querySelectorAll(".order-number");
    var priceElement = document.querySelector(".price");
    var totalPrice = 0;

    orderButtons.forEach(function (button) {
      button.addEventListener("click", function() {
        var menuItemPrice = parseInt(button.parentElement.textContent.trim().replace("Rp", ""), 10);
        var orderNumberElement = button.parentElement.querySelector(".order-number");
        var orderNumber = parseInt(orderNumberElement.textContent.trim(), 10);

        // Menambahkan atau mengurangi jumlah pesanan
        if (button.textContent === "+") {
          orderNumber++;
          totalPrice += menuItemPrice;
        } else if (button.textContent === "-" && orderNumber > 0) {
          orderNumber--;
          totalPrice -= menuItemPrice;
        }

        orderNumberElement.textContent = orderNumber;
        priceElement.textContent = totalPrice;
      })
    })

    checkoutButton.addEventListener("click", function(){
      totalPrice = 0;
      priceElement.textContent = totalPrice;
      orderNumberElements.forEach(function(element){
        element.textContent = "0";
      })
    })

})

// Auto dissapearing navbar on scroll
document.addEventListener("DOMContentLoaded", function() {

  event_autohide = document.querySelector(".autohide");
  
  if (event_autohide) {
    var last_scroll_top = 0;
    window.addEventListener("scroll", function() {
      let scroll_top = window.scrollY;
      if (scroll_top < last_scroll_top) {
        event_autohide.classList.remove("scrolled-down");
        event_autohide.classList.add("scrolled-up");
      } else {
        event_autohide.classList.add("scrolled-down");
        event_autohide.classList.remove("scrolled-up");
      }
      last_scroll_top = scroll_top;
    })
  }
})

// Popup ketika tombol checkout ditekan
let popup = document.getElementById("checkout-popup");

let blur = document.getElementById("blur");
let home_blur = document.getElementById("home");
let order_blur = document.getElementById("order");
let footer_blur = document.getElementById("about")

function openPopup() {
    popup.classList.add("open-popup");
    blur.classList.toggle("active");
    home_blur.classList.toggle("active");
    order_blur.classList.toggle("active");
    footer_blur.classList.toggle("active");
    
}

function closePopup() {
    popup.classList.remove("open-popup")
    blur.classList.toggle("active");
    home_blur.classList.toggle("active");
    order_blur.classList.toggle("active");
    footer_blur.classList.toggle("active");
}

// ANIMATE ON SCROLL LIBRARY
AOS.init({
  // Settings that can be overridden on per-element basis, by `data-aos-*` attributes:
  offset: 120, // offset (in px) from the original trigger point
  delay: 0, // values from 0 to 3000, with step 50ms
  duration: 700, // values from 0 to 3000, with step 50ms
  easing: 'ease', // default easing for AOS animations
  once: false, // whether animation should happen only once - while scrolling down
  mirror: false, // whether elements should animate out while scrolling past them
  anchorPlacement: 'top-bottom', // defines which position of the element regarding to window should trigger the animation

})