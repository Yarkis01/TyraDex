<h1><span class="documentation_get">GET</span><span class="documentation_url">[api/v1/gen]</span> Générations</h1>

```text
https://tyradex.app/api/v1/gen
```

Permet d'obtenir la liste des différentes générations.<br>
[Exemple de donnés renvoyés.](https://tyradex.app/api/v1/gen) 

## Curl
```sh
curl -XGET \
     -H 'User-Agent: RobotPokemon' \
     -H 'From: adresse[at]domaine[dot]com' \
     -H "Content-type: application/json" \
     'https://tyradex.app/api/v1/gen'
```

## Python
```py
import requests

url = "https://tyradex.app/api/v1/gen"
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