<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/pokemon/&lt;identifiant&gt;]</span> Fiche d'un Pokémon</h1>

```text
https://tyradex.tech/api/v1/pokemon/<identifiant>/[region]
```

Permet d'obtenir des informations sur un Pokémon spécifique.<br>
[Exemple de donnés renvoyés.](https://tyradex.vercel.app/api/v1/pokemon/248) 

## Paramètres
| Nom | Obligatoire | Type | Description |
|---|---|---|---|
| identifiant | Requis | `Int` ou `String` | Correspond à l'identifiant du Pokémon dans le Pokédex National ou son nom. |
| region | Optionnel | `String` | Correspond à la région du Pokémon. <br>Permet de récupèrer les informations sur une forme régionale d'un Pokémon. |

## Curl
```sh
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://tyradex.tech/api/v1/pokemon/<identifiant>/[region]'
```

## Python
```py
import requests

url = "https://tyradex.tech/api/v1/pokemon/<identifiant>/[region]"
headers = {
    "User-Agent": "RobotPokemon",
    "From": "adresse[at]domaine[dot]com",
    'Content-type': 'application/json'
}

response = requests.get(url, headers=headers)

if response.status_code == 200:
    data = response.json()
    print(data)
else:
    print("La requête a échoué avec le code d'état:", response.status_code)
```