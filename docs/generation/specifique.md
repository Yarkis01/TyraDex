<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/gen/&lt;generation&gt;]</span> Génération spécifique</h1>

```text
https://tyradex.app/api/v1/gen/<generation>
```

Permet d'obtenir la liste des pokémons d'une génération.<br>
[Exemple de donnés renvoyés.](https://tyradex.app/api/v1/gen/8) 

## Paramètres
| Nom | Obligatoire | Type | Description |
|---|---|---|---|
| generation | Requis | `Int` | Correspond au numéro de la génération. |

## Curl
```sh
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://tyradex.app/api/v1/gen/<generation>'
```

## Python
```py
import requests

url = "https://tyradex.app/api/v1/gen/<generation>"
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