<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/types/&lt;type&gt;]</span> Types</h1>

```text
https://tyradex.tech/api/v1/types/<type1>/[type2]
```

Permet d'obtenir des informations sur un type spécifique.<br>
[Exemple de donnés renvoyés.](https://tyradex.tech/api/v1/types/fire) 

# Paramètres
| Nom | Obligatoire | Type | Description |
|---|---|---|---|
| Type 1 | Requis | `Int` ou `String` | Correspond à l'identifiant du type, ou bien son nom anglais ou français. |
| Type 2 | Optionnel | `Int` ou `String` | Correspond au deuxième type souhaité. <br>Avec la combinaison, cela vous permet d'obtenir les Pokémons possédants ce double type. |

## Curl
```sh
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://tyradex.tech/api/v1/types/<type1>/[type2]'
```

## Python
```py
import requests

url = "https://tyradex.tech/api/v1/types/<type1>/[type2]"
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