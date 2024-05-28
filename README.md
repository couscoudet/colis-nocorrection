# colis-ws

Pour l'exposition REST des services de gestion de colis

Etapes à suivre pour le lancement du projet : Après le rapatriement du projet, vous devez suivre quelques petites étapes avant de voir votre projet se lancer à merveille :
1. Récupération et paramétrage du projet :
Avant d’y plonger tête baissée, vous devez tout d’abord identifier avec quelle config vous allez travailler. Pour le cas spécifique de ce projet, nous partirons sur deux configurations à savoir mySQL et postgreSQL.
       Configuration de mySQL et postgreSQL :
* lancement du serveur de donnée (ce sont les mêmes étapes que ceux détaillés dans la partie business. Si vous vous rappellez bien, il s’agit de wamp server pour mySQL et pdAdmin sur potsgreSQL)
* Le web service possède également des fichiers de configuration(application.yml pour les utilisateurs de mySQL et application-postgres.yml pour les utilisateurs de postgreSQL), vous allez donc le configurer selon les instructions du formateur
2. Lancement du projet :
Ici vous allez lancer la classe principale « main », si vous avez bien exécutés les instructions antérieures, votre console ne devrait pas vous afficher d’erreur. Si le web service est bien lancé donc, vous allez interroger vos api disponible et pour ce faire, vous devez utilisez l’application postMan.


Note : De base, votre web service se lance avec le fichier de configuration par défaut qui est celui de mySQL, ce à cause de fichier de configuration de mySQL que nous avons modifier pour le faire pointer vers le fichier de config de postgreSQL. Pour modifier ce fonctionnement, il vous suffit de supprimer/commenter le paramètre de spring : profiles.active=postgres. 
