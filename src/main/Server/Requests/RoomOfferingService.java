package Server.Requests;

import Models.Scheduling.Component;
import Models.Scheduling.RoomOffering;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Landon on 3/8/2017.
 */
public class RoomOfferingService {

    public static List<RoomOffering> getAllRoomOfferings(EntityManager entityManager) {
        String query = "SELECT c FROM RoomOffering c";
        return entityManager.createQuery(query, RoomOffering.class).getResultList();
    }

    public static void postRoomOffering(EntityManager entityManager, RoomOffering room) {
        entityManager.getTransaction().begin();
        entityManager.persist(room);
        entityManager.getTransaction().commit();
    }

    public static RoomOffering getSingleRoomOffering(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM RoomOffering c WHERE name = %s", name);
        return entityManager.createQuery(query, RoomOffering.class).getSingleResult();
    }

    public static void addComponent(EntityManager entityManager, String name, Component component) {
        entityManager.getTransaction().begin();
        RoomOffering offering = getSingleRoomOffering(entityManager, name);
        offering.addComponent(component);
        component.setRoom(offering);
        entityManager.getTransaction().commit();
    }

    public static void removeRoomOffering(EntityManager entityManager, String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(RoomOffering.class, id));
        entityManager.getTransaction().commit();
    }
}
