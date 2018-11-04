package stock;

public class Paper extends UniqueItem {

    int weight;

    Paper(String reference, String name, String brand, double price, int weight) {
        super(reference, name, brand, price);
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Paper " +
                "{\"reference\": " + reference
                + ", \"name\": " + name
                + ", \"brand\": " + brand
                + ", \"price\": " + price
                + ", \"weight\": " + weight
                + "}";
    }
}
