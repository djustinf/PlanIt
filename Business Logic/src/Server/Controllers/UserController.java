package Server.Controllers;

import Models.People.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for /User and /User/{id}
 *
 * @author Kris Campos
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
        System.out.println("/user\t\t\t\tGET");
        return new ArrayList<>();
    }

    /**
     * Create a new user
     *
     * @return The newly created user
     */
    @RequestMapping(method = RequestMethod.PUT)
    public User createUser() {
        System.out.println("/user\t\t\t\tPUT");
        return new User(0, "a", "b", "c", "d");
    }

    /**
     * Get info on this user
     *
     * @param id - User ID
     * @return User object pertaining to userID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        System.out.println("/user/{id}\t\t\t\tGET: " + id);
        return new User(0, "a", "b", "c", "d");
    }

    /**
     * Update this user's information
     *
     * @param id - User ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void updateUser(@PathVariable Long id) {
        System.out.println("/user/{id}\t\t\t\tPOST: " + id);
    }

    /**
     * Delete this specific user
     *
     * @param id - User ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        System.out.println("user/{id}\t\t\t\tDELETE: " + id);
    }
}
