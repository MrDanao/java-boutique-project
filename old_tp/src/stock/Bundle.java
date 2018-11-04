package stock;

public class Bundle extends Item {

    Item item;
    int quantity;
    double discount;

    Bundle(String reference, Item item, int quantity, double discount) {
        super(reference);
        this.item = item;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double getPrice() {
        return this.quantity*item.getPrice()*((100-this.discount)/100);
    }

    public String getBrand() {
        return item.getBrand();
    }

    public String getName() {
        return "Lot de " + this.quantity + " " + item.getName();
    }

    public String toString() {
        return "Bundle " +
                "{\"reference\": " + reference
                + ", \"item\": " + getName()
                + ", \"quantity\": " + quantity
                + ", \"discount\": " + discount + " %"
                + ", \"price\": " + getPrice()
                + "}";
    }

}
