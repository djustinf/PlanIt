package Server.Controllers;

import Models.Scheduling.Room;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for room objects
 *
 * @author Kris Campos
 * @version init -  2/13/2017.
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
        return new ArrayList<>();
    }

    /**
     * Creates a new room
     *
     * @return The freshly made room
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Room putRoom() {
        return new Room();
    }

    /**
     * Retrieves this room
     *
     * @param id - Room ID
     * @return - Room corresponding to ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Room getRoomId(@PathVariable long id) {
        return new Room();
    }

    /**
     * Updates this room
     *
     * @param id - Room ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void postRoomId(@PathVariable long id) {

    }

    /**
     * Deletes this room
     *
     * @param id - Room ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoomId(@PathVariable long id) {

    }
}
