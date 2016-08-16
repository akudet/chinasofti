// wicked req : a dropdown menu
// click on a link should show the menu with slide animation
// mouse hover the menu-item should change backgruond

// left menu : 
// click one item, show menu next to the item


// maybe a single dropdown menu is enough, by place it in diff
// position in the document

$(document).ready(function() {
  $(".dropdown-menu").hide();
  $(".dropdown-toggle").click(function() {
    dropdownMenu = $(this).siblings(".dropdown-menu");
    dropdownMenu.slideToggle();
  });
});
