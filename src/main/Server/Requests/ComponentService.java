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
        String query = String.format("some query");
        return entityManager.createQuery(query, Component.class).getSingleResult();
    }

}
