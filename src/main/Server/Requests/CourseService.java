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
 * @version v0.2 - corrected confusion between post and put, noted pending functionality - Kris - 3/1/2017
 * @version init - Jason - 2/22/17.
 */
public class CourseService {

    /**
     * Service to retrieve all rows in Course table
     *
     * @param entityManager - Manager for the course table
     * @return - list of courses that fit query parameter
     */
    public static List<Course> getCourses(EntityManager entityManager) {
        String query = "SELECT c FROM Course c";
        return entityManager.createQuery(query, Course.class).getResultList();
    }

    /**
     * Service to add a new course to the Course table
     *
     * @param entityManager - manages entities in the Course table
     * @param course - The new course to add
     */
    public static void postCourse(EntityManager entityManager, Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    /**
     * Returns a single course from the database
     *
     * @param entityManager - manages entities in the Course table
     * @param name - unique name of the desired course to retrieve
     * @return - course with the same unique name given
     */
    public static Course getSingleCourse(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM Course c WHERE name = %s", name);
        return entityManager.createQuery(query, Course.class).getSingleResult();
    }


    /**
     * Deletes a single course from the database
     *
     * Also deletes this course from faculty preferences and removes it from all unpublished schedules
     *
     * @param entityManager - manages entities in the Course table
     * @param name - unique name of course to be deleted
     */
    public static void removeCourse(EntityManager entityManager, String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, id));
        entityManager.getTransaction().commit();
    }
}
