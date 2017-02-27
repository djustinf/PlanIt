package Server.Requests;

import Models.People.DepartmentScheduler;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Justin on 2/27/2017.
 */
public class DepartmentService {

    public static List<DepartmentScheduler> getSchedulerList(EntityManager entityManager) {
        String query = "SELECT e FROM DepartmentScheduler e";
        List<DepartmentScheduler> schedulers = entityManager.createQuery(query, DepartmentScheduler.class).getResultList();
        return schedulers;
    }

    public static DepartmentScheduler getScheduler(EntityManager entityManager, String userName) {
        String query = String.format("SELECT e FROM DepartmentScheduler e WHERE userName = '%s'", userName);
        DepartmentScheduler user = entityManager.createQuery(query, DepartmentScheduler.class).getSingleResult();
        return user;
    }

    public static void postScheduler(EntityManager entityManager, DepartmentScheduler departmentScheduler) {
        entityManager.getTransaction().begin();
        entityManager.persist(departmentScheduler);
        entityManager.getTransaction().commit();
    }
}
