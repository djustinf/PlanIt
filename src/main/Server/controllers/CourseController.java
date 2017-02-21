package Server.controllers;

import Models.Scheduling.Course;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all course objects
 *
 * Created by Kris on 2/13/2017.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getCourse() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Course putCourse() {
        return new Course("a");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course getCourseId(@PathVariable long id) {
        return new Course("b");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void postCourseId(@PathVariable long id) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourseId(@PathVariable long id) {

    }
}
