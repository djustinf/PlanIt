package Server.Controllers;

import Models.Scheduling.Component;
import Server.Requests.ComponentService;
import Server.Requests.PersistenceFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * REST API for Component objects.
 *
 * @author Kris
 * @version init - 2/21/2017.
 */
@RestController
@RequestMapping("/schedule/{fullName}/component")
public class ComponentController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Component> getAllComponents(@PathVariable("fullName") String fullName) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Component> components = ComponentService.getComponents(entityManager, fullName);
        entityManager.close();
        return components;
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
