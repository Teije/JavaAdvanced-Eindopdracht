package nl.inholland.myfirstbeerapi.model;

public class Beer
{
    private long id;
    private String brand;
    private String model;
    private double price;

    public Beer() { }

    public Beer(long id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be below zero");
        this.price = price;
    }

    // Convert the beer-object to a single string
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nBeer {");
        sb.append("\nid=").append(id);
        sb.append(", \nbrand='").append(brand).append('\'');
        sb.append(", \nprice=").append(price);
        sb.append(", \nmodel='").append(model).append('\'');
        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }
}
