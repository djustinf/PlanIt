package Server.Controllers;

import Models.People.Faculty;
import Server.Requests.FacultyService;
import Server.Requests.PersistenceFactory;
import Server.Requests.UserService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API for modifying Faculty objects.
 *
 * @author Kris
 * @version init - 2/23/2017.
 */
@RestController
@RequestMapping("/user/faculty")
public class FacultyController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Faculty> getAllFaculty() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Faculty> users = FacultyService.getFacultyList(entityManager);
        entityManager.close();
        return users;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        FacultyService.postFaculty(entityManager, faculty);
        return faculty;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Faculty getFaculty(@PathVariable String username) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        Faculty user = FacultyService.getFaculty(entityManager, username);
        entityManager.close();
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateFaculty(@RequestBody Faculty user) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        FacultyService.updateFaculty(entityManager, user);
    }
}
