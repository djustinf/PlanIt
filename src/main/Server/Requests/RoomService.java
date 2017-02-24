package Server.Requests;

import Models.Scheduling.Room;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Jason on 2/22/17.
 */
public class RoomService {

    public static List<Room> getRooms(EntityManager entityManager) {
        List<Room> rooms = entityManager.createQuery("SELECT e FROM Room e", Room.class).getResultList();
        return rooms;
    }
}
