# ALLER SUR LA BRANCHE MAIN (pas master)

# Réalisation d'une application de forum

--> Le choix des technologies vous appartient
--> L'application doit respecter au minimum les éléments demandés par le client
--> Vous êtes libre d'ajouter les fonctionnalités que vous souhaitez en fonction de votre temps
--> L'application doit être conteneurisée avec Docker
--> Votre application peut posséder quelques tests unitaires
--> Acun bug dans la console ne doit apparaître

# Critères de notation : 

1. Toutes les demandes du client sont respectées
2. Aucun bug n'est visible en console
3. Des tests unitaires sont présents dans votre application
4. L'application se lance correctement uniquement avec un docker compose up
5. Bonus : des fonctionnalités ont été ajoutées

# Lancement

1. Dans une invite de commande, naviguez jusqu'à la racine du projet (contenant le docker-compose.yml)
2. Lancez la commande suivante : docker-compose -f docker.compose.yml up -d
	Information: pour voir votre database, vous pouvez utiliser phpmyadmin sur votre navigateur en allant à l'url suivant: http://localhost:8081/
	Utilisateur : root
	Mot de passe : password
3. Lancez le Backend (forum)
4. Lancez le Frontend
	5A Naviguez, avec votre invite de commande, a la racine du frontend (forum/forum-front)
	5B. Utilisez la commande suivante : ng serve -o
5. Sur le site, cliquez sur le bouton, et créez un utilisateur
6. Connectez vous grâce à l'identifiant créé
7. Cliquez sur forum pour accéder au forum

 
# ForumFront

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 13.2.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
