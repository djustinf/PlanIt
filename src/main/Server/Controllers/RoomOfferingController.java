package Server.Controllers;

import Models.Scheduling.Component;
import Models.Scheduling.RoomOffering;
import Server.Requests.PersistenceFactory;
import Server.Requests.RoomOfferingService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by lando on 3/8/2017.
 */
@RestController
@RequestMapping("/roomOffering")
public class RoomOfferingController {
    @RequestMapping(method = RequestMethod.GET)
    public List<RoomOffering> getAllRoomOfferings() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<RoomOffering> rooms = RoomOfferingService.getAllRoomOfferings(entityManager);
        entityManager.close();
        return rooms;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public RoomOffering getCourseName(@PathVariable String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        RoomOffering roomOffering = RoomOfferingService.getSingleRoomOffering(entityManager, name);
        entityManager.close();
        return roomOffering;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCourse(@RequestBody RoomOffering roomOffering) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        RoomOfferingService.postRoomOffering(entityManager, roomOffering);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public void addComponent(@RequestBody Component component, @PathVariable("name") String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        RoomOfferingService.addComponent(entityManager, name, component);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRoomOffering(@RequestParam String id) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        RoomOfferingService.removeRoomOffering(entityManager, id);
    }
}

