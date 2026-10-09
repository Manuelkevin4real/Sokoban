# Guide de collaboration Git et GitHub

Ce document présente les règles et commandes à utiliser pour collaborer efficacement sur le projet **Sokoban Java**.

## 1. Règles communes de l'équipe

Pour limiter les conflits et garder une branche principale stable, nous suivons ces règles :

1. **Ne pas travailler directement sur `main`.**
2. Créer une branche pour chaque fonctionnalité ou correction.
3. Récupérer régulièrement les dernières modifications du dépôt.
4. Tester le code avant de créer une Pull Request.
5. Faire des commits clairs et ciblés.
6. Faire relire les modifications avant de les fusionner dans `main`.
7. Ne jamais utiliser `git push --force` sur une branche partagée sans accord explicite de l'équipe.

> Convention recommandée : **une fonctionnalité = une branche = une Pull Request**.

## 2. Première installation

Chaque membre du groupe clone le dépôt une seule fois :

```bash
git clone <URL_DU_DEPOT>
cd Sokoban-Java
```

Configurez votre identité Git si ce n'est pas déjà fait :

```bash
git config --global user.name "Votre Nom"
git config --global user.email "votre-email@example.com"
```

Vérifiez la configuration :

```bash
git config --global --list
```

Remplacez `<URL_DU_DEPOT>` et les informations d'exemple par les valeurs appropriées.

## 3. Début d'une session de travail

### Mettre à jour `main`

Commencez par vérifier que votre travail local est enregistré ou mis de côté. Puis :

```bash
git switch main
git status
git pull origin main
```

Si `git status` indique des modifications locales non enregistrées, ne les écrasez pas : enregistrez-les dans un commit ou mettez-les temporairement de côté avant de changer de branche ou de récupérer les modifications distantes.

### Créer une branche

Créez une branche dédiée à votre tâche :

```bash
git switch -c feature/nom-de-la-fonctionnalite
```

Exemples de noms de branches :

| Travail | Nom de branche |
|---|---|
| Affichage de la grille | `feature/affichage-grille` |
| Déplacement du joueur | `feature/deplacement-joueur` |
| Gestion des caisses | `feature/gestion-caisses` |
| Détection de victoire | `feature/detection-victoire` |
| Gestion des niveaux | `feature/gestion-niveaux` |
| Solveur DFS | `feature/solveur-dfs` |
| Solveur BFS | `feature/solveur-bfs` |
| Correction d'un bug | `fix/description-du-bug` |
| Documentation | `docs/readme` |

Si vous reprenez une branche existante, utilisez plutôt :

```bash
git switch nom-de-branche
```

## 4. Pendant le développement

Consultez régulièrement l'état du dépôt :

```bash
git status
```

Examinez les modifications apportées :

```bash
git diff
```

Avant de partager votre travail :

- compilez le projet ;
- testez la fonctionnalité concernée ;
- vérifiez que vous n'avez pas inclus de fichiers temporaires, de fichiers compilés ou de modifications sans rapport avec votre tâche.

Pour le projet Sokoban, mettez-vous d'accord en équipe sur les noms des méthodes et la représentation de la grille. Le sujet impose une seule classe Java principale ; si plusieurs personnes modifient `Main.java` en même temps, les conflits sont plus probables. Communiquez avant de modifier une partie commune du code.

## 5. Enregistrer les modifications

Ajoutez seulement les fichiers nécessaires au commit :

```bash
git add src/Main.java
```

Ou, après avoir vérifié les fichiers concernés, ajoutez toutes les modifications du dossier courant :

```bash
git add .
```

Vérifiez ce qui sera inclus :

```bash
git status
git diff --staged
```

Créez ensuite un commit avec un message explicite :

```bash
git commit -m "feat: ajouter le deplacement du joueur"
```

Exemples de messages :

```text
feat: afficher la grille
feat: gerer le deplacement des caisses
feat: ajouter le compteur de mouvements
fix: empecher le passage a travers les murs
docs: completer le README
```

Un commit enregistre les modifications localement ; il ne les envoie pas encore sur GitHub.

## 6. Publier sa branche sur GitHub

Lors du premier envoi de la branche :

```bash
git push -u origin feature/nom-de-la-fonctionnalite
```

Pour les envois suivants sur cette branche :

```bash
git push
```

## 7. Créer une Pull Request

Après avoir poussé votre branche :

