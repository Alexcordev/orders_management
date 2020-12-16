
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Tp3Gr20 {

    //Messages divers
    public final static String PRESENTATION = "Ceci est un logiciel de démonstration qui permet la gestion des commandes d'une pizzeria.";
    public final static String MSG_ENTER = "Appuyez sur [ENTREE] pour continuer...";
    public final static String MSG_FIN_PROG = "FIN NORMALE DU PROGRAMME.";

    public final static String MSG_TAILLE_PIZZA = "Taille (grandeur) de la pizza : ";
    public final static String MSG_VIANDE = "Choix de viande : ";
    public final static String MSG_EXTRA_VIANDE = "Choix de la viande en extra : ";
    public final static String MSG_CHOIX_GARN = "Choix de la garniture : ";
    public final static String MSG_EXTRA_GARN = "Choix de la garniture en extra : ";
    public final static String MSG_TYPE_CROUTE = "Type de croûte : ";
    public final static String MSG_TAB_COMM_VIDE = "Aucune commande en cours de traitement pour le moment";
    public final static String MSG_TAB_LIV_VIDE = "Impossible de mettre une pizza en livraison car il"
            + " n'y a aucune commande en cours de traitement";
    public final static String MSG_TAB_AFF_LIV = "Aucune commande en cours de livraison pour le moment";

    public final static String MSG_SOLL_MENU = "Faites votre choix, entrez entre 1 et 8 : ";
    public final static String MSG_SOLL_CHOIX_PIZZA = "Entrez le numéro de la pizza : ";
    public final static String MSG_SOLL_CONF_VIANDE = "La viande actuelle de la pizza est : ";
    public final static String MSG_SOLL_MODIF_VIANDE = "Entrez un nouveau choix de viande : ";
    public final static String MSG_SOLL_CONF_GARN = "La garniture actuelle de la pizza est : ";
    public final static String MSG_SOLL_MODIF_GARN = "Entrez un nouveau choix de garniture : ";
    public final static String MSG_SOLL_CONF_GRANDEUR = "La grandeur actuelle de la pizza est : ";
    public final static String MSG_SOLL_MODIF_GRANDEUR = "Entrez un nouveau choix de grandeur : ";
    public final static String MSG_SOLL_CONF_CROUTE = "La croûte actuelle de la pizza est : ";
    public final static String MSG_SOLL_MODIF_CROUTE = "Entrez un nouveau choix de croûte : ";
    public final static String MSG_SOLL_CONF_XV = "L'extra viande actuel de la pizza est : ";
    public final static String MSG_SOLL_MODIF_XV = "Entrez un nouveau choix d'extra viande : ";
    public final static String MSG_SOLL_CONF_XG = "L'extra garniture actuel de la pizza est : ";
    public final static String MSG_SOLL_MODIF_XG = "Entrez un nouveau choix d'extra garniture : ";
    public final static String MSG_SOLL_MODIF = "Voulez-vous modidier la pizza oui ou non (O/N) ? : ";
    public final static String MSG_CONF_MODIFS = "Voulez-vous enregistrer les modifications oui ou non (O/N) ? : ";
    public final static String MSG_CONF_LIVRAISON = "Voulez-vous confirmer la livraison de cette pizza oui ou non (O/N) ? : ";
    public final static String MSG_LIV_CONF = "Livraison confirmée";
    public final static String MSG_LIV_ANNUL = "Livraison annulée";
    public final static String MSG_MODIF_CONF = "Modification confirmée";
    public final static String MSG_MODIF_ANNUL = "Modification annulée";
    public final static String MSG_SOLL_ENV_LIVRAISON = "Voulez-vous envoyer cette pizza en livraison oui ou non (O/N) ? : ";
    public final static String MSG_ENV_LIVRAISON_CONF = "Confirmation de l'envoie de cette pizza en livraison";
    public final static String MSG_ENV_LIVRAISON_ANNUL = "Envoie de la pizza en livraison annulé";
    public final static String MSG_TAB_CONF_VIDE = "Impossible de confirmer une livraison car il"
            + " n'y a aucune livraison en cours";
    public final static String MSG_LIV_VIDE = "Aucune confirmation de livraison pour le moment";

    //Messages d'erreurs
    public final static String MSG_ERR_MENU = "Erreur ! Veuillez saisir un nombre entre 1 et 8";
    public final static String MSG_ERR_SAISIE = "Erreur ! Veuillez saisir un nombre entier";
    public final static String MSG_ERR_CHOIX_DE_VIANDE = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_VIANDE + "et " + Pizza.MAX_VIANDE;
    public final static String MSG_ERR_CHOIX_DE_GARN = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_GARN + "et " + Pizza.MAX_GARN;
    public final static String MSG_ERR_CHOIX_DE_GRANDEUR = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_GRANDEUR + "et " + Pizza.MAX_GRANDEUR;
    public final static String MSG_ERR_CHOIX_DE_CROUTE = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_CROUTE + "et " + Pizza.MAX_CROUTE;
    public final static String MSG_ERR_CHOIX_X_VIANDE = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_VIANDE + "et " + Pizza.MAX_VIANDE;
    public final static String MSG_ERR_CHOIX_X_GARN = "Erreur ! Veuillez choisir entre "
            + Pizza.MIN_GARN + "et " + Pizza.MAX_GARN;
    public final static String MSG_ERR_CONF_MODIFS = "Erreur! Veuillez entrer oui ou non (O/N) : ";

    public final static int MENU_MIN = 1;
    public final static int MENU_MAX = 8;


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
        boolean estAttrapee;
        Scanner monScanner = new Scanner(System.in);

        if (min >= 0 && max >= min) {
            System.out.print(msgSoll);
            do {
                try {
                    estAttrapee = false;
                    entier = monScanner.nextInt();
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
                    estAttrapee = true;
                    System.out.println(MSG_ERR_SAISIE);
                }
            } while (estAttrapee);

            monScanner.reset();
        }
        return entierValide;
    }

    public static int validerMenu() {
        int choix;

        do {
            choix = validerEntier(MSG_SOLL_MENU, MSG_ERR_MENU, MENU_MIN, MENU_MAX);

        } while (choix < 1 || choix > 8);

        return choix;
    }

    public static void commanderPizza(Pizza[] tab) {
        int grandeur;
        int viande;
        int garniture;
        int croute;
        int extraV;
        int extraG;
        Pizza[] nouvTab;
        System.out.println();
        System.out.println("VIANDES DISPONIBLES");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
            System.out.print(i + " " + " = " + " " + Pizza.viande(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        viande = validerEntier(MSG_VIANDE, MSG_ERR_CHOIX_DE_VIANDE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        while (viande < Pizza.MIN_VIANDE || viande > Pizza.MAX_VIANDE) {
            viande = validerEntier(MSG_VIANDE, MSG_ERR_CHOIX_DE_VIANDE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        }
        System.out.println();
        System.out.println("GARNITURES DISPONIBLES");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
            System.out.print(i + " " + " = " + " " + Pizza.garniture(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        garniture = validerEntier(MSG_CHOIX_GARN, MSG_ERR_CHOIX_DE_GARN, Pizza.MIN_GARN, Pizza.MAX_GARN);
        while (garniture < Pizza.MIN_GARN || garniture > Pizza.MAX_GARN) {
            garniture = validerEntier(MSG_CHOIX_GARN, MSG_ERR_CHOIX_DE_GARN, Pizza.MIN_GARN, Pizza.MAX_GARN);
        }

        System.out.println();
        System.out.println("GRANDEURS DISPONIBLES");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_GRANDEUR; i <= Pizza.MAX_GRANDEUR; i++) {
            System.out.print(i + " = " + " " + Pizza.grandeur(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        grandeur = validerEntier(MSG_TAILLE_PIZZA, MSG_ERR_CHOIX_DE_GRANDEUR, Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);
        while (grandeur < Pizza.MIN_GRANDEUR || grandeur > Pizza.MAX_GRANDEUR) {
            grandeur = validerEntier(MSG_TAILLE_PIZZA, MSG_ERR_CHOIX_DE_GRANDEUR, Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);
        }

        System.out.println();
        System.out.println("TYPES DE CROÛTE");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_CROUTE; i <= Pizza.MAX_CROUTE; i++) {
            System.out.print(i + " = " + " " + Pizza.croute(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        croute = validerEntier(MSG_TYPE_CROUTE, MSG_ERR_CHOIX_DE_CROUTE, Pizza.MIN_CROUTE, Pizza.MAX_CROUTE);
        while (croute < Pizza.MIN_CROUTE || croute > Pizza.MAX_CROUTE) {
            croute = validerEntier(MSG_TYPE_CROUTE, MSG_ERR_CHOIX_DE_CROUTE, Pizza.MIN_CROUTE, Pizza.MAX_CROUTE);
        }

        System.out.println();
        System.out.println("EXTRA VIANDE");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
            System.out.print(i + " = " + " " + Pizza.viande(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        extraV = validerEntier(MSG_EXTRA_VIANDE, MSG_ERR_CHOIX_X_VIANDE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        while (extraV < Pizza.MIN_VIANDE || extraV > Pizza.MAX_VIANDE) {
            extraV = validerEntier(MSG_EXTRA_VIANDE, MSG_ERR_CHOIX_X_VIANDE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        }

        System.out.println();
        System.out.println("EXTRA GARNITURE");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
            System.out.print(i + " " + " = " + " " + Pizza.garniture(i) + "\n");
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        extraG = validerEntier(MSG_EXTRA_GARN, MSG_ERR_CHOIX_X_GARN, Pizza.MIN_GARN, Pizza.MAX_GARN);
        while (extraG < Pizza.MIN_GARN || extraG > Pizza.MAX_GARN) {
            extraG = validerEntier(MSG_VIANDE, MSG_ERR_CHOIX_X_GARN, Pizza.MIN_GARN, Pizza.MAX_GARN);
        }

        Pizza pizza = new Pizza(viande, garniture, grandeur, croute, extraV, extraG);

        ajouter(tab, pizza);
        nouvTab = augmenterTailleTableauCinq(tab);
        ajouter(nouvTab, pizza);

        System.out.println();
        System.out.println("COMMANDE AJOUTÉE");
        System.out.println();
    }

    public static void afficherTableauPizza(Pizza[] tab, String msgTabVide) {
        String mess = "";
        if (tab != null) {

            for (int i = 0; i <= tab.length - 1; i++) {

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
        boolean ajouter;

        for (int i = 0; i < tab.length && !inseree; i++) {
            ajouter = tab[i] == null;

            if (ajouter) {
                tab[i] = pizza;
                inseree = true;
            }
        }
    }

    public static Pizza[] augmenterTailleTableauCinq(Pizza[] tab) {

        Pizza[] tableauDeTravail;
        Pizza[] nouveauTab;

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

    public static Pizza obtenirPizza(Pizza pizza, Pizza[] tab) {

        boolean trouve;
        for (int i = 0; i < tab.length; i++) {
            trouve = tab[i] != null && tab[i].getNumero() == (pizza.getNumero());
            if (trouve) {
                tab[i] = pizza;
            }
        }

        return pizza;
    }

    public static void modifierPizza(Pizza[] tab) {

        char reponse;
        int entierValide;
        int nouvViande;
        int nouvGarn;
        int nouvGrandeur;
        int nouvCroute;
        int nouvExtraViande;
        int nouvExtraGarn;
        boolean estVide;
        boolean resultat;
        boolean charEstPasValide;

        estVide = tab[0] == null;

        if (estVide) {
            System.out.println(MSG_TAB_COMM_VIDE);
        }

        if (!estVide) {
            entierValide = validerEntier(MSG_SOLL_CHOIX_PIZZA, MSG_ERR_SAISIE, 0, tab.length - 1);
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] != null) {
                    resultat = tab[i].getNumero() == entierValide;

                    if (resultat) {

                        Pizza pizza = tab[i];
                        System.out.println(pizza);
                        System.out.println();

                        reponse = validerCar(MSG_SOLL_MODIF, MSG_ERR_CONF_MODIFS);
                        charEstPasValide = reponse == 'o' || reponse == 'O';

                        if (charEstPasValide) {
                            System.out.println();
                            System.out.println("VIANDES DISPONIBLES");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
                                System.out.print(i + " = " + " " + Pizza.viande(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_VIANDE + pizza.getViande() + " (" + Pizza.viande(pizza.getViande()) + ")");
                            nouvViande = validerEntier(MSG_SOLL_MODIF_VIANDE, MSG_ERR_SAISIE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);

                            System.out.println();
                            System.out.println("GARNITURES DISPONIBLES");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
                                System.out.print(i + " = " + " " + Pizza.garniture(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_GARN + pizza.getGarniture() + " (" + Pizza.garniture(pizza.getGarniture()) + ")");
                            nouvGarn = validerEntier(MSG_SOLL_MODIF_GARN, MSG_ERR_SAISIE, Pizza.MIN_GARN, Pizza.MAX_GARN);

                            System.out.println();
                            System.out.println("GRANDEURS DISPONIBLES");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_GRANDEUR; i <= Pizza.MAX_GRANDEUR; i++) {
                                System.out.print(i + " = " + " " + Pizza.grandeur(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_GRANDEUR + pizza.getGrandeur() + " (" + Pizza.grandeur(pizza.getGrandeur()) + ")");
                            nouvGrandeur = validerEntier(MSG_SOLL_MODIF_GRANDEUR, MSG_ERR_SAISIE, Pizza.MIN_GRANDEUR, Pizza.MAX_GRANDEUR);

                            System.out.println();
                            System.out.println("CROÛTES DISPONIBLES");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_CROUTE; i <= Pizza.MAX_CROUTE; i++) {
                                System.out.print(i + " = " + " " + Pizza.croute(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_CROUTE + pizza.getCroute() + " (" + Pizza.croute(pizza.getCroute()) + ")");
                            nouvCroute = validerEntier(MSG_SOLL_MODIF_CROUTE, MSG_ERR_SAISIE, Pizza.MIN_CROUTE, Pizza.MAX_CROUTE);

                            System.out.println();
                            System.out.println("EXTRA VIANDE");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
                                System.out.print(i + " = " + " " + Pizza.viande(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_XV + pizza.getExtraViande() + " (" + Pizza.viande(pizza.getExtraViande()) + ")");
                            nouvExtraViande = validerEntier(MSG_SOLL_MODIF_XV, MSG_ERR_SAISIE, Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);

                            System.out.println();
                            System.out.println("EXTRA GARNITURE");
                            System.out.println("-------------------------------------------------------------------------");
                            for (i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
                                System.out.print(i + " = " + " " + Pizza.garniture(i) + "\n");
                            }
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println(MSG_SOLL_CONF_XG + pizza.getExtraGarn() + " (" + Pizza.garniture(pizza.getExtraGarn()) + ")");
                            nouvExtraGarn = validerEntier(MSG_SOLL_MODIF_XG, MSG_ERR_SAISIE, Pizza.MIN_GARN, Pizza.MAX_GARN);


                            reponse = validerCar(MSG_CONF_MODIFS, MSG_ERR_CONF_MODIFS);
                            charEstPasValide = reponse == 'o' || reponse == 'O';

                            if (charEstPasValide) {
                                pizza.setViande(nouvViande);
                                pizza.setGarniture(nouvGarn);
                                pizza.setGrandeur(nouvGrandeur);
                                pizza.setCroute(nouvCroute);
                                pizza.setExtraViande(nouvExtraViande);
                                pizza.setExtraGarniture(nouvExtraGarn);

                                System.out.println(obtenirPizza(pizza, tab));
                                System.out.println(MSG_MODIF_CONF);

                            }
                        }
                        if (!charEstPasValide & reponse == 'n' || reponse == 'N') {
                            System.out.println(MSG_MODIF_ANNUL);
                            return;
                        }
                    }
                }
            }
        }
    }


    private static void supprimerPizza(Pizza[] tab, int entree) {

        boolean trouve = false;

        do {
            for (int i = 0; i < tab.length - 1; i++) {
                trouve = tab[i] != null && tab[i].getNumero() == (entree);
                if (trouve) {
                    tab[i] = null;
                }
            }
            tab = supprimerLesNulls(tab);
        } while (trouve);


    }

    private static Pizza[] supprimerLesNulls(Pizza[] tab) {

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

    public static void sauvegarder(String fichier, Pizza[] tab) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(fichier));
        if (tab[0] == null) {
            outputWriter.write("Aucune données disponibles");
            outputWriter.newLine();
        }
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] != null) {
                outputWriter.write(String.valueOf(tab[i]));
                outputWriter.newLine();
            }
        }

        outputWriter.flush();
        outputWriter.close();
    }

    public static void statuerSurLivraison(Pizza[] tab, Pizza[] tab1, String messSollChoix, String messTabVide,
                                           String messErrMenu, String messSollLiv, String messConf,
                                           String messAnnul) {
        char reponse = ' ';
        int entierValide;
        Pizza[] nouvTab;
        boolean estVide;
        boolean estIdentique;
        boolean charValide;

        estVide = tab[0] == null;
        if (estVide) {
            System.out.println(messTabVide);
        }
        if (!estVide) {
            entierValide = validerEntier(messSollChoix, messErrMenu, 0, tab.length - 1);
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] != null) {
                    estIdentique = tab[i].getNumero() == entierValide;

                    if (estIdentique) {
                        System.out.println(tab[i]);
                        System.out.println();
                        reponse = validerCar(messSollLiv, messErrMenu);

                        charValide = reponse == 'o' || reponse == 'O' || reponse == 'n' || reponse == 'N';
                        if (charValide & reponse == 'o' || reponse == 'O') {
                            ajouter(tab1, tab[i]);
                            nouvTab = augmenterTailleTableauCinq(tab1);
                            ajouter(nouvTab, tab[i]);
                            supprimerPizza(tab, entierValide);
                            System.out.println(messConf);

                        }
                        if (charValide & reponse == 'n' || reponse == 'N') {
                            System.out.println(messAnnul);
                        }

                    } /*else if (tab[i].getNumero() != entierValide & reponse != 'o' && reponse != 'O' && reponse != 'n' && reponse != 'N') {
                        System.out.println(" Impossible de confirmer la livraison de cette pizza car elle n'est "
                                + "pas dans les commandes en cours de livraison.");
                        return;
                    }*/
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Pizza[] commandesEnCours = new Pizza[10];
        Pizza[] pizzaEnLivraison = new Pizza[10];
        Pizza[] livraisonConfirmee = new Pizza[10];

        Pizza[] tabComm;
        Pizza[] tabLivraison;
        Pizza[] tabConfirmee;


        int choixMenu;
        presenterLogiciel();

        //boucle principale du programme
        do {
            afficherMenu();
            choixMenu = validerMenu();
            System.out.println();

            switch (choixMenu) {

                case 1:
                    System.out.println();
                    System.out.println("---------------------");
                    System.out.println("PLACER UNE COMMANDE");
                    System.out.println("---------------------");
                    System.out.println();
                    tabComm = augmenterTailleTableauCinq(commandesEnCours);
                    commandesEnCours = tabComm;
                    commanderPizza(commandesEnCours);
                    System.out.println();
                    pause();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("COMMANDE EN COURS DE TRAITEMENT");
                    System.out.println("--------------------------------");
                    System.out.println();
                    afficherTableauPizza(commandesEnCours, MSG_TAB_COMM_VIDE);
                    System.out.println();
                    pause();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.println("MODIFICATION D'UNE COMMANDE EN COURS");
                    System.out.println("------------------------------------");
                    System.out.println();
                    modifierPizza(commandesEnCours);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("---------------------------------");
                    System.out.println("PLACER UNE COMMANDE EN LIVRAISON");
                    System.out.println("---------------------------------");
                    System.out.println();
                    tabLivraison = augmenterTailleTableauCinq(pizzaEnLivraison);
                    pizzaEnLivraison = tabLivraison;
                    statuerSurLivraison(commandesEnCours, pizzaEnLivraison, MSG_SOLL_CHOIX_PIZZA, MSG_TAB_LIV_VIDE,
                            MSG_ERR_CONF_MODIFS, MSG_SOLL_ENV_LIVRAISON, MSG_ENV_LIVRAISON_CONF, MSG_ENV_LIVRAISON_ANNUL);

                    break;
                case 5:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("COMMANDE EN COURS DE LIVRAISON");
                    System.out.println("--------------------------------");
                    System.out.println();
                    afficherTableauPizza(pizzaEnLivraison, MSG_TAB_AFF_LIV);
                    System.out.println();
                    pause();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("--------------------------------------");
                    System.out.println("CONFIRMER LA LIVRAISON D'UNE COMMANDE");
                    System.out.println("--------------------------------------");
                    System.out.println();
                    tabConfirmee = augmenterTailleTableauCinq(livraisonConfirmee);
                    livraisonConfirmee = tabConfirmee;
                    statuerSurLivraison(pizzaEnLivraison, livraisonConfirmee, MSG_SOLL_CHOIX_PIZZA, MSG_TAB_CONF_VIDE,
                            MSG_ERR_CONF_MODIFS, MSG_CONF_LIVRAISON, MSG_LIV_CONF, MSG_LIV_ANNUL);
                    break;

                case 7:
                    System.out.println();
                    System.out.println("----------------------");
                    System.out.println("LIVRAISONS CONFIRMÉES");
                    System.out.println("----------------------");
                    System.out.println();
                    afficherTableauPizza(livraisonConfirmee, MSG_LIV_VIDE);
                    System.out.println();
                    pause();

                case 8:
                    sauvegarder("commandesEnCours.txt", commandesEnCours);
                    sauvegarder("livraisonsEnCours.txt", pizzaEnLivraison);
                    sauvegarder("livraisonsConfirmees.txt", livraisonConfirmee);

                    break;
            }

        } while (!(choixMenu == (MENU_MAX)));

        afficherFinProg();
    }

}


