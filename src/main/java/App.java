import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
                EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
//BANQUE------------------------------------------------------------------------------------------------------------------------------------------------------
            Banque newBanque = new Banque("Crédit Agricole");

//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
            Client client = new Client("Dupont", "Paul", LocalDate.now(), newBanque);
            Adresse newAdresse = new Adresse(1, "rue de la paix", 75000, "Paris");
            client.setAdresse(newAdresse);

            LivretA newLivretA = new LivretA("1234", 1000, 1.5);
            Compte newCompte = new Compte("1234", 1000);

            client.addCompte(newCompte);
            client.addCompte(newLivretA);
//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------


            Client client1 = new Client("Dujean", "Pons", LocalDate.now(), newBanque);
            Adresse newAdresse1 = new Adresse(10, "rue Jean Paul II", 66666, "Vatican City");
            client1.setAdresse(newAdresse1);

            Compte newCompte1 = new Compte("1234561", 1000000000);
            AssuranceVie newAssuranceVie = new AssuranceVie("1234", 1000, LocalDate.now(), 1.5);
            client1.addCompte(newCompte1);
            client1.addCompte(newAssuranceVie);
//------------------------------------------------------------------------------------------------------------------------------------------------------
            newBanque.addClient(client);
            newBanque.addClient(client1);

//BANQUE------------------------------------------------------------------------------------------------------------------------------------------------------

//            Banque newBanque1 = new Banque("Crédit Lyonnais", null);
////CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
//
//            Client client2 = new Client("Jeandu", "Pierre", LocalDate.now(), null, null, newBanque);
////CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
//            Client client3 = new Client("Dupierre", "Jacques", LocalDate.now(), null, null, newBanque);
////BANQUE------------------------------------------------------------------------------------------------------------------------------------------------------
//
//            Banque newBanque2 = new Banque("BNP Paribas", null);
////CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
//            Client client4 = new Client("Dupierre", "Jacques", LocalDate.now(), null, null, newBanque);
////BANQUE-----------------------------------------------------------------------------------------------------------------------------------------------------
//
//            Banque newBanque3 = new Banque("Crédit Mutuel", null);
////CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
//            Client client5 = new Client("Dupierre", "Jacques", LocalDate.now(), null, null, newBanque);
////------------------------------------------------------------------------------------------------------------------------------------------------------
//
            newBanque.addClient(client);
//            newBanque1.addClient(client1);
//            newBanque1.addClient(client2);
//            newBanque1.addClient(client3);

            em.persist(newBanque);
//            em.persist(newBanque1);
//            em.persist(newBanque2);
//            em.persist(newBanque3);

            em.getTransaction().commit();
        }
    }
}
