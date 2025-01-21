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
## Exercice 6 : Gestion d'une liste de tâches
Créez un contrôleur TaskController pour gérer une liste de tâches avec les fonctionnalités suivantes :
- POST /tasks
  - Ajoute une nouvelle tâche envoyée sous forme de JSON { "title": "Faire les courses" }.
  - Retourne 201 Created avec un message "Tâche ajoutée avec l'ID X".
- PUT /tasks/{id}
  - Met à jour le titre d'une tâche existante { "title": "Nouvelle description" }.
  - Retourne 200 OK si mise à jour réussie, sinon 404 Not Found.
- DELETE /tasks/{id}
  - Supprime une tâche par son ID.
  - Retourne 200 OK si supprimé, sinon 404 Not Found.
## Exercice 7 : Modification de la gestion des utilisateurs
Créez un contrôleur UserController pour manipuler des utilisateurs :
- POST /users
  - Ajoute un nouvel utilisateur avec un JSON { "name": "Alice", "email": "alice@mail.com" }.
  - Retourne 201 Created avec "Utilisateur ajouté avec l'ID X".
- PUT /users/{id}
  - Modifie les informations d'un utilisateur { "name": "Alice Updated", "email": "alice.new@mail.com" }.
  - Retourne 200 OK si mise à jour réussie, 404 Not Found sinon.
- DELETE /users/{id}
  - Supprime un utilisateur.
  - Retourne 200 OK si réussi, 404 Not Found sinon.
## Exercice 8 : Modification de l'inventaire des produits
Créez un contrôleur ProductController pour gérer un inventaire :
- POST /products
  - Ajoute un produit avec { "name": "Laptop", "price": 999.99 }.
  - Retourne 201 Created avec "Produit ajouté avec l'ID X".
- PUT /products/{id}
  - Met à jour le prix d'un produit { "price": 899.99 }.
  - Retourne 200 OK si modification réussie, 404 Not Found sinon.
- DELETE /products/{id}
  - Supprime un produit de l’inventaire.
  - Retourne 200 OK si réussi, 404 Not Found sinon.
## Exercice 9 : Gestion des réservations de salles
Créez un contrôleur BookingController pour gérer les réservations :
- POST /bookings
  - Ajoute une réservation { "room": "Salle A", "date": "2024-02-01" }.
  - Retourne 201 Created "Réservation confirmée avec ID X".
- PUT /bookings/{id}
  - Modifie une réservation { "date": "2024-02-02" }.
  - Retourne 200 OK si mis à jour, 404 Not Found sinon.
- DELETE /bookings/{id}
  - Annule une réservation.
  - Retourne 200 OK si réussi, 404 Not Found sinon.
## Exercice 10 : Gestion d'un blog
Créez un contrôleur PostController pour gérer des articles de blog :
- POST /posts
  - Ajoute un article { "title": "Spring Boot", "content": "Introduction à Spring Boot" }.
  - Retourne 201 Created "Article ajouté avec l'ID X".
- PUT /posts/{id}
  - Met à jour un article { "title": "Mise à jour", "content": "Contenu mis à jour" }.
  - Retourne 200 OK si modifié, 404 Not Found sinon.
- DELETE /posts/{id}
  - Supprime un article.
  - Retourne 200 OK si réussi, 404 Not Found sinon.
