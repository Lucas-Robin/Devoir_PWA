# Devoir de programmation web avancée

Le but de ce devoir est de réaliser une application web de billeterie pour des concerts ou tout autre type d'évènement. Celle-ci à été réalisée à l'aide des technologies JEE servlet et JSP, du frameworks Hibernate et de l'API Jax-RS et tout ceci fonctionne grace à un serveur Tomcat et une base de donnée MySQL.

## Présentation 

![Diagramme UML](Diagramme_1.png)

Le model utilisé pour cette application est le suivant : les billets (Classe `Ticket`) font référence à un acheteur (Classe `Client`) et à un évènement (Classe `Show`). Les évènements concernent un lieu d'accueil (Classe `Place`) et un artiste, qu'il soit un groupe (Classe `Band`) ou une personne (Classe `PersonArtist`), et à un organisateur (Classe `ShowOrganisator`).

Ensuite, une API REST à été implémentée pour gérer l'intégralité de ces informations, ainsi que le test et la validation des billets. Toutes ses données sont sauvegardées sur la base de donnée MySQL grâce à Hibernate
