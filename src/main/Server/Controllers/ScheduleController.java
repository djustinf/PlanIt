package Server.Controllers;

import Models.Scheduling.*;
import Server.Requests.PersistenceFactory;
import Server.Requests.ScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all schedule objects
 *
 * @author Kris Campos
 * @version 0.2 - Updated to match API Doc version 0.2 - 2/21/2017
 * @version init - 2/13/2017.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    // Used to satisfy compiler
    private Schedule s = new Schedule(new Term("spring", 2017), "test");

    /**
     * Query point for searching all schedules
     *
     * @return Request schedules
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Schedule> getSchedule() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Schedule> schedules = ScheduleService.getSchedule(entityManager);
        entityManager.close();
        return schedules;
    }

    /**
     * Creates a new schedule
     *
     * @return - The freshly made schedule
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Schedule putSchedule(@RequestParam Schedule schedule) {
        return schedule;
    }

    /**
     * Retrieves calender view of this specific schedule
     *
     * @param fullname - full name of this term
     * @return Schedule with all its corresponding objects
     */
    @RequestMapping(value = "/{fullname}", method = RequestMethod.GET)
    public Schedule getScheduleFullname(@PathVariable String fullname) {
        return new Schedule(new Term("test", 2017), "test");
    }

    /**
     * Creates a new component
     *
     * @param fullname - term the schedule belongs to
     * @return the new component
     */
    @RequestMapping(value = "/{fullname}", method = RequestMethod.PUT)
    public Component putScheduleFullname(@PathVariable String fullname, @RequestParam Component component) {
        return component;
    }

    /**
     * deletes this schedule, its components, course offerings, and comments
     *
     * @param fullname - term this schedule belongs to
     */
    @RequestMapping(value = "/{fullname}", method = RequestMethod.DELETE)
    public void deleteScheduleFullname(@PathVariable String fullname) {

    }

    /**
     * Retrieves a list of comments
     *
     * @param fullname - The term the schedule belongs to
     * @return a list of comments
     */
    @RequestMapping(value = "/{fullname}/comments", method = RequestMethod.GET)
    public List<Comment> getScheduleTermComments(@PathVariable String fullname, @RequestParam String query) {
        return new ArrayList<>();
    }

    /**
     * Add a new comment
     *
     * @param fullname - The term the schedule belongs to
     * @return the new comment
     */
    @RequestMapping(value = "/{fullname}/comments", method = RequestMethod.PUT)
    public Comment putScheduleTermComments(@PathVariable String fullname, @RequestParam Comment comment) {
        return comment;
    }
}
