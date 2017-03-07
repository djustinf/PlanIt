package Server.Requests;

import Models.Scheduling.Component;

import javax.persistence.EntityManager;

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
    public static Component getComponent(EntityManager entityManager, String scheduleName, String compName) {
        // TODO Update this once table is ready
        String query = String.format("SELECT Component e FROM Schedule f WHERE compName = '%s' AND scheduleName = '%s'",
                compName, scheduleName); /*this query could be (and probably is) all kinds of wrong*/
        return entityManager.createQuery(query, Component.class).getSingleResult();
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
