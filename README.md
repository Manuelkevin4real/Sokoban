# 🎮 Sokoban Java — Jeu et résolution algorithmique

## 📌 Présentation du projet

Ce projet consiste à développer une version console du jeu **Sokoban en Java**, dans le cadre du projet de programmation Java ESIEA 2026-2027.

Sokoban est un jeu de réflexion dans lequel le joueur doit déplacer des caisses sur des cases objectifs, en se déplaçant sur une grille. Le joueur peut pousser les caisses, mais ne peut pas les tirer.

L'objectif principal est de concevoir un jeu fonctionnel en Java, tout en mettant en pratique les notions fondamentales de programmation et d'algorithmique.

Dans sa version avancée, le projet intègre également un système de résolution automatique permettant de rechercher une solution à l'aide de deux algorithmes : **DFS (recherche en profondeur)** et **BFS (recherche en largeur)**.

## 🎯 Objectifs

Les objectifs du projet sont les suivants :

* Développer un jeu fonctionnel en Java dans un environnement console.
* Implémenter les déplacements du joueur et des caisses.
* Gérer les collisions avec les murs et les limites de la grille.
* Détecter automatiquement la victoire.
* Proposer plusieurs niveaux de jeu.
* Appliquer les notions de programmation structurée et de tableaux.
* Mettre en œuvre des algorithmes de recherche pour résoudre automatiquement les niveaux, dans la version avancée.
* Comparer les performances et les résultats des algorithmes DFS et BFS.

## 🕹️ Règles du jeu

Le joueur évolue sur une grille composée de murs, de cases libres, de caisses et de cases objectifs.

Le but est de placer toutes les caisses sur les cases objectifs.

### Commandes

| Touche | Action                            |
| ------ | --------------------------------- |
| `Z`    | Déplacer le joueur vers le haut   |
| `S`    | Déplacer le joueur vers le bas    |
| `Q`    | Déplacer le joueur vers la gauche |
| `D`    | Déplacer le joueur vers la droite |
| `X`    | Quitter la partie                 |

### Symboles de la grille

| Symbole | Signification                 |
| ------- | ----------------------------- |
| `#`     | Mur                           |
| ` `     | Case libre                    |
| `@`     | Joueur                        |
| `$`     | Caisse                        |
| `.`     | Case objectif                 |
| `*`     | Caisse placée sur un objectif |

### Règles de déplacement

* Le joueur ne peut pas traverser les murs.
* Le joueur peut se déplacer sur une case libre.
* Lorsqu'une caisse se trouve devant lui, le joueur peut la pousser si la case située derrière elle est libre.
* Le joueur ne peut pas tirer les caisses.
* La partie est gagnée lorsque toutes les caisses sont placées sur les objectifs.

## ⚙️ Fonctionnalités

### Fonctionnalités principales

Le jeu doit proposer les fonctionnalités suivantes :

* Affichage de la grille dans la console.
* Déplacement du joueur à l'aide du clavier.
* Déplacement des caisses selon les règles du jeu.
* Détection des déplacements invalides.
* Gestion des murs et des collisions.
* Vérification automatique de la victoire.
* Comptage du nombre de mouvements effectués.
* Sélection et chargement de plusieurs niveaux.
* Menu permettant de naviguer entre les différentes options.

### Fonctionnalités avancées

Pour la version avancée, le projet prévoit également :

* Résolution automatique d'un niveau par DFS.
* Résolution automatique d'un niveau par BFS.
* Détection des états déjà explorés afin d'éviter les répétitions inutiles.
* Affichage d'une solution lorsqu'elle est trouvée.
* Comptage des états explorés.
* Comparaison des résultats obtenus avec DFS et BFS.

### Fonctionnalités bonus

Selon l'avancement du projet, des fonctionnalités supplémentaires pourront être ajoutées :

* Ajout de nouveaux niveaux.
* Possibilité de recommencer une partie.
* Annulation du dernier mouvement.
* Détection de certaines situations dans lesquelles une caisse est bloquée.
* Mesure et comparaison du temps d'exécution des algorithmes.
* Recherche d'une solution minimisant le nombre de mouvements.

## 🛠️ Technologies utilisées

* **Java** : langage de programmation.
* **JDK** : environnement de développement Java.
* **Git** : gestion des versions.
* **GitHub** : hébergement du code et collaboration entre les membres du groupe.
* **IDE** : IntelliJ IDEA, Eclipse ou un autre environnement compatible avec Java.

Le projet respecte les contraintes techniques du sujet : application console, utilisation de tableaux, absence d'interface graphique, de base de données et de bibliothèques externes.

Les structures de données nécessaires aux algorithmes de recherche doivent être implémentées conformément aux consignes du projet.

## 📂 Structure du projet

La structure exacte dépend de l'organisation du code. Une organisation possible est la suivante :

```text
Sokoban-Java/
│
├── src/
│   └── Main.java
│
├── README.md
│
└── .gitignore
```

* `src/` : contient le code source Java.
* `Main.java` : contient la classe principale et le point d'entrée du programme.
* `README.md` : présente le projet, ses règles et son fonctionnement.
* `.gitignore` : définit les fichiers à exclure du suivi Git.

Conformément au sujet, le programme doit comporter une seule classe Java principale. Les méthodes doivent être organisées de manière claire, chaque méthode ayant une responsabilité précise.

## 📥 Installation et exécution

### Prérequis

Avant de lancer le projet, il faut disposer de :

