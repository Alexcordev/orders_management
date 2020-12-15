
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Tp3Gr20 {

    //Messages divers
    public final static String PRESENTATION = "Ceci est un logiciel de démonstration qui permet la gestion des commandes d'une pizzeria.";
    public final static String MSG_ENTER = "Appuyez sur [ENTREE] pour continuer...";
    public final static String MSG_FIN_PROG = "FIN NORMALE DU PROGRAMME.";
    public final static String MSG_SOLL_MENU = "Entrez votre choix : ";
    public final static String MSG_ERR_MENU = "Erreur ! Veuillez saisir un nombre entre 1 et 8";
    public final static String MSG_ERR_SAISIE = "Erreur ! Veuillez saisir nombre entier";
    public final static String MSG_TAILLE_PIZZA = "Taille (grandeur) de la pizza : ";
    public final static String MSG_VIANDE = "Choix de viande : ";
    public final static String MSG_EXTRA_VIANDE = "Choix de la viande en extra : ";
    public final static String MSG_CHOIX_GARN = "Choix de garniture :  ";
    public final static String MSG_EXTRA_GARN = "Choix de la garniture en extra :";
    public final static String MSG_TYPE_CROUTE = "Type de croûte ";
    public final static String MSG_TAB_VIDE = "Aucune pizza en commande pour le moment";
    public final static int MENU_MAX = 8;
    public final static int ID_PIZZA_MIN = 1;


    public static void afficherMenu() {
        System.out.println("\n\nMENU PRINCIPAL\n\n"
                + "1 – Commander une pizza\n"
                + "2 – Afficher les commandes en cours de traitements\n"
                + "3 – Modifier une pizza (commande en cours de traitement seulement)\n"
                + "4 – Envoyer une pizza a la livraison\n"
                + "5 – Afficher les livraisons en cours\n"
                + "6 – Confirmer une livraison\n"
                + "7 – Afficher les pizzas qui ont ete livrees\n"
                + "8 – Quitter le programme\n");
    }

    public static void pause() {
        Scanner monScanner = new Scanner(System.in);
        System.out.print(MSG_ENTER);
        monScanner.nextLine();
        System.out.println();

    }

    public static void presenterLogiciel() {
        System.out.println(PRESENTATION + "\n\n");
        pause();
    }

    public static void afficherFinProg() {
        System.out.println("\n\n" + MSG_FIN_PROG);
    }

    public static int validerEntier(String msgSoll, String msgErr,
                                    int min, int max) {
        boolean estPasValide;
        int entier;
        int entierValide = -1;
        boolean wenttocatch;
        Scanner monScanner = new Scanner(System.in);

        if (min >= 0 && max >= min) {
                System.out.print(msgSoll);
            do {
                try {
                    wenttocatch = false;
                    entier = monScanner.nextInt(); // sc is an object of scanner class
                    estPasValide = entier < min || entier > max;
                    if (estPasValide) {
                        System.out.println(msgErr);
                    } else {
                        entierValide = entier;
                    }
                    while (estPasValide) {
                        System.out.print(msgSoll);
                        entier = monScanner.nextInt();
                        estPasValide = entier < min || entier > max;
                        if (estPasValide) {
                            System.out.println(msgErr);
                        } else {
                            entierValide = entier;
                        }
                    }
                } catch (InputMismatchException e) {
                    monScanner.next();
                    wenttocatch = true;
                    System.out.println(MSG_ERR_SAISIE);
                }
            } while (wenttocatch);
               // entier = monScanner.nextInt();



            monScanner.reset();
        }
        return entierValide;
    }

    public static int validerMenu() {
        int choix;

        do {
            choix = validerEntier(MSG_SOLL_MENU, MSG_ERR_MENU, 1, 8);

        } while (choix < 1 || choix > 8);


        return choix;
    }
    public static Pizza modifierIngredients(Pizza pizza) {
        int nouvViande;
        int nouvGarn;
        int nouvGrandeur;
        int nouvCroute;
        int nouvExtraViande;
        int nouvExtraGarn;

        System.out.println("La viande de la pizza est " + pizza.getViande() + " (" + Pizza.viande(pizza.getViande()) + ")");
        nouvViande = validerEntier("Entrez un nouveau choix de viande :", MSG_ERR_SAISIE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        pizza.setViande(nouvViande);
        System.out.println("La garniture de la pizza est " + pizza.getGarniture() + " (" + Pizza.garniture(pizza.getGarniture()) + ")");
        nouvGarn = validerEntier("Entrez une nouvelle garniture :", MSG_ERR_SAISIE, Pizza.MIN_GARN, Pizza.MAX_GARN);
        pizza.setGarniture(nouvGarn);
        System.out.println("La taille de la pizza est " + pizza.getGrandeur() + " (" + Pizza.grandeur(pizza.getGrandeur()) + ")");
        nouvGrandeur = validerEntier("Entrez une nouvelle grandeur :", MSG_ERR_SAISIE, Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);
        pizza.setGrandeur(nouvGrandeur);
        System.out.println("La croute de la pizza est " + pizza.getCroute() + " (" + Pizza.croute(pizza.getCroute()) + ")");
        nouvCroute = validerEntier("Entrez une nouvelle croute :", MSG_ERR_SAISIE, Pizza.MIN_CROUTE, Pizza.MAX_CROUTE);
        pizza.setCroute(nouvCroute);
        System.out.println("L'extra viande de la pizza est " + pizza.getExtraViande() + " (" + Pizza.viande(pizza.getExtraViande()) + ")");
        nouvExtraViande = validerEntier("Entrez un nouvel extra viande :", MSG_ERR_SAISIE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        pizza.setExtraViande(nouvExtraViande);
        System.out.println("L'extra garniture de la pizza est " + pizza.getExtraGarn() + " (" + Pizza.garniture(pizza.getExtraGarn()) + ")");
        nouvExtraGarn = validerEntier("Entrez un nouvel extra garniture :", MSG_ERR_SAISIE, Pizza.MIN_GARN, Pizza.MAX_GARN);
        pizza.setExtraGarniture(nouvExtraGarn);

    return pizza;
    }

    public static void commanderPizza(Pizza [] tab) {
        int grandeur;
        int viande;

        System.out.println();
        System.out.println("GRANDEURS DISPONIBLES");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_GRANDEUR; i <= Pizza.MAX_GRANDEUR; i++) {
            System.out.print(i + " = " + " " + Pizza.grandeur(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        grandeur = validerEntier(MSG_TAILLE_PIZZA, "Erreur! Saisir entre 0 et 4", Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);
        while (grandeur < Pizza.MIN_GRANDEUR || grandeur > Pizza.MAX_GRANDEUR) {
            grandeur = validerEntier(MSG_TAILLE_PIZZA, "Erreur! Saisir entre 0 et 4", Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);
        }
        System.out.println();
        System.out.println("VIANDES DISPONIBLES");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
            System.out.print(i + " " + " = " + " " + Pizza.viande(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        viande = validerEntier(MSG_VIANDE, "Erreur! Saisir entre 0 et 4", Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        while (viande < Pizza.MIN_VIANDE || viande > Pizza.MAX_VIANDE) {
            viande = validerEntier(MSG_VIANDE, "Erreur! Saisir entre 0 et 4", Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        }

        Pizza pizza = new Pizza(viande, 0, grandeur, 0, 0, 0);

        boolean estPlein;
        boolean inseree = false;
        Pizza [] nouvTab;

        ajouter(tab,pizza);
        for (int i = 0; i < tab.length && !inseree; i++) {

            estPlein = i == tab.length -1;

            if (estPlein) {
                nouvTab = augmenterTailleTableauCinq(tab);
                ajouter(nouvTab,pizza);
                tab = nouvTab;
                inseree = true;
            }
        }
        System.out.println();
        System.out.println("COMMANDE AJOUTÉE");
        System.out.println();
    }

    public static void afficherTableauPizza(Pizza[] tab, String msgTabVide) {
        String mess = "";
        if (tab != null) {

            for (int i = 0; i <= tab.length -1; i++) {

                if (tab[i] != null) {
                    System.out.println(tab[i]);
                } else if (tab[0] == null) {
                    mess = msgTabVide;
                }
            }
            System.out.println(mess);
        }
    }

    public static void ajouter(Pizza[] tab, Pizza pizza) {

        boolean inseree = false;

        for (int i = 0; i < tab.length && !inseree; i++) {

            inseree = tab[i] == null;

            if (inseree) {
                tab[i] = pizza;
                inseree = true;

            }
        }
    }

    public static Pizza[] augmenterTailleTableauCinq(Pizza[] tab) {

        Pizza [] tableauDeTravail;
        Pizza [] nouveauTab;
            if (tab == null) {
                tableauDeTravail = new Pizza[5];
            } else {
                tableauDeTravail = new Pizza[tab.length + 5];
                for (int i = 0; i < tab.length; i++) {
                    tableauDeTravail[i] = tab[i];
                }
            }
            nouveauTab = tableauDeTravail;

        return nouveauTab;
    }

            public static void confirmerSauvegarde(Pizza [] tab, Pizza pizza, String msgSoll,
                                                   String msgErr, String messConf, String messAnnul) {
            int reponse;
                reponse = validerCar(msgSoll, msgErr);
                if (reponse == 'o' || reponse == 'O') {
                    System.out.println(obtenirPizza(pizza, tab));
                    System.out.println(messConf);
                } else if (reponse == 'n' || reponse == 'N') {
                    System.out.println(messAnnul);

                }
            }

    public static Pizza obtenirPizza(Pizza pizza, Pizza [] tab) {

        boolean trouve;
        for (int i = 0; i < tab.length; i++) {
            trouve = tab[i] != null && tab[i].getNumero() == (pizza.getNumero());
            if (trouve) {
                tab[i] = pizza;
            }
            if (i == tab.length - 1) {
                System.out.println("Cette pizza n'existe pas");
            }
        }

        return pizza;
    }

    public static void modifierPizza(Pizza[] tab) {
        char reponse;
        int entierValide;
        boolean estVide;
        boolean resultat = false;

        estVide = tab[0] == null;
        if (estVide) {
            System.out.println("tableau est vide");
        }

        if (!estVide) {
            do {
                entierValide = validerEntier("Entrez le numéro de la pizza : ", MSG_ERR_MENU, 0, tab.length - 1);
                for (int i = 0; i < tab.length; i++) {

                    resultat = i + 1 == entierValide;

                    if (resultat) {

                        System.out.println(tab[i]);
                        System.out.println();
                        reponse = validerCar("Voulez-vous modidier : ", MSG_ERR_MENU);

                        if (reponse == 'o' || reponse == 'O') {
                            tab[i] = modifierIngredients(tab[i]);
                            confirmerSauvegarde(tab, tab[i], "Enregistrer les modifications (O/N) ? : ", "Erreur",
                                    "Modification effectuée", "Modification annulée");

                        } else if (reponse == 'n' || reponse == 'N') {
                            System.out.println("Modification annulée");
                        }
                    }
                }

            } while (resultat);
        }
    }

    private static void supprimerPizza(Pizza[] tab, int entree) {

        boolean trouve = false;

        do {
             for (int i = 0; i < tab.length -1; i++) {
                trouve = tab[i] != null && tab[i].getNumero() == (entree);
                if (trouve) {
                    tab[i] = null;
                }
               }
            tab = supprimerLesNulls(tab);
        } while (trouve);


    }
    private static Pizza[] supprimerLesNulls(Pizza [] tab) {

        int i = 0;
        int j = tab.length - 1;
        while (i <= j) {
            if (tab[j] == null) {
                --j;
            } else if (tab[i] != null) {
                ++i;
            } else {
                tab[i] = tab[j];
                tab[j] = null;
                ++i;
                --j;
            }
        }
        return Arrays.copyOfRange(tab, 0, i);
    }

    public static char validerCar(String msgSoll, String msgErr) {
        char car = ' ';
        char carVal = ' ';
        boolean estValide;

        Scanner monScanner = new Scanner(System.in);
        do {
            System.out.println(msgSoll);

            car = monScanner.next().charAt(0);

            estValide = car == 'o' || car == 'O' || car == 'n' || car == 'N';

            if (estValide) {
                carVal = car;
            } else {
                System.out.println(msgErr);
            }

        } while (!estValide);

        monScanner.reset();

        return carVal;
    }

    public static void sauvegarder(String fichier,Pizza [] tab) throws IOException {

            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter(fichier));
            if (tab[0] == null) {
                outputWriter.write("Aucune données disponibles");
                outputWriter.newLine();
            }
                for (int i = 0; i < tab.length -1; i++) {
                    if (tab[i] != null) {
                        outputWriter.write(String.valueOf(tab[i]));
                        outputWriter.newLine();
                    }
                }

        outputWriter.flush();
        outputWriter.close();
    }

    public static void envoyerPizzaALivraison(Pizza[] tab, Pizza[] tab1) {
        char reponse = ' ';
        int entierValide;
         boolean estVide;
        boolean estIdentique = false;

        estVide = tab[0] == null;
        if (estVide) {
            System.out.println("Impossible de d'envoyer une pizza a la livraison car il n'y a aucune commande en cours");
        }
        if (!estVide) {
            entierValide = validerEntier("Entrez le numéro de la pizza : ", MSG_ERR_MENU, 0, tab.length - 1);
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] != null) {
                    estIdentique = tab[i].getNumero() == entierValide;

                    if (estIdentique) {
                        System.out.println(tab[i]);

                        reponse = validerCar("Voulez-vous envoyer cette pizza à la livraison : ", MSG_ERR_MENU);
                        if (reponse == 'o' || reponse == 'O') {
                            ajouter(tab1, tab[i]);
                            supprimerPizza(tab, entierValide);
                            System.out.println("Envoie à la livraison confirmée");

                        } else if (reponse == 'n' || reponse == 'N') {
                            System.out.println("Envoie en livraison annulée");
                        }
                    }
                }
            }
        }
        if (!estIdentique) {
            System.out.println(" Impossible de livrer cette pizza car cette pizza n'est pas dans les commandes"
                                   +" en cours de traitement.");
        } else {
            System.out.println();
        }
    }

    public static void confirmerLivraison(Pizza[] tab, Pizza[] tab1) {

        char reponse;
        int entierValide;
        boolean estVide;
        boolean estIdentique = false;

        estVide = tab[0] == null;
        if (estVide) {
            System.out.println(" Impossible de"
                    + " confirmer une livraison car il n'y a aucune livraison en cours");
        }
        if (!estVide) {
            entierValide = validerEntier("Entrez le numéro de la pizza : ", MSG_ERR_MENU, 0, tab.length - 1);
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] != null) {
                    estIdentique = tab[i].getNumero() == entierValide;

                    if (estIdentique) {
                        System.out.println(tab[i]);
                        System.out.println();
                        reponse = validerCar("Voulez-vous confirmer la livraison de cette pizza : ", MSG_ERR_MENU);

                        if (reponse == 'o' || reponse == 'O') {
                            ajouter(tab1, tab[i]);
                            supprimerPizza(tab, entierValide);
                            System.out.println("Livraison confirmée");

                        } else if (reponse == 'n' || reponse == 'N') {
                            System.out.println("Confirmation de livraison annulée");

                        }
                    }
                }
            }
        }
        if (!estIdentique) {
            System.out.println("Impossible de confirmer la livraison car cette pizza n'est pas en cours de livraison.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Pizza [] commandesEnCours = new Pizza[10];
        Pizza [] pizzaEnLivraison = new Pizza[10];
        Pizza [] livraisonConfirmee = new Pizza[10];
        boolean inseree = false;
        boolean estPlein;
        Pizza [] nouvTab;

        for (int i = 0; i < commandesEnCours.length && !inseree; i++) {

            estPlein = i == commandesEnCours.length -1;

            if (estPlein) {
                nouvTab = augmenterTailleTableauCinq(commandesEnCours);
                commandesEnCours = nouvTab;
                inseree = true;

            }
        }

        int choixMenu;    //choix au menu
        //presentation du logiciel
        presenterLogiciel();

        //boucle principale du programme
        do {
            //obtenir choix menu
            afficherMenu();
            choixMenu = validerMenu();
            System.out.println();

            //executer choix menu
            switch (choixMenu) {

                //Commander une pizza
                case 1:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("PLACER UNE COMMANDE");
                    System.out.println("------------------------------");
                    System.out.println();
                    inseree = false;
                    for (int i = 0; i < commandesEnCours.length && !inseree; i++) {

                        estPlein = i == commandesEnCours.length -1;

                        if (estPlein) {
                            nouvTab = augmenterTailleTableauCinq(commandesEnCours);
                            commandesEnCours = nouvTab;
                            inseree = true;

                        }
                    }
                    commanderPizza(commandesEnCours);
                    System.out.println();
                    pause();
                    break;

                //Afficher les commandes en cours de traitements
                case 2:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("COMMANDE EN COURS DE TRAITEMENT");
                    System.out.println("------------------------------");
                    System.out.println();
                    afficherTableauPizza(commandesEnCours, MSG_TAB_VIDE);
                    System.out.println();
                    pause();
                    break;

                //Afficher tous les contacts
                case 3:
                    modifierPizza(commandesEnCours);
                    break;
                case 4:

                    envoyerPizzaALivraison(commandesEnCours, pizzaEnLivraison);

                    break;
                case 5:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("COMMANDE EN COURS DE LIVRAISON");
                    System.out.println("------------------------------");
                    System.out.println();
                    afficherTableauPizza(pizzaEnLivraison, "Aucune commande en cours de livraison");
                    System.out.println();
                    pause();
                    break;

                case 6:

                    confirmerLivraison(pizzaEnLivraison, livraisonConfirmee);
                    break;

                case 7:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("LIVRAISONS CONFIRMÉES");
                    System.out.println("------------------------------");
                    System.out.println();
                    afficherTableauPizza(livraisonConfirmee, "Aucune livraison de confirmée pour le moment");
                    System.out.println();
                    pause();

                    case 8:
                    sauvegarder("commandesEnCours.txt",commandesEnCours);
                    sauvegarder("livraisonsEnCours.txt",pizzaEnLivraison);
                    sauvegarder("livraisonsConfirmees.txt",livraisonConfirmee);

                    break;
            }

        } while (!(choixMenu == (MENU_MAX)));

        afficherFinProg();
    }

}


