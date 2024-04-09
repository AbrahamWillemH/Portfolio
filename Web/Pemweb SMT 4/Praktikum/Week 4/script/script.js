$(document).ready(function() {
  // Penambahan dan pengurangan jumlah order
  $(".btn-order").click(function() {
    var menuItemPrice = parseInt($(this).parent().text().trim().replace("Rp", ""), 10);
    var orderNumberElement = $(this).parent().find(".order-number");
    var orderNumber = parseInt(orderNumberElement.text().trim(), 10);
    var priceElement = $(".price");
    var totalPrice = parseInt(priceElement.text());

    if ($(this).text() === "+") {
      orderNumber++;
      totalPrice += menuItemPrice;
    } else if ($(this).text() === "-" && orderNumber > 0) {
      orderNumber--;
      totalPrice -= menuItemPrice;
    }

    orderNumberElement.text(orderNumber);
    priceElement.text(totalPrice);
  });

  // Reset jumlah pesanan dan harga pembelian
  $(".btn-checkout").click(function() {
    $(".order-number").text("0");
    $(".price").text("0");
  });

  // Auto dissapearing navbar on scroll
  var event_autohide = $(".autohide");
  if (event_autohide.length) {
    var last_scroll_top = 0;
    $(window).scroll(function() {
      var scroll_top = $(this).scrollTop();
      if (scroll_top < last_scroll_top) {
        event_autohide.removeClass("scrolled-down").addClass("scrolled-up");
      } else {
        event_autohide.addClass("scrolled-down").removeClass("scrolled-up");
      }
      last_scroll_top = scroll_top;
    });
  }

  // Popup ketika tombol checkout ditekan
  var popup = $("#checkout-popup");
  var blur = $("#blur, #home, #order, #about");

  $(".btn-checkout").click(function() {
    popup.addClass("open-popup");
    blur.toggleClass("active");
  });

  $(".close-btn").click(function() {
    popup.removeClass("open-popup");
    blur.toggleClass("active");
  });

});

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