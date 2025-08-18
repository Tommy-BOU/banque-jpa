import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
                EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();


            em.getTransaction().commit();
        }
    }
}
