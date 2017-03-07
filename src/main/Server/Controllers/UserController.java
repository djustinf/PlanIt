package Server.Controllers;

import Models.People.User;
import Server.Requests.PersistenceFactory;
import Server.Requests.UserService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    public List<User> getUserList() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<User> users = UserService.getUserList(entityManager);
        entityManager.close();
        return users;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        UserService.postUser(entityManager, user);
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
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        User user = UserService.getUser(entityManager, username);
        entityManager.close();
        return user;
    }

    /**
     * Delete this specific user
     *
     * @param username - User's unique username
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam String id) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        UserService.removeUser(entityManager, id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        UserService.updateUser(entityManager, user);
    }
}
