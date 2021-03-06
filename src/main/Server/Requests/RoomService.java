package Server.Requests;

import javax.persistence.EntityManager;
import java.util.List;

import Models.People.User;
import Models.Scheduling.Course;
import Models.Scheduling.Room;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Jason on 2/22/17.
 */




public class RoomService {

    /**
     * Retrieves a list of rooms
     *
     * @return List of rooms in system
     */
    public static List<Room> getRooms(EntityManager entityManager) {
        String query = "SELECT e FROM Room e";
        List<Room> rooms = entityManager.createQuery(query, Room.class).getResultList();
        return rooms;

    }

    /**
     * Creates a new room
     *
     * @return The freshly made room
     */
    public static void postRoom(EntityManager entityManager, Room room) {
        entityManager.getTransaction().begin();
        entityManager.persist(room);
        entityManager.getTransaction().commit();
    }

    /**
     * Retrieves this room
     *
     * @param name - Room name
     * @return - Room corresponding to name
     */
    public Room getRoomName(String name, EntityManager entityManager) {
        String query = String.format("SELECT r FROM Roon r WHERE name = %s", name);
        return entityManager.createQuery(query, Room.class).getSingleResult();

    }


    /**
     * Updates this room
     *
     * @param id - Room name
     */
    public void postRoomId(String name, Room room, EntityManager entityManager) {
        // update room referenced by id with the new fields specific in the room object

    }

    /**
     * Deletes this room
     *
     * @param id - Room name
     */
    public static void removeRoom(EntityManager entityManager, String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Room.class, id));
        entityManager.getTransaction().commit();
    }
}
