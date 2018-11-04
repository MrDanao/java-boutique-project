package commande;

import client.Client;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Commande implements Serializable {

    private int numeroCommande;
    Client c;
    private String date;
    private static int incrementeur;
    CommandePanier panier;
    private double reduction;
    private double fraisPort;

    public Commande(Client c, CommandePanier panier, double reduction, double fraisPort) {
        this.c         = c;
        this.panier    = panier;
        this.reduction = reduction;
        this.fraisPort = fraisPort;
        numeroCommande = incrementeur;
        incrementeur  += 1;
        date = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public int getNumeroClient() {
        return this.c.getNumero();
    }

    public String getDate() {
        return date;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public double getFraisPort() {
        return fraisPort;
    }

    public void setFraisPort(double fraisPort) {
        this.fraisPort = fraisPort;
    }

    public CommandePanier getPanier() {
        return panier;
    }

    public String getClientFullName() {
        return this.c.getPrenom() + " " + this.c.getNom();
    }

    public Client getClient() {
        return c;
    }

}
