
import Entities.RezeptEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        em = emf.createEntityManager();

        getAllRecipes();

    }

    private static void createrecipe() {
        em.getTransaction().begin();
        RezeptEntity rezeptEntity = new RezeptEntity();
        rezeptEntity.setId(8);
        rezeptEntity.setBeschreibung("abc");
        rezeptEntity.setName("abc");
        em.persist(rezeptEntity);
        em.getTransaction().commit();
    }

    private static void getAllRecipes() {
        em.getTransaction().begin();
        List<RezeptEntity> rezeptEntities = em.createQuery("SELECT e FROM Entities.RezeptEntity e", RezeptEntity.class).getResultList();
        em.getTransaction().commit();
        System.out.println(rezeptEntities);
    }
}

