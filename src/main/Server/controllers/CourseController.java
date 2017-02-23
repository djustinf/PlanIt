package Server.controllers;

import Models.Scheduling.Course;
import Server.Requests.CourseService;
import Server.Requests.PersistenceFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all course objects
 *
 * @author Kris
 * @version 0.2 - Updated to reflect API Doc v 0.2 - 2/21/2017
 * @version init - 2/13/2017.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getCourse() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Course> courses = CourseService.getCourses(entityManager);
        entityManager.close();
        return courses;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Course putCourse(@RequestBody Course course) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseService.putCourse(entityManager, course);
        return course;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Course getCourseName(@PathVariable String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        Course course = CourseService.getSingleCourse(entityManager, name);
        entityManager.close();
        return course;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.POST)
    public void postCourseName(@PathVariable String name) {

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void deleteCourseName(@PathVariable String name) {

    }
}
