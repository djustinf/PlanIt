package Server.Requests;

import Models.People.Faculty;
import Models.People.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Justin on 2/27/2017.
 */
public class FacultyService {

    public static List<Faculty> getFacultyList(EntityManager entityManager) {
        String query = "SELECT e FROM Faculty e";
        List<Faculty> faculty = entityManager.createQuery(query, Faculty.class).getResultList();
        return faculty;
    }

    public static Faculty getFaculty(EntityManager entityManager, String userName) {
        String query = String.format("SELECT e FROM Faculty e WHERE userName = '%s'", userName);
        Faculty user = entityManager.createQuery(query, Faculty.class).getSingleResult();
        return user;
    }

    public static void postFaculty(EntityManager entityManager, Faculty faculty) {
        entityManager.getTransaction().begin();
        entityManager.persist(faculty);
        entityManager.getTransaction().commit();
    }
}
