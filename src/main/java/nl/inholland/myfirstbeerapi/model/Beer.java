package nl.inholland.myfirstbeerapi.model;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"brand", "model"})})
@Getter
@Setter
@NoArgsConstructor
@Log
public class Beer
{
    @Id
    @SequenceGenerator(name="beer_seq", initialValue = 1000001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq")
    long id;
    String brand;
    String model;
    double price;

    public Beer(long id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    // Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Price
    public double getPrice() { return price; }
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