1. Ouvrez le dépôt sur GitHub.
2. Créez une **Pull Request** de votre branche vers `main`.
3. Expliquez brièvement ce qui a été ajouté ou corrigé.
4. Indiquez comment vous avez testé votre code.
5. Demandez une relecture à un autre membre.
6. Corrigez les remarques et vérifiez que le projet fonctionne.
7. Fusionnez la Pull Request une fois qu'elle est approuvée selon les règles du groupe.

Évitez de fusionner du code qui ne compile pas ou qui casse une fonctionnalité déjà présente.

## 8. Après la fusion

Une fois votre Pull Request fusionnée, mettez à jour votre branche principale :

```bash
git switch main
git pull origin main
```

Pour une nouvelle tâche, créez une nouvelle branche à partir de `main` à jour.

Si vous devez continuer à travailler sur une branche existante, récupérez les changements de `main` et intégrez-les prudemment. Par exemple, depuis votre branche de fonctionnalité :

```bash
git fetch origin
git merge origin/main
```

Résolvez les éventuels conflits, puis compilez et testez le projet avant de pousser.

## 9. Résoudre un conflit

Un conflit survient notamment lorsque plusieurs branches modifient les mêmes lignes d'un fichier.

Git peut insérer des marqueurs de ce type :

```text
<<<<<<< HEAD
Votre version
=======
Version de l'autre branche
>>>>>>> autre-branche
```

Pour le résoudre :

1. Ouvrez le fichier concerné.
2. Comparez les versions et décidez du contenu final avec les personnes concernées si nécessaire.
3. Conservez le code voulu et supprimez les marqueurs de conflit.
4. Vérifiez que le fichier est cohérent.
5. Compilez et testez le projet.
6. Marquez le conflit comme résolu et enregistrez la résolution.

```bash
git status
git add src/Main.java
git commit -m "fix: resoudre le conflit dans Main.java"
```

La dernière commande convient notamment lorsqu'une fusion s'est arrêtée sur un conflit et attend un commit de résolution. Si Git indique qu'une opération de rebase est en cours, suivez plutôt les instructions adaptées au rebase affichées par Git.

**Ne supprimez pas les marqueurs sans vérifier le code**, au risque de perdre le travail d'un membre.

## 10. Commandes utiles à retenir

| Commande | Utilité |
|---|---|
| `git clone <URL>` | Cloner le dépôt pour la première fois |
| `git status` | Voir l'état du dépôt |
| `git switch main` | Passer sur la branche principale |
| `git pull origin main` | Récupérer les changements de `main` |
| `git switch -c feature/nom` | Créer une branche et s'y placer |
| `git switch nom` | Changer de branche |
| `git diff` | Examiner les modifications non indexées |
| `git add <fichier>` | Préparer un fichier pour le commit |
| `git diff --staged` | Examiner les modifications préparées |
| `git commit -m "message"` | Enregistrer un commit local |
| `git push -u origin branche` | Publier une branche pour la première fois |
| `git push` | Envoyer les commits suivants |
| `git fetch origin` | Actualiser les références distantes sans fusionner |
| `git merge origin/main` | Intégrer `origin/main` dans la branche actuelle |
| `git log --oneline` | Consulter l'historique des commits |

## 11. Si quelque chose se passe mal

Avant toute commande qui peut supprimer ou remplacer des modifications, commencez par :

```bash
git status
git diff
git diff --staged
```

Évitez d'utiliser `git reset --hard` ou `git push --force` sans comprendre leurs effets et sans vérifier que le travail d'un autre membre ne sera pas perdu. En cas de doute, demandez de l'aide à l'équipe avant d'exécuter une commande destructive.

---

## Routine quotidienne — résumé

### Au début d'une nouvelle tâche

```bash
git switch main
git pull origin main
git switch -c feature/ma-fonctionnalite
```

### Pendant le développement

```bash
git status
git diff
```

Compilez et testez régulièrement.

### Quand le travail est prêt

```bash
git add <fichiers-concernes>
git diff --staged
git commit -m "feat: description claire"
git push -u origin feature/ma-fonctionnalite
```

Puis créez une Pull Request sur GitHub et demandez une relecture.

### Après la fusion

```bash
git switch main
git pull origin main
```

**Objectif de l'équipe :** garder `main` stable, communiquer avant les modifications communes et intégrer du code testé.
