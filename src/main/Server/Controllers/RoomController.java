package Server.Controllers;

import Models.Scheduling.Room;

import Server.Requests.PersistenceFactory;
import Server.Requests.RoomService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for room objects
 *
 * @author Kris Campos
 * @version init -  2/13/2017.
 * updated by Jason Ismail 2/24/2017
 * changed room ID's to name
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    /**
     * Retrieves a list of rooms
     *
     * @return List of rooms in system
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Room> getRoom() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Room> rooms = RoomService.getRooms(entityManager);
        entityManager.close();
        return rooms;
    }

    /**
     * Creates a new room
     *
     * @return The freshly made room
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Room putRoom(@RequestParam Room room) {
        return room;
    }

    /**
     * Retrieves this room
     *
     * @param name - Room name
     * @return - Room corresponding to name
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Room getRoomId(@PathVariable long id) {
        return new Room();
    }

    /**
     * Updates this room
     *
     * @param name - Room name
     */
    @RequestMapping(method = RequestMethod.POST)
    public Room postRoomId(@RequestBody Room room) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        RoomService.postRoom(entityManager, room);
        return room;
    }

    /**
     * Deletes this room
     *
     * @param name - Room name
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void deleteRoomId(@PathVariable long id) {

    }
}
