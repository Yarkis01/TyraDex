from flask_restful import Resource
from typing import Union
from unidecode import unidecode
import json

JSON_Moves       = json.load(open("data/moves/moves.json", encoding="utf8"))
JSON_Moves_to_id = json.load(open("data/moves/moves_to_id.json", encoding="utf8"))

class Moves(Resource):
    def get(self, moves: Union[str, int] = None) -> dict:
        if not moves:
            return JSON_Moves
        
        if moves.isdigit():
            moves_id = int(moves)
        else:
            moves    = unidecode(str(moves).replace('-', '').replace(' ', '').replace('_', '').lower())
            moves_id = JSON_Moves_to_id.get(moves, -1)
        
        if moves_id == -1 or moves_id < 0 or moves_id > (len(JSON_Moves) - 1):
            return{
                "status" : 404,
                "message": "Impossible de trouver l'attaque demandée dans la base de données."
            }, 404
        
        return JSON_Moves[moves_id]
