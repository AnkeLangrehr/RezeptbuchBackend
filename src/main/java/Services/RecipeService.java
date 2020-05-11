package Services;

import Entities.RezeptEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import java.util.List;

public class RecipeService {

    public void createRecipe(int id, String beschreibung, String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        RezeptEntity rezeptEntity = new RezeptEntity();
        rezeptEntity.setId(id);
        rezeptEntity.setBeschreibung(beschreibung);
        rezeptEntity.setName(name);

        em.persist(rezeptEntity);
        em.getTransaction().commit();
    }

    public List<RezeptEntity> getAllRecipes(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();

        List<RezeptEntity> rezeptEntities= em.createQuery("SELECT e FROM Entities.RezeptEntity e", RezeptEntity.class).getResultList();

        return rezeptEntities;
    }

    public RezeptEntity getRecipe(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();

        RezeptEntity rezeptEntity = em.find(RezeptEntity.class, id);

        return rezeptEntity;
    }

    public void deleteRecipe(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        RezeptEntity rezeptEntity = em.find(RezeptEntity.class, id);
        /* em.persist(rezeptEntity);
        em.remove(rezeptEntity);*/
        Session session =em.unwrap(Session.class);
        session.delete(rezeptEntity);

        em.getTransaction().commit();
    }
    public void updateRecipe(RezeptEntity recipe){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezepte");
        EntityManager em = emf.createEntityManager();

        Session session =em.unwrap(Session.class);
        session.update(recipe);

    }
}