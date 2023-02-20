let count   = 0,
index   = 0,
cri     = new Audio('/assets/404/cri.ogg'),
body    = document.body,
easter  = document.getElementById("easter"),
bestpkm = document.getElementById("bestPokemonEver"),
timer;

const   BACKGROUND_COLORS  = ["#FF0000", "#FF7F00", "#FFFF00", "#00FF00", "#0000FF", "#4B0082", "#9400D3", "#FFC0CB"],
        FOREGROUND_COLORS  = ["#FFFFFF", "#FFFFFF", "#000000", "#000000", "#FFFFFF", "#FFFFFF", "#FFFFFF", "#000000"],
        MAX_COUNT          = 247,
        MIN_WINDOW_WIDTH   = 1024,
        ANIMATION_INTERVAL = 1000;


bestpkm.addEventListener('click', () => {
    if (count < MAX_COUNT) {
        count++;
        console.log(`[EGG] Encore un petit effort, il reste ${(MAX_COUNT + 1) - count} clic(s) !`);
        return;
    }
    cri.play();

    if (window.innerWidth >= MIN_WINDOW_WIDTH) {
        easter.style.display = "block";
        body.style.overflow  = "hidden";

        timer = setInterval(animations, ANIMATION_INTERVAL);
    } else {
        alert('❤ Tyranocif ❤');
    }
});

easter.addEventListener('click', () => {
    easter.style.display = "none";
    body.style.overflow  = "auto";

    clearInterval(timer);
});

function animations() {
    if (window.innerWidth <= MIN_WINDOW_WIDTH) return easter.click();

    let texts = [...document.getElementsByClassName("easter_text")];
    if (texts.length <= 16) {
        let clone       = texts[0].cloneNode();
        clone.innerText = texts[0].textContent;
        easter.appendChild(clone);
    }

    texts.forEach(text => {
        text.style.color = FOREGROUND_COLORS[index];
        text.style.left  = Math.floor(Math.random() * window.innerWidth)  + "px";
        text.style.top   = Math.floor(Math.random() * window.innerHeight) + "px";
    });

    easter.style.background = BACKGROUND_COLORS[index];

    cri.play();

    index++;
    if (index > BACKGROUND_COLORS.length) index = 0;
}