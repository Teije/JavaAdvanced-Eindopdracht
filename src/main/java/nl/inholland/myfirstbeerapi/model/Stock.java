package nl.inholland.myfirstbeerapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

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
@Getter
@Setter
@NoArgsConstructor
@Log
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 50000001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="guitar_id")
    private Beer beer;

    public Stock(Beer beer, int quantity) {
        this.quantity = quantity;
        this.beer = beer;
    }

    // Id
    public void setId(long id)
    {
        log.warning("Method setId called, but ignored.\nId will be set automatically...");
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", beer=").append(beer);
        sb.append('}');
        return sb.toString();
    }
}