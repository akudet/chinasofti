// monitor is sth can show one image at a time
// it take a div as the place to display image
// it support change to another image by a method show
var Monitor = function(div_id) {
  this.show = function(imgSrc) {
    var monitor = $(div_id);
    var mask = $("<div></div>").appendTo(monitor);
    monitor.addClass("monitor")
      .css("background-image", "url(" + imgSrc + ")");
    mask.addClass("mask");
    mask.slideUp(1000);
  };
};
