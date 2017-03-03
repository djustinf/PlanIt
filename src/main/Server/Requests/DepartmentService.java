package Server.Requests;

import Models.People.DepartmentScheduler;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Service to process requests from /user/departmentScheduler
 *
 * @author Kris
 * @author Justin
 *
 * @version v0.2 - fixed put/post confusion. Added documentation - Kris - 3/1/2017
 * @version init - 2/27/2017.
 */
public class DepartmentService {

    /**
     * retrieves a list of department schedulers in the system
     *
     * @param entityManager - manages DB rows
     * @return List of all department schedulers in the system
     */
    public static List<DepartmentScheduler> getSchedulerList(EntityManager entityManager) {
        String query = "SELECT e FROM DepartmentScheduler e";
        return entityManager.createQuery(query, DepartmentScheduler.class).getResultList();
    }

    /**
     * Retrieves a single department scheduler
     *
     * @param entityManager - Manages DB rows / Java objects
     * @param userName - unique identifier for this department scheduler
     * @return DepartmentScheduler object as specified by userName
     */
    public static DepartmentScheduler getScheduler(EntityManager entityManager, String userName) {
        String query = String.format("SELECT e FROM DepartmentScheduler e WHERE userName = '%s'", userName);
        return entityManager.createQuery(query, DepartmentScheduler.class).getSingleResult();
    }

    /**
     * Creates new department scheduler
     *
     * @param entityManager - Manages DB rows / Java objects
     * @param departmentScheduler - DepartmentScheduler to be created
     */
    public static void postScheduler(EntityManager entityManager, DepartmentScheduler departmentScheduler) {
        entityManager.getTransaction().begin();
        entityManager.persist(departmentScheduler);
        entityManager.getTransaction().commit();
    }
}
