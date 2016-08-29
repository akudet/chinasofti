// wicked req : a dropdown menu
// click on a link should show the menu with slide animation
// mouse hover the menu-item should change backgruond

// left menu : 
// click one item, show menu next to the item


// maybe a single dropdown menu is enough, by place it in diff
// position in the document

$(document).ready(function() {
  $(".dropdown-menu").hide();

  //a dropdown toggle is sth when clicked it will cause the
  //dropdown menu to slide up or down depend the menu status
  //dropdwon-toggle need to be sibling of dropdown-menu
  //and their parent need to be positioned
  $(".dropdown-toggle").click(function() {
    dropdownMenu = $(this).next(".dropdown-menu");
    parent = $(this).parent();
    dropdownMenu.css("top", parent.outerHeight());
    dropdownMenu.css("left", "0px");
    dropdownMenu.slideToggle();
  });

});
