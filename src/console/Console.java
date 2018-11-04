package console;

import article.*;
import boutique.*;
import client.*;
import commande.*;
import donnees.*;
import java.io.File;
import java.util.Scanner;

public class Console {

    private Scanner sc;

    public Console() {
        sc = new Scanner(System.in);
    }

    public Scanner getSc() {
        return sc;
    }

    public void run() throws ExceptionSave {
        this.menu(creerBoutique());
    }

    public Boutique creerBoutique() throws ExceptionSave {
        Enregistrement data = new Enregistrement();
        String datapath = "save1";
        File f = new File(datapath);
        Boutique b;

        if(f.exists() && !f.isDirectory()) {
            return b = data.load(datapath);
        } else {
            try {
                System.out.println("Vous allez créer une boutique");
                System.out.println("Nom de la boutique :");
                String nom = this.getSc().nextLine();
                System.out.println("Adresse postale :");
                String adresse = this.getSc().nextLine();
                System.out.println("Numéro de téléphone :");
                String telephone = this.getSc().nextLine();
                System.out.println("Email :");
                String mail = this.getSc().nextLine();
                System.out.println("Charge :");
                Double charge = this.getSc().nextDouble();
                System.out.println("Salaire :");
                Double salaire = this.getSc().nextDouble();
                System.out.println("Loyer :");
                Double loyer = this.getSc().nextDouble();

                //Instanciation de la boutique
                b = new Boutique(nom, adresse, telephone, mail, charge, salaire, loyer);

                // Création des futurs listes de la boutique
                CommandeListe cm = new CommandeListe();
                ClientListe cl = new ClientListe();
                ArticleListe al = new ArticleListe();

                // Ajout des listes à la boutique
                b.setCommandeListe(cm);
                b.setClientListe(cl);
                b.setArticleListe(al);
                return b;
            }
            catch (Exception e) {
                System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
                this.getSc().nextLine();
                return this.creerBoutique();
            }

        }
    }

    public void menu(Boutique b) {
        try {
            System.out.println(" ");
            System.out.println("1) Afficher les clients");
            System.out.println("2) Afficher les commandes de la boutique");
            System.out.println("3) Afficher les commandes d'un client");
            System.out.println("4) Créer un client");
            System.out.println("5) Créer une commande pour un client");
            System.out.println("6) Afficher le stock");
            System.out.println("7) Modifier le stock");
            System.out.println("8) Afficher les caractéristiques de la boutique");
            System.out.println("9) Modifier les caractéristiques de la boutique");
            System.out.println("10) Enregistrer les données de la boutique");
            System.out.println("11) Quitter le programme");
            System.out.println("");
            System.out.println("Votre choix (1-9) :");
            int choix = this.getSc().nextInt();
            switch (choix) {
                case 1:
                    afficherClient(b);
                    break;
                case 2:
                    afficherCommandeAll(b);
                    break;
                case 3:
                    afficherCommandeUnClient(b);
                    break;
                case 4:
                    creerClient(b);
                    break;
                case 5:
                    creerCommande(b);
                    break;
                case 6:
                    afficherStock(b);
                    break;
                case 7:
                    modifierStock(b);
                    break;
                case 8:
                    afficherCaracteristique(b);
                    break;
                case 9:
                    modifierCaracteristique(b);
                    break;
                case 10:
                    try {
                        enregistrer(b);
                    } catch (ExceptionSave exceptionSave) {
                        exceptionSave.printStackTrace();
                    }
                    break;
                case 11:
                    System.exit(0);
                    break;
                default :
                    System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
                    this.getSc().nextLine();
                    this.menu(b);
            }
        }
        catch (Exception e) {
            System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
            this.getSc().nextLine();
            this.menu(b);
        }
    }

    public void afficherClient(Boutique b) {
        System.out.println(" ");
        System.out.println("Clients de la boutique");
        System.out.println("======================");
        b.getClientListe().affiche();
        System.out.println("======================");
        this.menu(b);
    }

    public void afficherCommandeAll(Boutique b) {
        System.out.println(" ");
        System.out.println("Commandes de la boutique");
        System.out.println("========================");
        b.getCommandeListe().affiche();
        System.out.println("========================");
        this.menu(b);
    }

