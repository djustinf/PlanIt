package Server.Controllers;

import Models.Scheduling.Component;
import org.springframework.web.bind.annotation.*;

/**
 * REST API for Component objects.
 *
 * @author Kris
 * @version init - 2/21/2017.
 */
@RestController
@RequestMapping("/schedule/{fullname}/component/{name}")
public class ComponentController {

    @RequestMapping(method = RequestMethod.GET)
    public Component getScheduleComponent(@PathVariable String fullname, @PathVariable String name) {
        return new Component("t", 0, 1, 2,true, false, true, false , false, true, false);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateScheduleComponent(@PathVariable String fullname, @PathVariable String name, @RequestParam Component component) {
        // update fields
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteScheduleComponent(@PathVariable String fullname, @PathVariable String name) {
        // delete this component
    }
}
