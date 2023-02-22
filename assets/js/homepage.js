async function loadImage(url, element) {
    return new Promise((resolve, reject) => {
        element.onload  = () => resolve(element);
        element.onerror = reject;
        element.src     = url;
    });
}

async function changeCarouselImage(url, element) {
    element.style.display = "none";
    loader.style.display  = "inline";

    await loadImage(url, element);

    loader.style.display  = "none";
    element.style.display = "inline";
}

async function apiRequest(routes) {
    let response = await fetch(baseUrl + routes);
    return response.redirected ? null : await response.json();
}

async function setShinyLock(shinylock) {
    if(shinylock) {
        shiny.title = "Shiny Lock";
        shiny.style.cursor = "not-allowed";
        shiny.style.filter = "invert(53%) sepia(0%) saturate(0%) hue-rotate(350deg) brightness(95%) contrast(89%)";
    } else {
        shiny.title = "Non chromatique";
        shiny.style.cursor = "pointer";
        shiny.style.filter = "";
    }
}

async function setShiny(number) {
    if(pkmData.sprites.shiny == null) {
        return;
    }

    if(isShiny) {
        shiny.src   = "/assets/carousel/star_FILL0.svg";
        shiny.title = "Non chromatique";
        await changeCarouselImage(pkmData.sprites.regular, image);
    } else {
        try {
            shiny.src = "/assets/carousel/star_FILL1.svg";
            shiny.title = "Chromatique";
            await changeCarouselImage(pkmData.sprites.shiny, image);
        } catch {
            setShinyLock(true);
            isShiny = !isShiny;
            console.log(`Erreur: Impossible d'afficher la forme shiny du Pokémon (${pkmData.name.fr})`);
            return setShiny();
        }
    }
    isShiny = !isShiny;
}

async function setPokemon(number) {
    if(number == 0)
        number = totalPkm;
    if (number > totalPkm)
        number = 1;

    shiny.style.visibility = "hidden";
    shiny.src = "/assets/carousel/star_FILL0.svg";
    isShiny = false;

    await setShinyLock(false);

    types.style.visibility = "hidden";
    pkmName.textContent   = "Chargement...";

    pkmData   = await apiRequest("/pokemon/" + number);
    actualPkm = number;
    if(pkmData == null) {
        document.getElementById("carousel-container").style.display = "none";
        return;
    }

    if(pkmData.sprites.shiny == null) {
        await setShinyLock(true);
    }

    await changeCarouselImage(pkmData.sprites.regular, image);

    pkmName.textContent = pkmData.name.fr;
    shiny.style.visibility  = "visible";

    types.innerHTML = "";
    for(let i = 0; i < pkmData.types.length; i++) {
        types.innerHTML += `<img src="${pkmData.types[i].image}" title="${pkmData.types[i].name}" />`;
    }
    types.style.visibility = "visible";
}

function syntaxHighlight(json) {
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
        let type = 'number';
        if (/^"/.test(match)) {
            if (/:$/.test(match)) {
                type = 'key';
            } else {
                type = 'string';
            }
        } else if (/true|false/.test(match)) {
            type = 'boolean';
        } else if (/null/.test(match)) {
            type = 'null';
        }
        if (/https?:\/\/(?:www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b(?:[-a-zA-Z0-9()@:%_\+.~#?&\/=]*)/g.test(match)) {
            let match_array = match.split('"');
            return `<span class="${type}">"<a href="${match_array[1]}" target="_blank">${match_array[1]}</a>"</span>`;
        }
        return `<span class="${type}">${match}</span>`;
    });
}

async function customApiRequest() {
    let json_area = document.getElementById("tryit__json-area");
    json_area.innerHTML = '<img src="/assets/carousel/loader.svg" />';

    request = await apiRequest(`/${document.getElementById("tryit__input-text").value}`);

    if(request == null) {
        request = {
            "error": 302,
            "message": "Il semblerait que vous vous soyez perdu... Êtes-vous sûr d'être sur la bonne route ?"
        };
    } else {
        lastUrl = `${baseUrl}/${document.getElementById("tryit__input-text").value}`;
    }

    requestJson = JSON.stringify(request, null, 4);
    json_area.innerHTML = syntaxHighlight(requestJson);
}

async function tryApiExample(url) {
    document.getElementById("tryit__input-text").value = url;
    await customApiRequest();
}

async function copyRequestUrl() {
    let input = document.getElementById("tryit__input-text"),
        value = input.value;

    input.value = baseUrl + "/" + value;
    input.select();
    document.execCommand("copy");
    input.value = value;

    alert("L'url a été copiée avec succès.");
}

async function copyJson() {
    let element = document.createElement("textarea");
    element.value = requestJson;
    document.body.appendChild(element);
    element.select();
    document.execCommand("copy");
    document.body.removeChild(element);
        
    alert("Le résultat de la requête a bien été copié.");
}


(async function init() {
    await setPokemon(actualPkm);
    requestJson = JSON.stringify(pkmData, null, 4);
    document.getElementById("tryit__json-area").innerHTML = syntaxHighlight(requestJson);
    document.getElementById("tryit__input-text").value = `pokemon/${pkmData.name.fr.normalize("NFD").replace(/[^a-zA-Z0-9 ]/g, "").toLowerCase()}`;
    lastUrl = `${baseUrl}/${document.getElementById("tryit__input-text").value}`;
})();

document.getElementById("tryit__input-text").addEventListener("keyup", (event) => {
    if(event.keyCode === 13) {
        event.preventDefault();
        document.getElementById("tryit__input-button").click();
    }
});