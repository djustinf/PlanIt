package Server.Requests;

import Models.Scheduling.CourseOffering;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Landon on 3/8/2017.
 */
public class CourseOfferingService {

    public static List<CourseOffering> getAllCourseOfferings(EntityManager entityManager) {
        String query = "SELECT c FROM CourseOffering c";
        return entityManager.createQuery(query, CourseOffering.class).getResultList();
    }

    public static void postCourseOffering(EntityManager entityManager, CourseOffering course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    public static CourseOffering getSingleCourseOffering(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM CourseOffering c WHERE name = %s", name);
        return entityManager.createQuery(query, CourseOffering.class).getSingleResult();
    }

    public static void updateCourseOffering(EntityManager entityManager, CourseOffering course) {
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
    }

    public static void removeCourseOffering(EntityManager entityManager, String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(CourseOffering.class, id));
        entityManager.getTransaction().commit();
    }
}
