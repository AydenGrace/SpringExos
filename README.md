## Exercice 1 : Hello, Spring Boot !
Créez un contrôleur qui expose une route GET /hello prenant un paramètre name via @RequestParam et retournant une réponse sous la forme :
Exemple :
- Requête : GET /hello?name=Jean
- Réponse : "Bonjour, Jean !"
## Exercice 2 : Calculatrice simple
Créez un contrôleur CalculatorController qui expose une route GET /add prenant deux paramètres a et b via @RequestParam et retournant leur somme.
Exemple :
- Requête : GET /add?a=5&b=3
- Réponse : "Résultat : 8"

Ajoutez une autre route GET /multiply/{a}/{b} utilisant @PathVariable pour effectuer une multiplication.
Exemple :
- Requête : GET /multiply/4/2
- Réponse : "Résultat : 8"
## Exercice 3 : Gestion des utilisateurs (Simulé)
Créez un contrôleur UserController avec une liste statique d'utilisateurs sous forme de Map<Integer, String> (clé = ID, valeur = nom).
Exposez deux routes :
GET /user/{id} qui retourne le nom de l'utilisateur correspondant à l'ID fourni avec @PathVariable.
Exemple :
- GET /user/1 → "Utilisateur : Alice"
- GET /user/all qui retourne tous les utilisateurs sous forme de liste.

## Exercice 4 : Conversion de température
Créez un contrôleur TemperatureController qui expose une route GET /convert avec un paramètre @RequestParam(value="celsius") convertissant la température en Fahrenheit.
Formule : F = (C × 9/5) + 32
Exemple :
- GET /convert?celsius=25
- Réponse : "25°C = 77°F"
## Exercice 5 : Gestion de produits
Créez un contrôleur ProductController qui gère une liste de produits sous forme de Map<Integer, String>.
Exposez trois routes :
- GET /product/{id} → Retourne le produit correspondant à l'ID (@PathVariable).
- GET /product/add?name=XXX → Ajoute un produit (@RequestParam).
- GET /product/all → Retourne la liste des produits.
