package commande;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class CommandeListe implements Serializable {

    ArrayList<Commande> commandeListe;

    public CommandeListe() {
        commandeListe = new ArrayList();
    }

    public boolean addCommande(Commande cm) {
        commandeListe.add(cm);
        return true;
    }

    public boolean rmCommande(Commande cm) {
        commandeListe.remove (cm);
        return true;
    }

    public void affiche() {
        Commande c = null;
        Iterator<Commande> it = commandeListe.iterator();
        while(it.hasNext()) {
            c = it.next();
            System.out.println("Commande : " + c.getNumeroCommande());
            System.out.println("Pour le client : " + c.getClientFullName());
            System.out.println("Articles de la commande :");
            c.getPanier().affiche();
            c = null;
        }
    }

    // surcharge de méthode
    public void affiche(int cl) {
        Commande c = null;
        Iterator<Commande> it = commandeListe.iterator();
        while(it.hasNext()) {
            c = it.next();
            if(c.getNumeroClient() == cl) {
                System.out.println("Commande : " + c.getNumeroCommande());
                System.out.println("Pour le client : " + c.getClientFullName());
                System.out.println("Articles de la commande :");
                c.getPanier().affiche();
            }
            c = null;
        }
    }
}
