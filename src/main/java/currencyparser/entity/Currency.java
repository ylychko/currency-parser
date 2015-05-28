package currencyparser.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by eyevlyc on 12/17/2014.
 */
@Table (name="currency")
@Entity
public class Currency{
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private int dcode;

    @Column(unique = true, nullable = false)
    private String lcode;

    private String name;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)

    private Set<Rate> rates;

    public String getLcode() {
        return lcode;
    }

    public String getName() {
        return name;
    }

    public void setLcode(String lcode) {
        this.lcode = lcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDcode() {
        return dcode;
    }

    public void setDcode(int dcode) {
        this.dcode = dcode;
    }

    public Set<Rate> getRates() {
        return rates;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", dcode=" + dcode +
                ", lcode='" + lcode + '\'' +
                ", name='" + name + '\'' +
                ", rates=" + rates +
                '}';
    }
}
