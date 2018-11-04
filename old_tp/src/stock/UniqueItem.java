package stock;

public abstract class UniqueItem extends Item {

    String name;
    String brand;
    double price;

    UniqueItem(String reference, String name, String brand, double price) {
        super(reference);
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
