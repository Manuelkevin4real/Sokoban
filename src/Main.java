public class Main { 

    // Constantes des éléments du jeu
    static final char MUR = '#';
    static final char VIDE = ' ';
    static final char JOUEUR = '@';
    static final char CAISSE = '$';
    static final char OBJECTIF = '.';
    static final char CAISSE_OBJECTIF = '*';


        // Affichage du menu tant que l'utilisateur ne choisit pas de quitter
    static void menuPrincipal() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n================================");
            System.out.println("         SOKOBAN JAVA");
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
                    jouer();
                    break;
                case "2":
                    choisirNiveau();
                    break;
                case "3":
                    resoudreMenu();
                    break;
                case "4":
                    comparerAlgorithmes();
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

    // Niveaux du jeu
    static final String[][] NIVEAUX = {
        { 
        // aide pour le niveau 1

        //niveau 1
            "########",
            "#      #",
            "# .    #",
            "# $    #",
            "#  @   #",
            "#      #",
            "########"
        },
        {
        //niveau 2
            "########",
            "#      #",
            "# .    #",
            "# $    #",
            "#  @   #",
            "#      #",
            "########"

        },
        {
        //niveau 3
            "########",
            "#      #",
            "# .    #",
            "# $    #",
            "#  @   #",
            "#      #",
            "########"
        }
    
    };

    public static void main(String[] args) {
        //recup du niveau 1, 2, 3
        String[] premierNiveau = NIVEAUX[0];
        String[] deuxiemeNiveau = NIVEAUX[1];
        String[] troisiemeNiveau = NIVEAUX[2];

        //Parcours du niveau et affichage
        for (int i = 0; i < premierNiveau.length; i++) {
            //System.out.println(premierNiveau[i]);
            //System.out.println(deuxiemeNiveau[i]);
            System.out.println(troisiemeNiveau[i]);

        }
    }
}
