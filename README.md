# Geschool #
Application web pour la gestion académique d'un établissement scolaire

----------
Ce projet initié par ***Inès***

Avec notamment pour but comme nous réalisons les fonctionnalités néccessaires. 
le projet sera mené sur le langage JAVA notamment avec l'aide des outils :


- **Netbeans** : IDE 8.0.2
- **Glasfish** : serveur d'application dans sa version 4.x
- **MySql** : le serveur de gestion de Bases de donnée, concernant la version, l'important c'est que chacun possède un serveur de base MySql
- **Maven** : c'est nouveau pour certain, mais avec le temps vous vous y habiturez, en fait il s'agit d'un outil qui permet de mettre IDE Netbeans en liaison avec un repository qui containt beaucoup de librairie *.jar donc nous aurons besoin dans ce projet. Je vous expliquerez son fonctionnement au fil du développement.
- **Git** : dans sa version la plus récente pour l'OS Windows, il nous servira pour la gestion des versions du projet, plus bas je vous expliquerez comment l'utiliser correctement pour avoir le projet sur vos Pc.

> Ceci étant dis, je vais maintenant vous dire comment bien configurer votre environnement de travail afin de mieux débuter le projet. 
> **Avant de lire les lignes qui suivent il est primordiale d'avoir une connexion internet**

1. déjà voici le lien du site pour télécharger l'outil git pour windows [https://git-scm.com/download/win](https://git-scm.com/download/win "git for windows")
2. Créer vous un nouveau répertoire avec pour nom **`Geschool`**
3. Une fois dans ce répertoire faites un **`clic droit`**-> cliquer sur **`Git Bash Here`**,un terminal Shell Linux s'ouvrira
4. Dans ce terminal, tapez les lignes de code suivants:
	1. **`git init`** cette commande va initialiser votre dossier en un dépôt local
	2. **`git clone https://github.com/Ines-Friends/Geschool.git`** cette commande va télécharger le projet sur gitHub directement dans votre dépôt local
5.  Puis ouvrez IDE Netbeans, faites un **`Ctrl + Maj + O`** pour ouvrir un projet et sélectionner votre dépôt locale. 

> C'est bon vous êtes dores et déjà prêt à coder.

----------

Quant au déroulement de la phase de développement, il faudra toujours avoir votre IDE et le terminal shell de Git ouvert tous deux en même temps,
Aussi avant de commencer voici le commandes à retenir de Git.

- **`git pull https://github.com/Ines-Friends/Geschool.git`** cette commande permet de récupérer les derniers changement effectuer sur le dépôt distant **Commande à  taper en premier avant l'écriture de la moindre ligne de code dans son dépôt local**
- **`git add`** commande pour que git tienne de l'ajout d'un nouveau fichier dans le dépôt local 
- **`git commit -m "Un commentaire"`** ajout de toutes les modifications effectuées dans le dépôt local de git
- **`git push https://github.com/xavierngaba/Geschool.git`** commande pour l'envoie sur le dépôt distant des modifications qui ont été apportées sur le dépôt local.

Ces étapes telles qu'elles sont énumérées sont à retenir car importantes pour la suite.

Mais si ça n'a pas été assez clair voici le lien pour la documentation complète de ***Git*** [https://git-scm.com/docs](https://git-scm.com/docs "Git doc")

----------
Le dépot a été restructuré en plusieurs **Branches** pour justement éviter qu'il y ait trop de désordre dans pendant la phase de dev, les **branches** étant:
- `Master` : c'est la branche par défaut qui contiendra l'application à sa version la plus stable possible, donc seul l'admin pourra y effectuer des `merge request`
- `Config` : pour faire tous les `git commit` en rapport avec les fichiers de configurations du projets, le `merge request` toujours à la responsabilité de l'administrateur
- `Bugs` : pour faire tous les `git commit` en rapport avec la correction des bugs, le `merge request` toujours à la responsabilité de l'administrateur
- `dev` : cette branche contiendra tous les scripts en rapport avec chaque **Sprint**, c'est-à-dire, à Chaque tâche assigner à un dev, il devra suivre les étapes suivantes:
	- `git checkout dev` : pour se positionner sur cette branche 
	- `git branch #Sprint1-USx.x-Y`: création d'une nouvelle branche en respectant le format **`#Sprint1-USx.x-Y`**, parce que ça désigne, le Sprint en cours, l'US en cours de dev et la tâche qui sera réalisée,
	- `git checkout #Sprint1-USx.x-Y` : pour se positionner sur cette branche afin de commencer à coder, comme ça après avoir fini
	- `git add` : pour l'ajout de l'ensemble des fichiers créés sur votre branche 
	- `git commit -m "Un commentaire"` : pour que git l'ajout dans l'entête sur cette branche
	- `git push https://github.com/xavierngaba/Geschool.git`** pour l'envoyer sur le dépôt distant.
	- Après signaler à l'administrateur que votre tâche est terminée, pour qu'il effectue un `merge request` de la branche `Dev` vers votre branche `#Sprint1-USx.x-Y` pour récupérer l'ensemble de votre travail.pour vérifier que tout à été bien fait.

Comme ça à la fin d'un Sprint un `Tag` sera posé au niveau de la dernière focntionnalité pour marquer la fin de cette phase, l'administrateur pour faire un `git push` de ce dépôt vers le dépôt origanl d'inès pour qu'elle ait une version stable de son application. 

Comme vous l'aurait compris faudra toujours gardé en tête cette commande `git checkout <nom de la branche>` dans laquelle vous devrez à nouveau créer une nouvelle branche en rapport avec ce que vous devrez faire.
----------

C'est tout pour le moment,ce fichier sera mis à jour au fur et à mesure de l'avancée du projet.
