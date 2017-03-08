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

    @RequestMapping(value = "/{fullName}", method = RequestMethod.GET)
    public Schedule getScheduleName(@PathVariable String fullName) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        Schedule schedule = ScheduleService.getSingleSchedule(entityManager, fullName);
        entityManager.close();
        return schedule;
    }

    @RequestMapping(value = "/{fullName}/offering", method = RequestMethod.PUT)
    public void addCourseOffering(@PathVariable("fullName") String fullName, @RequestBody CourseOffering courseOffering) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        ScheduleService.addCourseOffering(entityManager, fullName, courseOffering);
    }

    /**
     * Creates a new schedule
     *
     * @return - The freshly made schedule
     */
    @RequestMapping(method = RequestMethod.POST)
    public Schedule createSchedule(@RequestParam Schedule schedule) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        ScheduleService.postSchedule(entityManager, schedule);
        return schedule;
    }

}
