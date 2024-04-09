document.getElementById('searchForm').addEventListener('submit', function(event) {
    var searchQuery = document.getElementById('searchInput').value;
    var searchURL = 'https://www.google.com/search?q=' + encodeURIComponent(searchQuery);

    window.location.href = searchURL;

    event.preventDefault();
});

$(document).ready(function(){
  $(window).on('scroll', function() {
    var scrollPos = $(document).scrollTop();
    $('a.nav-link').each(function () {
      var currLink = $(this);
      var refElement = $(currLink.attr("href"));
      if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
        $('a.nav-link').removeClass("active");
        currLink.addClass("active");
      }
      else{
        currLink.removeClass("active");
      }
    });
  });
});

$(document).ready(function(){
  $("#openWorkspace").click(function() {
    var urls = ['https://youtube.com', 'https://github.com', 'https://chat.openai.com/', 'https://classroom.google.com/'];
    var delay = 100;
    $.each(urls, function(index, url){
      setTimeout(function() {
        window.open(url, "_blank");
      }, index * delay);
    });
  });
});