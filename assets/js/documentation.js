var menus = document.querySelectorAll(".documentation_menu strong");

menus.forEach((menu) => {
  menu.addEventListener("click", () => {
    let element = menu.parentElement.getElementsByTagName("ul")[0];
    element.style.display = ["none", ""].includes(element.style.display)
      ? "block"
      : "none";
    menu.classList.toggle("open");
  });

  if (window.location.pathname.toLowerCase() != "/docs") {
    let path = window.location.pathname.split("/")[2].toLowerCase();

    if (
      menu.innerText
        .toLowerCase()
        .normalize("NFD")
        .replace(/[\u0300-\u036f]/g, "") == path
    ) {
      menu.click();
    }
  }
});
