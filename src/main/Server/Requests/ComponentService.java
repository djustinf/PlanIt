package Server.Requests;

import Models.Scheduling.Component;
import Models.Scheduling.CourseOffering;
import Models.Scheduling.Schedule;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to fulfill requests from ComponentController.java
 *
 * @author Kris Campos
 * @version init - 2/22/17.
 */
public class ComponentService {

    /**
     * Service to retrieve a single component
     *
     * @param entityManager - Manages DB rows
     * @param scheduleName - Where the component lives
     * @param compName - The component's unique identifier
     * @return the request component
     */
    public static List<Component> getComponents(EntityManager entityManager, String scheduleName) {
        List<Component> components = new ArrayList<Component>();
        Schedule sched = ScheduleService.getSingleSchedule(entityManager, scheduleName);
        for (CourseOffering off : sched.getCourseList()) {
            components.addAll(off.getComponents());
        }
        return components;
    }

    public static void postComponent(EntityManager entityManager, Component comp) {
        entityManager.getTransaction().begin();
        entityManager.persist(comp);
        entityManager.getTransaction().commit();
    }

    public static void removeComponent(EntityManager entityManager, String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Component.class, id));
        entityManager.getTransaction().commit();
    }

}
