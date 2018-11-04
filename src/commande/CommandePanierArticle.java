package commande;

import article.Article;

import java.io.Serializable;

public class CommandePanierArticle implements Serializable {

    Article a;
    int quantite;

    public CommandePanierArticle(Article a, int quantite) {
        this.a = a;
        this.quantite = quantite;
    }

    public String getArticle() {
        return this.a.toString();
    }

    public int getQuantite() {
        return quantite;
    }

    public String toString() {
        return "Quantité : " + quantite + " : " + this.a.toString();
    }

}
