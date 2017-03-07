package Server.Controllers;

import Models.People.DepartmentScheduler;
import Server.Requests.DepartmentService;
import Server.Requests.PersistenceFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API for department scheduler objects.
 *
 * @author Kris
 * @version v0.2 - fixed post/put mixup. Added documentation - Kris - 3/1/2017
 * @version init - 2/23/2017.
 */
@RestController
@RequestMapping("/user/departmentScheduler")
public class DepartmentSchedulerController {

    /**
     * Endpoint to get all department schedulers
     *
     * @return List of DepartmentScheduler objects
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<DepartmentScheduler> getAllSchedulers() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<DepartmentScheduler> users = DepartmentService.getSchedulerList(entityManager);
        entityManager.close();
        return users;
    }

    /**
     * Create a new department scheduler
     *
     * @param departmentScheduler - The department scheduler to be created
     */
    @RequestMapping(method = RequestMethod.POST)
    public void createScheduler(@RequestBody DepartmentScheduler departmentScheduler) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        DepartmentService.postScheduler(entityManager, departmentScheduler);
    }

    /**
     * Get a specific department scheduler
     *
     * @param username - unique identifier
     * @return - the specified department scheduler
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public DepartmentScheduler getScheduler(@PathVariable String username) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        DepartmentScheduler user = DepartmentService.getScheduler(entityManager, username);
        entityManager.close();
        return user;
    }

    /**
     * Deletes specified department scheduler. THROW ERROR IF THEY'RE DELETING THE LAST SCHEDULER
     *
     * @param username - Username of specified scheduler
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteScheduler(@PathVariable String username) {

    }
}

