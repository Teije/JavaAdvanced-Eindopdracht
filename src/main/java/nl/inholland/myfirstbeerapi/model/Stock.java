package nl.inholland.myfirstbeerapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 50000001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="guitar_id")
    private Beer beer;

    public Stock() { }

    public Stock(int quantity, Beer beer) {
        this.quantity = quantity;
        this.beer = beer;
    }

    // Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Beer
    public Beer getBeer() {
        return beer;
    }
    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", guitar=").append(beer);
        sb.append('}');
        return sb.toString();
    }
}