package Server.Controllers;

import Models.Scheduling.Comment;
import Models.Scheduling.Component;
import Models.Scheduling.Schedule;
import Models.Scheduling.Term;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all schedule objects
 *
 * @author Kris Campos
 * @version init - 2/13/2017.
 */
@RestController
@RequestMapping("/Schedule")
public class ScheduleController {

    /**
     * Query point for searching all schedules
     *
     * @return Request schedules
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Schedule> getSchedule() {
        return new ArrayList<>();
    }

    /**
     * Creates a new schedule
     *
     * @return - The freshly made schedule
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Schedule putSchedule() {
        return new Schedule();
    }

    /**
     *  Deletes a term so long as that term does not contain any schedules
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSchedule() {

    }

    /**
     * Retrieves calender view of this specific schedule
     *
     * @param term - term this schedule belongs to
     * @return Schedule with all its corresponding objects
     */
    @RequestMapping(value = "/{term}", method = RequestMethod.GET)
    public Schedule getScheduleTerm(@PathVariable long term) {
        return new Schedule();
    }

    /**
     * Update fields about this schedule as a whole. NOT the individual components
     *
     * @param term - term this schedule belongs to
     */
    @RequestMapping(value = "/{term}", method = RequestMethod.POST)
    public void postScheduleTerm(@PathVariable long term) {

    }

    /**
     * Creates a new component
     *
     * @param term - term the schedule belongs to
     * @return the new component
     */
    @RequestMapping(value = "/{term}", method = RequestMethod.PUT)
    public Component putScheduleTerm(@PathVariable long term) {
        return new Component("hi", 4, 0, 12);
    }

    /**
     * deletes this schedule, its components, course offerings, and comments
     *
     * @param term - term this schedule belongs to
     */
    @RequestMapping(value = "/{term}", method = RequestMethod.DELETE)
    public void deleteScheduleTerm(@PathVariable long term) {

    }

    /**
     * Retrieves a list of comments
     *
     * @param term - The term the schedule belongs to
     * @return a list of comments
     */
    @RequestMapping(value = "/{term}/comments", method = RequestMethod.GET)
    public List<Comment> getScheduleTermComments(@PathVariable long term) {
        return new ArrayList<>();
    }

    /**
     * Add a new comment
     *
     * @param term - The term the schedule belongs to
     * @return the new comment
     */
    @RequestMapping(value = "/{term}/comments", method = RequestMethod.PUT)
    public Comment putScheduleTermComments(@PathVariable long term) {
        return new Comment(0, "hello");
    }
}