    public void afficherCommandeUnClient(Boutique b) {
        System.out.println(" ");
        System.out.println("Commandes client");
        System.out.println("================");
        b.getClientListe().affiche();
        System.out.println("Entrez le numero de client : ");
        int numero = this.getSc().nextInt();
        System.out.println("=================");
        b.getCommandeListe().affiche(numero);
        System.out.println("=================");
        this.menu(b);
    }

    public void creerClient(Boutique b) {
        System.out.println(" ");
        System.out.println("Création d'un nouveau client");
        System.out.println("============================");
        System.out.println("Prenom du client :");
        this.getSc().nextLine();
        String prenom = this.getSc().nextLine();
        System.out.println("Nom du client :");
        String nom = this.getSc().nextLine();
        System.out.println("Adresse du client : ");
        String adresse = this.getSc().nextLine();
        b.getClientListe().addClient(new Client(prenom, nom, adresse));
        System.out.println("============================");
        this.menu(b);
    }

    public void creerCommande(Boutique b) {
        try {
            System.out.println(" ");
            System.out.println("Création d'une commande");
            System.out.println("=======================");
            // récupérer object client
            System.out.println("Entrez le numéro de client :");
            Client client = b.getClientListe().getClient(this.getSc().nextInt());

            // créer un panier
            CommandePanier panier = new CommandePanier();
            int numeroArticlePanier = 1;
            System.out.println("Choisissez vos produits, saisisez STOP pour finir le panier");

            while (true) {
                System.out.println("Référence de l'article :");
                this.getSc().nextLine();
                String reference = this.getSc().nextLine();
                if (reference.equals("STOP")) {
                    break;
                }
                Article article = b.getArticleListe().getArticle(reference);
                System.out.println("Quantité :");
                int quantité = this.getSc().nextInt();
                panier.addArticle(new CommandePanierArticle(article, quantité));
            }

            System.out.println("Réduction (%) :");
            Double reduction = this.getSc().nextDouble();
            System.out.println("Frais de port :");
            Double fraisPort = this.getSc().nextDouble();

            b.getCommandeListe().addCommande(new Commande(client, panier, reduction, fraisPort));
            System.out.println("=======================");
            this.menu(b);
        }
        catch (Exception e) {
            System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
            this.getSc().nextLine();
            this.creerCommande(b);
        }
    }

    public void afficherStock(Boutique b) {
        System.out.println(" ");
        System.out.println("Stock de la boutique");
        System.out.println("====================");
        b.getArticleListe().affiche();
        System.out.println("====================");
        this.menu(b);
    }

    public void modifierStock(Boutique b) {
        try {
            System.out.println(" ");
            System.out.println("Modification des stocks");
            System.out.println("=======================");
            System.out.println("1) Ajouter un article");
            System.out.println("2) Supprimer un article");
            System.out.println("Votre choix :");
            Integer choix = this.getSc().nextInt();
            if (choix.equals(1)) {
                System.out.println("1) Ajouter un vinyle");
                System.out.println("2) Ajouter un CD");
                choix = this.getSc().nextInt();
                System.out.println("Référence :");
                this.getSc().nextLine();
                String reference = this.getSc().nextLine();
                System.out.println("Nom de l'album :");
                String nomAlbum = this.getSc().nextLine();
                System.out.println("Nom de l'artiste ou groupe :");
                String artiste = this.getSc().nextLine();
                System.out.println("Nom du label :");
                String label = this.getSc().nextLine();
                System.out.println("Nombre de disques :");
                int nbDisque = this.getSc().nextInt();
                System.out.println("Prix :");
                Double prix = this.getSc().nextDouble();
                if (choix.equals(1)) {
                    System.out.println("Taille :");
                    int taille = this.getSc().nextInt();
                    System.out.println("Vitesse :");
                    int vitesse = this.getSc().nextInt();
                    System.out.println("Masse :");
                    int masse = this.getSc().nextInt();
                    System.out.println("Quantité d'albums :");
                    int quantite = this.getSc().nextInt();
                    System.out.println("Réduction sur achat du lot (%) :");
                    double reduc = this.getSc().nextDouble();
                    b.getArticleListe().addArticle(new ArticleLot(reference, (ArticleUnique) new Vinyle(reference, nomAlbum, artiste, label, nbDisque, prix, taille, vitesse, masse), quantite, reduc));
                } else if (choix.equals(2)) {
                    System.out.println("Quantité d'albums :");
                    int quantite = this.getSc().nextInt();
                    System.out.println("Réduction sur achat du lot (%) :");
                    double reduc = this.getSc().nextDouble();
                    b.getArticleListe().addArticle(new ArticleLot(reference, (ArticleUnique) new Cd(reference, nomAlbum, artiste, label, nbDisque, prix), quantite, reduc));
                }
            } else if (choix.equals(2)) {
                System.out.println("suppression");
            }
            System.out.println("=======================");
            this.menu(b);
        }
        catch (Exception e) {
            System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
            this.getSc().nextLine();
            this.modifierStock(b);
        }
    }

