package commande;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class CommandePanier implements Serializable {

    ArrayList<CommandePanierArticle> commandePanier;

    public CommandePanier() {
        commandePanier = new ArrayList();
    }

    public boolean addArticle(CommandePanierArticle article) {
        commandePanier.add(article);
        return true;
    }

    public boolean rmArticle(CommandePanierArticle article) {
        commandePanier.remove(article);
        return true;
    }

    public void affiche() {
        CommandePanierArticle a = null;
        Iterator<CommandePanierArticle> it = commandePanier.iterator();
        while(it.hasNext()) {
            a = it.next();
            System.out.println(a.toString());
            a = null;
        }
    }
}
