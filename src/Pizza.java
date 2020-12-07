public class Pizza {
    /**
     * I N F 1 1 2 0
     * <p>
     * Classe servant a faire des pizzas.
     * <p>
     * Les informations a conserver sur une pizza sont les suivantes:
     * <p>
     * Le type de viande, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon),
     * 4 (viande fumee),  5 (poulet), 6 (saucisses italiennes).
     * La valeur par defaut est 1.
     * <p>
     * Le type de garniture, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives),
     * 5 (ananas).  La valeur par defaut est 2.
     * <p>
     * La grandeur, un entier.
     * Les valeurs possibles sont�:  0  (Extra petite), 1 (Petite), 2 (Moyenne), 3 (Grande),
     * 4 (Jumbo). La valeur par defaut est 2.
     * <p>
     * Un extra de viande, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon), 4 (viande fumee),
     * 5 (poulet), 6 (saucisses italiennes). La valeur par defaut est 0.
     * <p>
     * Une garniture en extra, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives),
     * 5 (ananas).   La valeur par defaut est 0.
     * <p>
     * Un type de cro�te, un entier.
     * Les valeurs possibles sont�:  0 (Ordinaire), 1 (Mince), 2 (Trois Cereales), 3 (Epaisse), 4 (Fromage).
     * La valeur par defaut est 0.
     * <p>
     * Un numero d�identification distinct (nombre entier positif).
     * Les numeros debutent a 1 et sont consecutifs. Chaque pizza a un numero DIFFERENT qui lui est propre.
     * Les numeros sont generes automatiquement par la classe Pizza.
     */

    //Constantes de classe privees
    private static final String[] GARNITURES = {"Aucune", "champignons", "piments", "oignons", "olives", "ananas"};
    private static final String[] VIANDES = {"Aucune", "pepperoni", "bacon", "jambon", "viande fumee", "poulet", "saucisses italiennes"};
    private static final String[] GRANDEURS = {"Extra petite", "Petite", "Moyenne", "Grande", "Jumbo"};
    private static final String[] CROUTES = {"Ordinaire", "Mince", "Trois Cereales", "Epaisse", "Fromage"};


    //Constantes de classe publiques
    public static final int VIANDE_DEFAUT = 1;
    public static final int GARNITURE_DEFAUT = 2;
    public static final int EXTRA_DEFAUT = 0;
    public static final int GRANDEUR_DEFAUT = 2;
    public static final int CROUTE_DEFAUT = 0;

    public static final int MIN_GARN = 0;
    public static final int MAX_GARN = GARNITURES.length - 1;
    public static final int MIN_VIANDE = 0;
    public static final int MAX_VIANDE = VIANDES.length - 1;
    public static final int MIN_GRANDEUR = 0;
    public static final int MAX_GRANDEUR = GRANDEURS.length - 1;
    public static final int MIN_CROUTE = 0;
    public static final int MAX_CROUTE = CROUTES.length - 1;

    //Variables d'instance
    private int uneViande = 0;
    private int uneGarniture = 0;
    private int uneGrandeur = 0;
    private int uneCroute = 0;
    private int unExtraViande = 0;
    private int unExtraGarn = 0;
    private static int count = 1;


    // Variable de CLASSE pour generer le numero de pizza
    //Pour usage INTERNE seulement.
    private int numero = 0;

    //Methodes de classe

    ////////////////////////////////////////////////////////////////////////////
    // Retourne la chaine de caractere corrrespondant au numero de garniture
    // recu en parametre. Si le no ne correspond pas a une garniture existante,
    // la methode retourne la chaine vide.
    ////////////////////////////////////////////////////////////////////////////

    public static String garniture(int no) {

        String chaine = "";
        if (no >= MIN_GARN & no <= MAX_GARN) {
            for (int i = 0; i <= MAX_GARN; i++) {
                if (i == no) {
                    chaine = GARNITURES[i].trim();
                }
            }
        } else {
            chaine = "";
        }

        return chaine; //Pour que ca compile...
    }


    /////////////////////////////////////////////////////////////////////////
    // Retourne la chaine de caractere corrrespondant au numero de viande
    // recu en parametre. Si le no ne correspond pas a une viande existante,
    // la methode retourne la chaine vide.
    /////////////////////////////////////////////////////////////////////////
    public static String viande(int no) {
        String chaine = "";

        if (no >= MIN_VIANDE & no <= MAX_VIANDE) {
            for (int i = 0; i <= MAX_VIANDE; i++) {
                if (i == no) {
                    chaine = VIANDES[i].trim();
                }
            }
        } else {
            chaine = "";
        }

        return chaine;
    }


    //////////////////////////////////////////////////////////////////////////
    // Retourne la chaine de caractere corrrespondant au numero de grandeur
    // recu en parametre. Si le no ne correspond pas a une grandeur existante,
    // la methode retourne la chaine vide.
    //////////////////////////////////////////////////////////////////////////
    public static String grandeur(int no) {

        String chaine = "";
        if (no >= MIN_GRANDEUR & no <= MAX_GRANDEUR) {
            for (int i = 0; i <= MAX_GRANDEUR; i++) {
                if ( i == no) {
                    chaine = GRANDEURS[i].trim();
                }
            }
        } else {
            chaine = "";
        }

        return chaine; //Pour que ca compile...
    }


    ////////////////////////////////////////////////////////////////////////
    // Retourne la chaine de caractere corrrespondant au numero de croute
    // recu en parametre. Si le no ne correspond pas a une croute existante,
    // la methode retourne la chaine vide.
    ////////////////////////////////////////////////////////////////////////
    public static String croute(int no) {

        String chaine = "";
        if (no >= MIN_CROUTE & no <= MAX_CROUTE) {
            for (int i = 0; i <= MAX_CROUTE; i++) {
                if (i == no) {
                    chaine = CROUTES[i].trim();
                }
            }
        } else {
            chaine = "";
        }

        return chaine; //Pour que ca compile...
    }


    /////////////////
    /////////////////
    //CONSTRUCTEURS//
    /////////////////
    /////////////////


    /////////////////////////////////////////////////////////////////
    // Cree une pizza avec tous les attributs aux valeurs par defaut
    /////////////////////////////////////////////////////////////////

    public Pizza() {

        uneViande = VIANDE_DEFAUT;
        uneGarniture = GARNITURE_DEFAUT;
        uneGrandeur = GRANDEUR_DEFAUT;
        uneCroute = CROUTE_DEFAUT;
        unExtraViande = EXTRA_DEFAUT;
        unExtraGarn = EXTRA_DEFAUT;
        numero += count++;
    }


    /////////////////////////////////////////////////////////////////
    // Cree une pizza avec AUCUN extra et les informations en
    // parametre.
    // Lorsqu'un parametre est invalide, l'attribut correspondant est
    // mis a la valeur par defaut.
    /////////////////////////////////////////////////////////////////
    public Pizza(int viande, int garniture, int grandeur, int croute) {

        if (viande < MIN_VIANDE || viande > MAX_VIANDE) {
            setViande(VIANDE_DEFAUT);
        } else if (garniture < MIN_GARN || garniture > MAX_GRANDEUR) {
            setGarniture(GARNITURE_DEFAUT);
        } else if (grandeur < MIN_GRANDEUR || grandeur > MAX_GRANDEUR) {
            setGrandeur(GRANDEUR_DEFAUT);
        } else if (croute < MIN_CROUTE || croute > MAX_CROUTE) {
            setCroute(CROUTE_DEFAUT);
        } else {
            uneViande = viande;
            uneGarniture = garniture;
            uneGrandeur = grandeur;
            uneCroute = croute;
            numero += count++;

        }
    }


    /////////////////////////////////////////////////////////////////
    // Cree une pizza avec les informations en parametre.
    // Lorsqu'un parametre est invalide, l'attribut correspondant est
    // mis a la valeur par defaut.
    /////////////////////////////////////////////////////////////////
    public Pizza(int viande, int garniture, int grandeur, int croute, int extraViande, int extraGarniture) {

        if (viande < MIN_VIANDE || viande > MAX_VIANDE) {
            setViande(VIANDE_DEFAUT);
        } else if (garniture < MIN_GARN || garniture > MAX_GRANDEUR) {
            setGarniture(GARNITURE_DEFAUT);
        } else if (grandeur < MIN_GRANDEUR || grandeur > MAX_GRANDEUR) {
            setGrandeur(GRANDEUR_DEFAUT);
        } else if (croute < MIN_CROUTE || croute > MAX_CROUTE) {
            setCroute(CROUTE_DEFAUT);
        } else if (extraViande < MIN_VIANDE || extraViande > MAX_VIANDE) {
            setExtraViande(EXTRA_DEFAUT);
        } else if (extraGarniture < MIN_GARN || extraGarniture > MAX_GARN) {
            setExtraGarniture(EXTRA_DEFAUT);
        } else {

            uneViande = viande;
            uneGarniture = garniture;
            uneGrandeur = grandeur;
            uneCroute = croute;
            unExtraViande = extraViande;
            unExtraGarn = extraGarniture;
            numero += count++;
        }
    }



    /////////////////////////////
    //SEPT ACCESSEURS (GETTERS)//
    // a ajouter...            //
    /////////////////////////////

    public int getNumero() {

        return numero;
    }

    public int getUneViande() {

        return uneViande;
    }

    public int getUneGarniture() {

        return uneGarniture;
    }

    public int getUneGrandeur() {

        return uneGrandeur;
    }

    public int getUneCroute() {

        return uneCroute;
    }

    public int getUnExtraViande() {

        return unExtraViande;
    }

    public int getUnExtraGarn() {

        return unExtraGarn;
    }


    ///////////////////////////
    //MODIFICATEURS (SETTERS)//
    ///////////////////////////


    //////////////////////////////////////////////////////
    //  Modifie la croute de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////

    public void setCroute(int c) {
        boolean estValide;
        for (int i = 0; i <= MAX_CROUTE; i++) {
            estValide = i == c;
            if (estValide) {
                uneCroute = c;
            }
        }
    }


    //////////////////////////////////////////////////////
    //  Modifie la grandeur de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////
    public void setGrandeur(int g) {
        boolean estValide;
        for (int i = 0; i <= MAX_GRANDEUR; i++) {
            estValide = i == g;
            if (estValide) {
                uneGrandeur = g;
            }
        }
    }


    //////////////////////////////////////////////////////
    //  Modifie la viande de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////
    public void setViande(int v) {
        boolean estValide;
        for (int i = 0; i <= MAX_VIANDE; i++) {
            estValide = i == v;
            if (estValide) {
                uneViande = v;
            }
        }
    }


    //////////////////////////////////////////////////////
    //  Modifie la garniture de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////
    public void setGarniture(int g) {
        boolean estValide;
        for (int i = 0; i <= MAX_GARN; i++) {
            estValide = i == g;
            if (estValide) {
                uneGarniture = g;
            }
        }
    }

    //////////////////////////////////////////////////////
    //  Modifie la viande en extra de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////
    public void setExtraViande(int eV) {
        boolean estValide;
        for (int i = 0; i <= MAX_VIANDE; i++) {
            estValide = i == eV;
            if (estValide) {
                unExtraViande = eV;
            }
        }
    }


    //////////////////////////////////////////////////////
    //  Modifie la garniture en extra de la pizza.
    //  Si la valeur recu en parametre ne fait pas
    //  partie des valeurs permises, aucune modification
    //  n'est effectuee et aucun message d'erreur n'est
    //  affiche.
    //////////////////////////////////////////////////////
    public void setExtraGarniture(int eG) {
        boolean estValide;
        for (int i = 0; i <= MAX_GARN; i++) {
            estValide = i == eG;
            if (estValide) {
                unExtraGarn = eG;
            }
        }
    }


    /////////////////////////////////////
    /// METHODE UTILITAIRE D'INSTANCE ///
    /////////////////////////////////////


    //////////////////////////////////////////////////////
    //  Retourne une chaine de caracteres contenant les
    //  caracteristiques de la pizza.
    //  Pour chacune des informations, on doit mettre une
    //  description de l'information, suivie de sa valeur.
    //  Chaque information doit �tre sur une ligne
    //  differente (utilisez \n la ou cela s'applique).
    //////////////////////////////////////////////////////

    public String toString() {

        return "Pizza numéro : " + getNumero() + "\n" + "Type de viande : " + Pizza.viande(getUneViande()) + " (" + getUneViande() + ")" + "\n"
                + "Type de garniture : " + Pizza.garniture(getUneGarniture()) + " (" + getUneGarniture() + ")" + "\n"
                + "Taille : " + Pizza.grandeur(getUneGrandeur()) + " (" + getUneGrandeur() + ")" + "\n"
                + "Type de croute : " + Pizza.croute(getUneCroute()) + " (" + getUneCroute() + ")" + "\n"
                + "Extra viande : " + Pizza.viande(getUnExtraViande()) + " (" + getUnExtraViande() + ")" +"\n"
                + "Extra garniture : " + Pizza.garniture(getUnExtraGarn()) + " (" + getUnExtraGarn() + ")" +"\n"
                + "------------------------------" + "\n";
    }


} // Pizza


