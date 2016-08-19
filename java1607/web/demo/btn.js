/** animation effect one
 * when mouse hover it will cause the div rotate 360deg
 */

/** turn an div into div */
var btn = function(div_id, bgSrc, borderColor, imgSrc, monitor) {
  var btn = $(div_id);
  btn.addClass("btn")
    .css("background-image", "url(" + bgSrc + ")")
    .css("border-color", borderColor)
  btn.click(function() {
    monitor.show(imgSrc);
  });
};
