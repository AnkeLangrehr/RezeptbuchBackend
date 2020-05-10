package Services;

import Entities.RezeptEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RecipeService {

    public void createrecipe() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RezeptEntity rezeptEntity = new RezeptEntity();
        rezeptEntity.setId(5);
        rezeptEntity.setBeschreibung("abc");
        rezeptEntity.setName("abc");
        em.persist(rezeptEntity);
        em.getTransaction().commit();
    }
    public List<RezeptEntity> getAllRecipes(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<RezeptEntity> rezeptEntities= em.createQuery("SELECT e FROM Entities.RezeptEntity e", RezeptEntity.class).getResultList();
        em.getTransaction().commit();

        System.out.println(rezeptEntities);
        return rezeptEntities;
    }


}