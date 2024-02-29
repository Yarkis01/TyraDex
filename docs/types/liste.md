<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/types/]</span> Liste des types</h1>

```text
https://tyradex.tech/api/v1/types
```

Permet d'obtenir la liste de tous les types.<br>
[Exemple de donnés renvoyés.](https://tyradex.tech/api/v1/types)

## Curl
```sh
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://tyradex.tech/api/v1/types/'
```

## Python
```py
import requests

url = "https://tyradex.tech/api/v1/types/"
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
