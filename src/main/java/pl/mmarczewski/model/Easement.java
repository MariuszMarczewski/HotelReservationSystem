package pl.mmarczewski.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Easement {

    @Id
    @GeneratedValue(generator = "easementSeq")
    @SequenceGenerator(name = "easementSeq", sequenceName = "easement_seq", allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal pricePln;

    public Easement() {
    }

    public Easement(Long id, String name, BigDecimal pricePln) {
        this.id = id;
        this.name = name;
        this.pricePln = pricePln;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePln() {
        return pricePln;
    }

    public void setPricePln(BigDecimal pricePln) {
        this.pricePln = pricePln;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Easement easement = (Easement) o;
        return Objects.equals(id, easement.id) &&
                Objects.equals(name, easement.name) &&
                Objects.equals(pricePln, easement.pricePln);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pricePln);
    }


}
