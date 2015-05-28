package currencyparser.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by eyevlyc on 1/22/2015.
 */
@Entity
@Table(name = "rates", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"currency_id", "date"})
})
public class Rate {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int units;

    @Column(nullable = false)
    private double rate;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", units=" + units +
                ", rate=" + rate +
                ", date=" + date +
                ", currency=" + currency.getLcode() +
                '}';
    }
}
