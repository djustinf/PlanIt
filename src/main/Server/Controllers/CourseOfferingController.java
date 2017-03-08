package Server.Controllers;

import Models.Scheduling.Component;
import Models.Scheduling.CourseOffering;
import Server.Requests.CourseOfferingService;
import Server.Requests.PersistenceFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


/**
 * Created by Landon on 3/8/2017.
 */
@RestController
@RequestMapping("/courseOffering")
public class CourseOfferingController {
    @RequestMapping(method = RequestMethod.GET)
    public List<CourseOffering> getAllCourseOfferings() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<CourseOffering> courses = CourseOfferingService.getAllCourseOfferings(entityManager);
        entityManager.close();
        return courses;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public CourseOffering getCourseName(@PathVariable String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseOffering courseOffering = CourseOfferingService.getSingleCourseOffering(entityManager, name);
        entityManager.close();
        return courseOffering;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCourse(@RequestBody CourseOffering courseOffering) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseOfferingService.postCourseOffering(entityManager, courseOffering);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public void addComponent(@RequestBody Component component, @PathVariable("name") String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseOfferingService.addComponent(entityManager, name, component);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourseOffering(@RequestParam String id) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseOfferingService.removeCourseOffering(entityManager, id);
    }
}
