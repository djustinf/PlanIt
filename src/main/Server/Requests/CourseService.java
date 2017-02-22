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

    public static Course putCourse(EntityManager entityManager, Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        // possibly delete this next line and make void
        return getSingleCourse(entityManager, course.getName());
    }

    public static Course getSingleCourse(EntityManager entityManager, String name) {
        String query = String.format("SELECT 1 FROM Course c WHERE name = %s", name);
        return entityManager.createQuery(query, Course.class).getSingleResult();
    }

    public static void deleteSingleCourse(EntityManager entityManager, String name) {
        String query = String.format("DELETE 1 FROM Course c WHERE name = %s", name);
        entityManager.createQuery(query, Course.class);
    }
}
