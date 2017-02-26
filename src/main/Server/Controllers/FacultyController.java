package Server.Controllers;

import Models.People.Faculty;
import org.springframework.web.bind.annotation.*;

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
    public List<Faculty> getAllFaculty(@RequestParam String query) {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Faculty createFaculty(@RequestParam Faculty faculty) {
        return faculty;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Faculty getFaculty(@PathVariable String username) {
        return new Faculty(username, username, username, username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public Faculty updateFaculty(@PathVariable String username) {
        return new Faculty(username, username, username, username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteFaculty(@PathVariable String username) {

    }
}
