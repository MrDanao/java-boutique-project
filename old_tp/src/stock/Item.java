package stock;

public abstract class Item {

    String reference;

    Item(String reference) {
        this.reference = reference;
    }

    public abstract String getName();
    public abstract String getBrand();
    public abstract double getPrice();

    public String getReference() {
        return reference;
    }

    /*public boolean equals(Object o) {
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass().equals(this.getClass())) {
            return false;
        }
    }*/

}
