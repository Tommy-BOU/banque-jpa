package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private double solde;

    @ManyToMany(mappedBy = "comptes",cascade = CascadeType.ALL)
    private Set<Client> clients;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private Set<Operation> operations;

    {
        clients = new HashSet<>();
        operations = new HashSet<>();
    }

    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        if (client != null) {
            client.addCompte(this);
        }
    }

    public void removeClient(Client client) {
        if (client != null) {
            client.removeCompte(this);
        }
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation operation) {
        if (operation != null) {
            operation.setCompte(this);
        }
    }

    public void removeOperation(Operation operation) {
        if (operation != null) {
            operation.setCompte(null);
        }
    }

}
