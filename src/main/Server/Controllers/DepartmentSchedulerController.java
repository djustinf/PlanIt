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
 * @version init - 2/23/2017.
 */
@RestController
@RequestMapping("/user/departmentScheduler")
public class DepartmentSchedulerController {

    @RequestMapping(method = RequestMethod.GET)
    public List<DepartmentScheduler> getAllSchedulers() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<DepartmentScheduler> users = DepartmentService.getSchedulerList(entityManager);
        entityManager.close();
        return users;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DepartmentScheduler createScheduler(@RequestParam DepartmentScheduler scheduler) {
        return scheduler;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public DepartmentScheduler getScheduler(@PathVariable String username) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        DepartmentScheduler user = DepartmentService.getScheduler(entityManager, username);
        entityManager.close();
        return user;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public DepartmentScheduler updateScheduler(@PathVariable String username) {
        return new DepartmentScheduler(username, username, username, username);
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

