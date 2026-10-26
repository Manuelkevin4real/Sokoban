import java.util.Scanner;

public class Sokoban {

    // ==================================================
    // 1. ATTRIBUTS
    // ==================================================

    // Grille du niveau actuellement joué
    private char[][] grille;

    // Position du joueur
    private int ligneJoueur;
    private int colonneJoueur;

    // Nombre de mouvements effectués
    private int mouvements;

    // Niveaux disponibles
    private char[][][] niveaux;

    // Numéro du niveau actuellement chargé
    private int niveauActuel;

    // Scanner pour lire les commandes au clavier
    private Scanner scanner = new Scanner(System.in);


    // ==================================================
    // 2. CONSTRUCTEUR
    // ==================================================

    public Sokoban() {

        // TODO : Initialiser les niveaux disponibles

        // TODO : Initialiser la grille

        // TODO : Initialiser la position du joueur

        // TODO : Initialiser le compteur de mouvements

        // TODO : Initialiser le niveau actuel
    }


    // ==================================================
    // 3. POINT D'ENTRÉE DU PROGRAMME
    // ==================================================

    public static void main(String[] args) {

        Sokoban jeu = new Sokoban();

        // TODO : Lancer le menu principal
        jeu.afficherMenu();
    }


    // ==================================================
    // 4. GESTION DU MENU
    // ==================================================

    public void afficherMenu() {

        // TODO : Afficher le menu principal :
        // 1. Nouvelle partie
        // 2. Choisir un niveau
        // 3. Résoudre automatiquement
        // 4. Comparer DFS / BFS
        // 5. Afficher les règles
        // 6. Quitter

        // TODO : Lire et vérifier le choix du joueur

        // TODO : Appeler la méthode correspondant au choix
    }


    // ==================================================
    // 5. GESTION DES NIVEAUX
    // ==================================================

    public void chargerNiveau(int niveau) {

        // TODO : Vérifier que le numéro du niveau est valide

        // TODO : Charger le niveau sélectionné dans la grille

        // TODO : Copier le niveau pour éviter de modifier
        //        directement le modèle original

        // TODO : Rechercher la position initiale du joueur

        // TODO : Initialiser le compteur de mouvements
    }


    // ==================================================
    // 6. AFFICHAGE DE LA GRILLE
    // ==================================================

    public void afficherGrille() {

        // TODO : Parcourir les lignes de la grille

        // TODO : Parcourir les colonnes de chaque ligne

        // TODO : Afficher chaque caractère

        // TODO : Passer à la ligne suivante après chaque rangée

        // TODO : Afficher éventuellement le nombre de mouvements
    }


    // ==================================================
    // 7. DÉROULEMENT D'UNE PARTIE
    // ==================================================

    public void jouer() {

        // TODO : Charger ou vérifier le niveau actuel

        // TODO : Afficher la grille initiale

        // TODO : Répéter les opérations suivantes :
        //        - Lire une commande
        //        - Vérifier la commande
        //        - Déplacer le joueur
        //        - Afficher la grille
        //        - Vérifier la victoire

        // TODO : Permettre au joueur de quitter avec la touche x

        // TODO : Afficher le message de victoire et le nombre
        //        de mouvements lorsque le niveau est terminé
    }


    // ==================================================
    // 8. DÉPLACEMENT DU JOUEUR
    // ==================================================

    public boolean deplacerJoueur(char direction) {

        // TODO : Calculer la nouvelle position du joueur
        //        en fonction de la direction :
        //        z = haut, s = bas, q = gauche, d = droite

        // TODO : Vérifier que la commande est valide

        // TODO : Vérifier que le déplacement est autorisé

        // TODO : Si une caisse est présente, vérifier si elle
        //        peut être poussée

        // TODO : Déplacer le joueur si le mouvement est possible

        // TODO : Mettre à jour le compteur de mouvements

        // TODO : Retourner true si le déplacement a réussi
        //        et false sinon

        return false;
    }


    // ==================================================
    // 9. VALIDATION DU DÉPLACEMENT
    // ==================================================

    public boolean deplacementValide(int ligne, int colonne) {

        // TODO : Vérifier que les coordonnées se trouvent
        //        à l'intérieur des limites de la grille

        // TODO : Vérifier que la case n'est pas un mur

        // TODO : Retourner true si la case est accessible

        return false;
    }


