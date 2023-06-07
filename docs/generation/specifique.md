<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/gen/&lt;generation&gt;]</span> Génération spécifique</h1>

```http
https://api-pokemon-fr.vercel.app/api/v1/gen/<generation>
```

Permet d'obtenir des informations sur une génération spécifique.<br>
[Exemple de donnés renvoyés.](https://api-pokemon-fr.vercel.app/api/v1/gen/8) 

## Paramètres
| Nom | Obligatoire | Type | Description |
|---|---|---|---|
| generation | ✔️ | `Int` | Correspond au numéro de la génération. |

## Curl
```curl
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://api-pokemon-fr.vercel.app/api/v1/gen/<generation>'
```

## Python
```py
import requests

url = "https://api-pokemon-fr.vercel.app/api/v1/gen/<generation>"
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