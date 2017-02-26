package Server.Controllers;

import Models.People.DepartmentScheduler;
import org.springframework.web.bind.annotation.*;

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
    public List<DepartmentScheduler> getAllSchedulers(@RequestParam String query) {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DepartmentScheduler createScheduler(@RequestParam DepartmentScheduler scheduler) {
        return scheduler;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public DepartmentScheduler getScheduler(@PathVariable String username) {
        return new DepartmentScheduler(username, username, username, username);
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