    public void afficherCaracteristique(Boutique b) {
        System.out.println(" ");
        System.out.println("Caractéristiques de la boutique");
        System.out.println("===============================");
        System.out.println("Informations de la boutique :");
        System.out.println("\tNom : " + b.getName());
        System.out.println("\tAdresse postale : " + b.getAdressePostale());
        System.out.println("\tNumero de telephone : " + b.getNumeroTelephone());
        System.out.println("\tEmail : " + b.getEmail());
        System.out.println("\tLoyer : " + b.getLoyer() + " €");
        System.out.println("\tSalaire : " + b.getSalaire() + " €");
        System.out.println("\tCharges : " + b.getCharge() + " €");
        //System.out.println("\tChiffre d'affaire : "+b.getC());
        //System.out.println("\tBenefice : "+b.getBenefice()));
        System.out.println("===============================");
        this.menu(b);
    }

    public void modifierCaracteristique(Boutique b) {
        try {
            System.out.println(" ");
            System.out.println("Modification des caractéristiques de la boutique");
            System.out.println("================================================");
            System.out.println("Laissez un champ vide si caractéristique à ne pas modifier.");
            System.out.println("Entrez le nouveau nom de la boutique :");
            this.getSc().nextLine();
            String nom = this.getSc().nextLine();
            System.out.println("Entrez le nouveau Adresse Postale de la boutique :");
            String adresse = this.getSc().nextLine();
            System.out.println("Entrez le nouveau numero de Telephone de la boutique :");
            String numero = this.getSc().nextLine();
            System.out.println("Entrez le nouveau email de la boutique :");
            String email = this.getSc().nextLine();
            System.out.println("Entrez la nouvelle valeur des charges :");
            Double charge = this.getSc().nextDouble();
            this.getSc().nextLine();
            System.out.println("Entrez la nouvelle valeur du salaire :");
            Double salaire = this.getSc().nextDouble();
            this.getSc().nextLine();
            System.out.println("Entrez la nouvelle valeur du loyer :");
            Double loyer = this.getSc().nextDouble();
            this.getSc().nextLine();

            if (!nom.isEmpty()) {
                b.setName(nom);
            }
            if (!adresse.isEmpty()) {
                b.setAdressePostale(adresse);
            }
            if (!numero.isEmpty()) {
                b.setNumeroTelephone(numero);
            }
            if (!email.isEmpty()) {
                b.setEmail(email);
            }
            if (loyer != null) {
                b.setLoyer(loyer);
            }
            if (salaire != null) {
                b.setSalaire(salaire);
            }
            if (charge != null) {
                b.setCharge(charge);
            }
            System.out.println("Changements effectués.");
            System.out.println("================================================");
            this.menu(b);
        }
        catch (Exception e) {
            System.out.println("Valeurs incorrectes, Veuillez Recommencer!");
            this.getSc().nextLine();
            this.modifierCaracteristique(b);
        }
    }
    public void enregistrer(Boutique b) throws ExceptionSave {
        Enregistrement sm = new Enregistrement();
        sm.save(b, "save1");
        System.out.println(" ");
        System.out.println("=====================");
        System.out.println("Boutique enregistrée.");
        System.out.println("=====================");
        this.menu (b);
    }
}
