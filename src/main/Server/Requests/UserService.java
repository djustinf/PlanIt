package Server.Requests;

import Models.People.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Justin on 2/21/2017.
 */
public class UserService {

    public static List<User> getUser(EntityManager entityManager) {
        List<User> users = entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
        return users;
    }
}
