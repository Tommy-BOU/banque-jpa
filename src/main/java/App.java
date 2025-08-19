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

            LivretA newLivretA = new LivretA("123414", 1000, 1.5);
            Compte newCompte = new Compte("123274", 1000);

            Operation newOperation = new Operation(LocalDate.now(), 1000, "Cadeau");
            Virement newVirement = new Virement(LocalDate.now(), 1000, "Virement", "Paul Dupont" );

            newLivretA.addOperation(newOperation);
            newCompte.addOperation(newVirement);

            client.addCompte(newCompte);
            client.addCompte(newLivretA);
//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------


            Client client1 = new Client("Dujean", "Pons", LocalDate.now(), newBanque);
            Adresse newAdresse1 = new Adresse(10, "rue Jean Paul II", 66666, "Vatican City");
            client1.setAdresse(newAdresse1);

            Compte newCompte1 = new Compte("1234561", 1000000000);
            AssuranceVie newAssuranceVie = new AssuranceVie("1234", 1000, LocalDate.now(), 1.5);

            Virement newVirement1 = new Virement(LocalDate.now(), 1000, "Virement", "Tamere");
            Virement newVirement2 = new Virement(LocalDate.now(), 10000, "Virement2", "Tamere");

            newCompte1.addOperation(newVirement1);
            newCompte1.addOperation(newVirement2);

            client1.addCompte(newCompte1);
            client1.addCompte(newAssuranceVie);
//------------------------------------------------------------------------------------------------------------------------------------------------------
            newBanque.addClient(client);
            newBanque.addClient(client1);


//BANQUE------------------------------------------------------------------------------------------------------------------------------------------------------

            Banque newBanque1 = new Banque("Crédit Lyonnais");
//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------

            Client client2 = new Client("Jeandu", "Pierre", LocalDate.now(), newBanque);
            Adresse newAdresse2 = new Adresse(100, "rue Tamere", 66666, "Paris");
            client2.setAdresse(newAdresse2);

            Compte newCompte2 = new Compte("1242561", 1000000000);

            Operation newOperation2 = new Operation(LocalDate.now(), 1000, "Cadeau");
            newCompte2.addOperation(newOperation2);

            client2.addCompte(newCompte2);
//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
            Client client3 = new Client("Dupierre", "Jacques", LocalDate.now(),  newBanque);
            Adresse newAdresse3 = new Adresse(6054, "Avenue des prés", 05, "Trifouilli les oies");
            client3.setAdresse(newAdresse3);

            Compte newCompte3 = new Compte("987645", 1000000000);
            LivretA newLivretA1 = new LivretA("331231254", 1000, 1.5);

            Virement newVirement3 = new Virement(LocalDate.now(), 1000, "Virement", "Paul Dupont");

            newCompte3.addOperation(newVirement3);

            client3.addCompte(newCompte3);
            client3.addCompte(newLivretA1);

            newBanque1.addClient(client2);
            newBanque1.addClient(client3);

//BANQUE------------------------------------------------------------------------------------------------------------------------------------------------------

            Banque newBanque2 = new Banque("BNP Paribas");
//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
            Client client4 = new Client("Dupierre", "Jacques", LocalDate.now(),  newBanque);
            Adresse newAdresse4 = new Adresse(6054, "Avenue des oies", 75, "Trifouilli les prés");
            client4.setAdresse(newAdresse4);

//CLIENT------------------------------------------------------------------------------------------------------------------------------------------------------
            Client client5 = new Client("Dupierre", "Jacques", LocalDate.now(),  newBanque);
            Adresse newAdresse5 = new Adresse(6054, "Avenue des gemmes", 598, "Tartaros les pré");
            client5.setAdresse(newAdresse5);

//------------------------------------------------------------------------------------------------------------------------------------------------------

            Compte newCompte4 = new Compte("987645", 1000000000);

            Operation newOperation4 = new Operation(LocalDate.now(), 1000, "Cadeau");
            Virement newVirement4 = new Virement(LocalDate.now(), 1000, "Virement", "Paul Dupont");

            newCompte4.addOperation(newOperation4);
            newCompte4.addOperation(newVirement4);

            client4.addCompte(newCompte4);
            client5.addCompte(newCompte4);

            newBanque2.addClient(client4);
            newBanque2.addClient(client5);

//------------------------------------------------------------------------------------------------------------------------------------------------------
            em.persist(newBanque);
            em.persist(newBanque1);
            em.persist(newBanque2);

            em.getTransaction().commit();
        }
    }
}