    // ==================================================
    // 10. GESTION DES CAISSES
    // ==================================================

    public boolean peutPousser(
            int ligne, int colonne, char direction) {

        // TODO : Calculer la position située derrière la caisse

        // TODO : Vérifier que cette position se trouve
        //        dans les limites de la grille

        // TODO : Vérifier que la case derrière la caisse
        //        ne contient ni mur ni autre caisse

        // TODO : Retourner true si la caisse peut être poussée

        return false;
    }


    public void deplacerCaisse(
            int ligne, int colonne, char direction) {

        // TODO : Calculer la nouvelle position de la caisse

        // TODO : Vérifier que le déplacement est autorisé

        // TODO : Déplacer la caisse sur la nouvelle case

        // TODO : Préserver les objectifs sous les caisses
        //        et le joueur
    }


    // ==================================================
    // 11. VÉRIFICATION DE LA VICTOIRE
    // ==================================================

    public boolean partieTerminee() {

        // TODO : Parcourir la grille

        // TODO : Vérifier que toutes les caisses sont placées
        //        sur des objectifs

        // TODO : Retourner true si toutes les caisses sont
        //        sur les objectifs, false sinon

        return false;
    }


    // ==================================================
    // 12. RÉSOLUTION AUTOMATIQUE : DFS
    // ==================================================

    public boolean resoudreDFS() {

        // TODO : Construire l'état initial de la recherche

        // TODO : Implémenter une recherche en profondeur
        //        (Depth-First Search)

        // TODO : Explorer les mouvements possibles

        // TODO : Éviter de revisiter les états déjà explorés

        // TODO : Détecter un état gagnant

        // TODO : Conserver le chemin de la solution

        // TODO : Afficher la solution et les statistiques

        // TODO : Retourner true si une solution est trouvée

        return false;
    }


    // ==================================================
    // 13. RÉSOLUTION AUTOMATIQUE : BFS
    // ==================================================

    public boolean resoudreBFS() {

        // TODO : Construire l'état initial de la recherche

        // TODO : Implémenter une file avec des tableaux
        //        pour gérer les états à explorer

        // TODO : Explorer les états par distance croissante

        // TODO : Éviter de revisiter les états déjà explorés

        // TODO : Détecter un état gagnant

        // TODO : Conserver le chemin de la solution

        // TODO : Afficher la solution et les statistiques

        // TODO : Retourner true si une solution est trouvée

        return false;
    }


    // ==================================================
    // 14. COMPARAISON DES ALGORITHMES
    // ==================================================

    public void comparerAlgorithmes() {

        // TODO : Conserver une copie du niveau initial

        // TODO : Exécuter DFS sur une copie de l'état initial

        // TODO : Enregistrer le résultat, le nombre de mouvements
        //        et le nombre d'états explorés

        // TODO : Restaurer l'état initial

        // TODO : Exécuter BFS sur le même niveau

        // TODO : Enregistrer les mêmes statistiques

        // TODO : Afficher les résultats des deux algorithmes

        // TODO : Comparer les longueurs des solutions
        //        et les nombres d'états explorés
    }


    // ==================================================
    // 15. AFFICHAGE DES RÈGLES
    // ==================================================

    public void afficherRegles() {

        // TODO : Expliquer les commandes :
        //        z = haut
        //        s = bas
        //        q = gauche
        //        d = droite
        //        x = quitter

        // TODO : Expliquer les règles de déplacement

        // TODO : Expliquer la condition de victoire
    }


    // ==================================================
    // 16. FONCTIONNALITÉS BONUS (FACULTATIVES)
    // ==================================================

    public void annulerDernierMouvement() {

        // TODO : Conserver l'état précédent de la grille

        // TODO : Restaurer la position précédente du joueur
        //        et des caisses

        // TODO : Mettre à jour le compteur de mouvements
    }


    public void redemarrerNiveau() {

        // TODO : Recharger le niveau actuel

        // TODO : Réinitialiser le compteur de mouvements

        // TODO : Réinitialiser la position du joueur
    }


    public boolean situationBloquee() {

        // TODO : Détecter les situations simples dans lesquelles
        //        une caisse ne peut plus atteindre un objectif

        return false;
    }

}

