document.querySelectorAll(".documentation_menu strong").forEach((menu) => {
    menu.addEventListener("click", () => {
        let element = menu.parentElement.getElementsByTagName("ul")[0];
        element.style.display = ["none", ""].includes(element.style.display) ? "block" : "none";
        menu.classList.toggle("open");
    });

    if (window.location.pathname.toLowerCase() != "/docs") {
        let path = window.location.pathname.split("/");

        if (menu.innerText.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "") == path[2].toLowerCase()) {
            menu.click();
        }
    }
});

document.querySelectorAll(".documentation_menu a").forEach((link) => {
    if(link.href == window.location.href) {
        link.classList.add("selected");
    }
});

var openMenuButton = document.querySelector("#open_documentation_menu button"),
    menuContainer  = document.getElementsByClassName('documentation_menu')[0];

openMenuButton.addEventListener('click', () => {
    menuContainer.style.display = ["none", ""].includes(menuContainer.style.display) ? "block" : "none";
    openMenuButton.innerText = openMenuButton.innerText.toLowerCase().includes("ouvrir") ? "Fermer le menu de navigation" : "Ouvrir le menu de navigation";
});

window.addEventListener('resize', () => {
    const MAX_WIDTH = 968;

    if(window.innerWidth > MAX_WIDTH && menuContainer.style.display != "block") {
        menuContainer.style.display = "block";
    } else if (window.innerWidth <= MAX_WIDTH) {
        menuContainer.style.display = "none";
        openMenuButton.innerText    = "Ouvrir le menu de navigation"
    }
})