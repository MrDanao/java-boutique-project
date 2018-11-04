package stock;

import utils.Color;

public class StockDemo {

    public static void main(String[] args) {
        // lot de ramettes de papiers
        Item ramette1 = new Paper("PEP001", "Ramette de papier 80g/m²", "BIC", 15, 80);
        Item stylo1 = new Pen("PEN001", "Stylo couleur bleu", "BIC", 0.5, Color.BLUE);
        Item b1 = new Bundle("BUN001", (UniqueItem)ramette1, 20, 10);
        Item b2 = new Bundle("BUN002", (UniqueItem)stylo1, 200, 5);

        System.out.println(ramette1);
        System.out.println(stylo1);
        System.out.println(b1);
        System.out.println(b2);
    }

}
