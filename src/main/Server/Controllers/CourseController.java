package Server.Controllers;

import Models.Scheduling.Course;
import Server.Requests.CourseService;
import Server.Requests.PersistenceFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    /**
     * Access point to get all courses
     *
     * @return a list of all courses matching query specification
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Course> courses = CourseService.getCourses(entityManager);
        entityManager.close();
        return courses;
    }

    /**
     * Creates a new course
     *
     * @param course - course to be added to system
     */
    @RequestMapping(method = RequestMethod.POST)
    public void createCourse(@RequestBody Course course) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        CourseService.postCourse(entityManager, course);
    }

    /**
     * Retrieve a specific course
     *
     * @param name unique identifier for this course
     * @return the request course
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Course getCourseName(@PathVariable String name) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        Course course = CourseService.getSingleCourse(entityManager, name);
        entityManager.close();
        return course;
    }

    /**
     * Updates a specific course
     *
     * @param name unique identifier for a course
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public void updateCourseName(@PathVariable String name) {

    }

    /**
     * Deletes a specific course.
     *
     * This will have to delete this course from faculty preferences and also remove it from unpublished schedules.
     *
     * @param name unique identifier of course
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void deleteCourseName(@PathVariable String name) {

    }
}