* Un JDK compatible avec le code source.
* Un terminal ou une invite de commande.
* Git, si le projet est récupéré depuis GitHub.

### 1. Cloner le dépôt

```bash
git clone <URL_DU_DEPOT>
```

### 2. Accéder au dossier du projet

```bash
cd Sokoban-Java
```

### 3. Compiler le programme

Si le fichier `Main.java` se trouve directement dans le dossier `src/` et que le projet ne nécessite aucune dépendance supplémentaire :

```bash
javac -d out src/Main.java
```

### 4. Exécuter le programme

```bash
java -cp out Main
```

**Remarque :** les commandes doivent être adaptées si le fichier principal se trouve dans un autre dossier ou si le code utilise une déclaration de package.

## 🧠 Résolution algorithmique

La version avancée du projet introduit deux méthodes de recherche permettant d'explorer les différents états possibles du jeu.

### DFS — Depth-First Search

La recherche en profondeur explore une branche aussi loin que possible avant de revenir en arrière pour examiner d'autres possibilités.

**Principe :**

* Explorer un état du jeu.
* Vérifier si cet état correspond à une victoire.
* Générer les états accessibles.
* Continuer l'exploration en profondeur.
* Éviter de revisiter les états déjà explorés.

**Avantage :** cette approche peut être implémentée de manière récursive.

**Limite :** elle peut explorer une branche longue sans trouver rapidement une solution courte.

### BFS — Breadth-First Search

La recherche en largeur explore les états par ordre de distance depuis l'état initial, en utilisant une file pour gérer les états à examiner.

**Principe :**

* Ajouter l'état initial à la file.
* Retirer un état de la file.
* Vérifier si cet état correspond à une victoire.
* Ajouter à la file les nouveaux états accessibles qui n'ont pas encore été explorés.
* Répéter jusqu'à trouver une solution ou épuiser les états disponibles.

**Avantage :** lorsque chaque mouvement a le même coût, BFS permet de trouver une solution comportant un nombre minimal de mouvements si une solution existe et si l'exploration est correctement implémentée.

**Limite :** la mémoire nécessaire peut devenir importante lorsque le nombre d'états à explorer augmente.

### Comparaison des algorithmes

Le projet prévoit une comparaison des deux algorithmes sur une même grille.

Les critères étudiés sont :

* Existence d'une solution.
* Nombre de mouvements de la solution trouvée.
* Nombre d'états explorés.
* Temps d'exécution, si cette fonctionnalité est implémentée.

Cette comparaison permettra de mieux comprendre les différences entre les deux stratégies de recherche.

## 👥 Organisation du travail en groupe

Le projet est réalisé en équipe. Chaque membre participe au développement, aux tests et à l'amélioration du programme.

La répartition des responsabilités est à compléter selon l'organisation réelle du groupe.

| Membre   | Responsabilités                                   |
| -------- | ------------------------------------------------- |
| Membre 1 | Gestion de la grille et affichage                 |
| Membre 2 | Déplacements du joueur et des caisses             |
| Membre 3 | Gestion des niveaux et détection de la victoire   |
| Membre 4 | Algorithmes DFS/BFS et comparaison, si applicable |

Cette répartition est indicative et doit être adaptée au nombre de membres et au niveau du projet.

## 🌿 Gestion de versions

Le développement collaboratif s'appuie sur Git et GitHub.

Les bonnes pratiques recommandées sont :

* Utiliser un dépôt commun pour centraliser le code.
* Créer des commits réguliers avec des messages explicites.
* Tester les modifications avant de les intégrer.
* Éviter les modifications simultanées non coordonnées sur les mêmes parties du code.
* Vérifier que le programme compile et fonctionne après chaque intégration.

## 🧪 Tests et validation

Les tests doivent permettre de vérifier le respect des règles du jeu et le bon fonctionnement des algorithmes.

Les principaux cas à tester sont :

* Déplacement du joueur dans les quatre directions.
* Tentative de déplacement contre un mur.
* Poussée d'une caisse vers une case libre.
* Tentative de pousser une caisse contre un mur ou une autre caisse.
* Détection de la victoire.
* Chargement et sélection des différents niveaux.
* Gestion des commandes invalides.
* Recherche d'une solution avec DFS et BFS, pour la version avancée.
* Gestion d'un niveau pour lequel aucune solution n'est trouvée.

## 📌 Contraintes techniques

Le projet doit respecter les contraintes définies dans le sujet :

* Langage de programmation : Java.
* Application exécutée en console.
* Une seule classe Java principale.
* Utilisation de tableaux.
* Plusieurs méthodes ayant chacune une responsabilité claire.
* Aucune interface graphique.
* Aucune base de données.
* Aucune bibliothèque externe.
* Implémentation des structures de données nécessaires aux algorithmes de recherche, sans utiliser `ArrayList`, `HashMap` ou une structure équivalente pour remplacer le travail algorithmique demandé.

Le programme doit pouvoir être compilé et exécuté depuis la ligne de commande.

## 🚀 Conclusion

Ce projet permet de mettre en pratique les fondamentaux de Java à travers la réalisation d'un jeu de réflexion complet.

Au-delà de la programmation du jeu, il constitue une introduction à la recherche algorithmique, à la gestion des états et à l'analyse comparative des algorithmes DFS et BFS.

Il permet également de développer des compétences essentielles en travail d'équipe, en organisation du code et en gestion de versions.

---

**Projet Java — ESIEA | PASS Java 2026-2027**
