package Server.Requests;

import Models.People.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Justin on 2/21/2017.
 */
public class UserService {

    public static List<User> getUsers(EntityManager entityManager) {
        String query = "SELECT e FROM User e";
        List<User> users = entityManager.createQuery(query, User.class).getResultList();
        return users;
    }

    public static User getUser(EntityManager entityManager, String userName) {
        String query = String.format("SELECT e FROM User e WHERE userName = '%s'", userName);
        User user = entityManager.createQuery(query, User.class).getSingleResult();
        return user;
    }
}
