# colis-ws

Pour l'exposition REST des services de gestion de colis

Etapes � suivre pour le lancement du projet�: Apr�s le rapatriement du projet, vous devez suivre quelques petites �tapes avant de voir votre projet se lancer � merveille�:
1. R�cup�ration et param�trage du projet�:
Avant d�y plonger t�te baiss�e, vous devez tout d�abord identifier avec quelle config vous allez travailler. Pour le cas sp�cifique de ce projet, nous partirons sur deux configurations � savoir mySQL et postgreSQL.
       Configuration de mySQL et postgreSQL�:
* lancement du serveur de donn�e (ce sont les m�mes �tapes que ceux d�taill�s dans la partie business. Si vous vous rappellez bien, il s�agit de wamp server pour mySQL et pdAdmin sur potsgreSQL)
* Le web service poss�de �galement des fichiers de configuration(application.yml pour les utilisateurs de mySQL et application-postgres.yml pour les utilisateurs de postgreSQL), vous allez donc le configurer selon les instructions du formateur
2. Lancement du projet�:
Ici vous allez lancer la classe principale ��main��, si vous avez bien ex�cut�s les instructions ant�rieures, votre console ne devrait pas vous afficher d�erreur. Si le web service est bien lanc� donc, vous allez interroger vos api disponible et pour ce faire, vous devez utilisez l�application postMan.


Note�: De base, votre web service se lance avec le fichier de configuration par d�faut qui est celui de mySQL, ce � cause de fichier de configuration de mySQL que nous avons modifier pour le faire pointer vers le fichier de config de postgreSQL. Pour modifier ce fonctionnement, il vous suffit de supprimer/commenter le param�tre de spring�: profiles.active=postgres. 
