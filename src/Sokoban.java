
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // Constantes des elements du jeu
    static final char MUR = '#';
    static final char VIDE = ' ';
    static final char JOUEUR = '@';
    static final char CAISSE = '$';
    static final char OBJECTIF = '.';
    static final char CAISSE_OBJECTIF = '*';

    // Niveaux du jeu
    static final String[][] NIVEAUX = {
        {
            "########",
            "#      #",
            "# .    #",
            "# $    #",
            "#  @   #",
            "#      #",
            "########"
        },
        {
            "########",
            "#      #",
            "#  .   #",
            "#  $   #",
            "#  @   #",
            "#      #",
            "########"
        },
        {
            "########",
            "#      #",
            "#   .  #",
            "#   $  #",
            "#  @   #",
            "#      #",
            "########"
        }
    };

    // Menu principal
    static void menuPrincipal() {

        boolean continuer = true;

        while (continuer) {

            System.out.println("\n================================");
            System.out.println("          SOKOBAN JAVA");
            System.out.println("================================");
            System.out.println("1. Nouvelle partie");
            System.out.println("2. Choisir un niveau");
            System.out.println("3. Resoudre automatiquement");
            System.out.println("4. Comparer DFS / BFS");
            System.out.println("5. Afficher les regles");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");

            String choix = scanner.nextLine().trim();

            switch (choix) {

                case "1":
                    jouer(0);
                    break;

                case "2":
                    choisirNiveau();
                    break;

                case "3":
                    System.out.println("Resolution automatique non implementee.");
                    break;

                case "4":
                    System.out.println("Comparaison DFS / BFS non implementee.");
                    break;

                case "5":
                    afficherRegles();
                    break;

                case "6":
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Choisir un niveau
    static void choisirNiveau() {

        System.out.println("\n=== CHOIX DU NIVEAU ===");

        for (int i = 0; i < NIVEAUX.length; i++) {
            System.out.println((i + 1) + ". Niveau " + (i + 1));
        }

        System.out.print("Votre choix : ");

        try {
            int choix = Integer.parseInt(scanner.nextLine());

            if (choix >= 1 && choix <= NIVEAUX.length) {
                jouer(choix - 1);
            } else {
                System.out.println("Niveau invalide.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre.");
        }
    }

    // Lancer une partie
    static void jouer(int numeroNiveau) {

        String[] niveau = NIVEAUX[numeroNiveau];

        int lignes = niveau.length;
        int colonnes = niveau[0].length();

        // Creation du plateau
        char[][] plateau = new char[lignes][colonnes];

        int joueurX = 0;
        int joueurY = 0;

        int nombreCaisses = 0;
        int nombreObjectifs = 0;

        // Initialisation du plateau
        for (int i = 0; i < lignes; i++) {

            for (int j = 0; j < colonnes; j++) {

                char caractere = niveau[i].charAt(j);

                if (caractere == JOUEUR) {

                    joueurX = i;
                    joueurY = j;
                    plateau[i][j] = VIDE;

                } else {

                    plateau[i][j] = caractere;
                }

                if (caractere == CAISSE) {
                    nombreCaisses++;
                }

                if (caractere == OBJECTIF) {
                    nombreObjectifs++;
                }
            }
        }

        System.out.println("\n=== NIVEAU " + (numeroNiveau + 1) + " ===");

        boolean partieEnCours = true;
        int mouvements = 0;

        while (partieEnCours) {

            afficherPlateau(plateau, joueurX, joueurY);

            System.out.println("\nDeplacements : Z / Q / S / D");
            System.out.println("X : Retour au menu");
            System.out.println("Mouvements : " + mouvements);

            System.out.print("Votre mouvement : ");

            String commande = scanner.nextLine().toLowerCase().trim();

            if (commande.equals("x")) {
                System.out.println("Retour au menu...");
                break;
            }

            // Direction du deplacement
            int dx = 0;
            int dy = 0;

            switch (commande) {

                case "z":
                    dx = -1;
                    break;

                case "s":
                    dx = 1;
                    break;

                case "q":
                    dy = -1;
                    break;

                case "d":
                    dy = 1;
                    break;

                default:
                    System.out.println("Commande invalide.");
                    continue;
            }

            // Nouvelle position
            int nouveauX = joueurX + dx;
            int nouveauY = joueurY + dy;

            // Verification des limites
            if (nouveauX < 0 || nouveauX >= lignes ||
                nouveauY < 0 || nouveauY >= colonnes) {

                System.out.println("Deplacement impossible.");
                continue;
            }

            char destination = plateau[nouveauX][nouveauY];

            // Verification des murs
            if (destination == MUR) {

                System.out.println("Impossible : il y a un mur !");
                continue;
            }

            // Gestion des caisses
            if (destination == CAISSE ||
                destination == CAISSE_OBJECTIF) {

                int caisseX = nouveauX + dx;
                int caisseY = nouveauY + dy;

                // Verification de la position derriere la caisse
                if (caisseX < 0 || caisseX >= lignes ||
                    caisseY < 0 || caisseY >= colonnes) {

                    System.out.println("Impossible de pousser la caisse.");
                    continue;
                }

                char derriere = plateau[caisseX][caisseY];

                // Une caisse ne peut pas traverser un mur
                // ni pousser une autre caisse
                if (derriere != VIDE && derriere != OBJECTIF) {

                    System.out.println("Impossible de pousser la caisse !");
                    continue;
                }

                // Deplacement de la caisse
                if (derriere == OBJECTIF) {
                    plateau[caisseX][caisseY] = CAISSE_OBJECTIF;
                } else {
                    plateau[caisseX][caisseY] = CAISSE;
                }

                // Restauration de l'ancienne position de la caisse
                if (destination == CAISSE_OBJECTIF) {
                    plateau[nouveauX][nouveauY] = OBJECTIF;
                } else {
                    plateau[nouveauX][nouveauY] = VIDE;
                }
            }

            // Deplacement du joueur
            joueurX = nouveauX;
            joueurY = nouveauY;

            mouvements++;

            // Verification de la victoire
            if (verifierVictoire(plateau, nombreCaisses,
                                 nombreObjectifs)) {

                afficherPlateau(plateau, joueurX, joueurY);

                System.out.println("\n================================");
                System.out.println("       BRAVO ! VICTOIRE !");
                System.out.println("================================");
                System.out.println("Nombre de mouvements : " + mouvements);

                partieEnCours = false;
            }
        }
    }

    // Afficher le plateau
    static void afficherPlateau(char[][] plateau,
                                int joueurX, int joueurY) {

        System.out.println();

        for (int i = 0; i < plateau.length; i++) {

            for (int j = 0; j < plateau[i].length; j++) {

                if (i == joueurX && j == joueurY) {
                    System.out.print(JOUEUR);
                } else {
                    System.out.print(plateau[i][j]);
                }
            }

            System.out.println();
        }
    }

    // Verifier si toutes les caisses sont sur les objectifs
    static boolean verifierVictoire(char[][] plateau,
                                    int nombreCaisses,
                                    int nombreObjectifs) {

        int caissesPlacees = 0;

        for (int i = 0; i < plateau.length; i++) {

            for (int j = 0; j < plateau[i].length; j++) {

                if (plateau[i][j] == CAISSE_OBJECTIF) {
                    caissesPlacees++;
                }
            }
        }

        return nombreCaisses == nombreObjectifs &&
               caissesPlacees == nombreCaisses;
    }

    // Afficher les regles
    static void afficherRegles() {

        System.out.println("\n========== REGLES DU SOKOBAN ==========");
        System.out.println("@ : Joueur");
        System.out.println("$ : Caisse");
        System.out.println(". : Objectif");
        System.out.println("* : Caisse sur un objectif");
        System.out.println("# : Mur");
        System.out.println();
        System.out.println("Z : Monter");
        System.out.println("S : Descendre");
        System.out.println("Q : Gauche");
        System.out.println("D : Droite");
        System.out.println("X : Retour au menu");
        System.out.println();
        System.out.println("Le but est de pousser toutes les");
        System.out.println("caisses sur les cases objectifs.");
        System.out.println("Attention : les caisses ne peuvent");
        System.out.println("pas etre tirees.");
        System.out.println("=======================================");
    }

    // Programme principal
    public static void main(String[] args) {

        menuPrincipal();

        scanner.close();
    }
}
