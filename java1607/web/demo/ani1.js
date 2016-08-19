/** animation effect one
 * when mouse hover it will cause the div rotate and show up
 * need jQuery
 */

/** create an ani1 in div */
var ani1 = (function() {
return function(bgSrc, borderColor) {
  var div = $(".ani1");
  div.css("background-image", "url(" + bgSrc + ")");
  div.css("border-color", borderColor);
};
})();
