package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {

    @Column(name = "taux")
    private Double taux;

    public LivretA() {
        super();
    }

    public LivretA(String numero, double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
