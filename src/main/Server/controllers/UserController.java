package Server.controllers;

import Models.People.User;
import Server.Requests.PersistenceFactory;
import Server.Requests.TermService;
import Server.Requests.UserService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for /User and /User/{id}
 *
 * @author Kris Campos
 * @version 0.2 - Updated to reflect API Doc v 0.2 - 2/21/2017
 * @version init - 2/11/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Returns a list of users in the System.
     *
     * @return A list of users in the system
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<User> users = UserService.getUser(entityManager);
        entityManager.close();
        return users;
    }

    /**
     * Create a new user
     *
     * @return The newly created user
     */
    @RequestMapping(method = RequestMethod.PUT)
    public User createUser(@RequestParam User user) {
        System.out.println("/user\t\t\t\tPUT");
        return user;
    }

    /**
     * Get info on this user
     *
     * @param username - User's unique username
     * @return User object pertaining to username
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        System.out.println("/user/{id}\t\t\t\tGET: " + username);
        return new User(username, "b", "c", "d");
    }

    /**
     * Update this user's information
     *
     * @param username - User's unique username
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public void updateUser(@PathVariable String username, @RequestParam User user) {
        System.out.println("/user/{id}\t\t\t\tPOST: " + username);
    }

    /**
     * Delete this specific user
     *
     * @param username - User's unique username
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username) {
        System.out.println("user/{id}\t\t\t\tDELETE: " + username);
    }
}
