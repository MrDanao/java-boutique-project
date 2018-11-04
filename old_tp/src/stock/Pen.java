package stock;

import utils.Color;

public class Pen extends UniqueItem {

    //enum Color {BLACK, BLUE, GREEN, RED};
    Color color;

    Pen(String reference, String name, String brand, double price, Color color) {
        super(reference, name, brand, price);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "Pen " +
                "{\"reference\": " + reference
                + ", \"name\": " + name
                + ", \"brand\": " + brand
                + ", \"price\": " + price
                + ", \"color\": " + color
                + "}";
    }
}
