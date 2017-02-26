package Server.Requests;

import Models.Scheduling.Course;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Handles Course requests
 *
 * @author Kris
 * @author Jason
 *
 * @version init - 2/22/17.
 */
public class CourseService {

    public static List<Course> getCourses(EntityManager entityManager) {
        String query = "SELECT c FROM Course c";
        return entityManager.createQuery(query, Course.class).getResultList();
    }

    public static void postCourse(EntityManager entityManager, Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    public static Course getSingleCourse(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM Course c WHERE name = %s", name);
        return entityManager.createQuery(query, Course.class).getSingleResult();
    }

    public static void deleteSingleCourse(EntityManager entityManager, String name) {
        String query = String.format("DELETE c FROM Course c WHERE name = %s", name);
        entityManager.createQuery(query, Course.class);
    }
}