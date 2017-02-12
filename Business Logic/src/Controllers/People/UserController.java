package Controllers.People;

import Models.People.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kris on 2/11/2017.
 *
@RestController
@RequestMapping(value = "/User")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(@RequestParam(value = "requesterID", required = true) int requesterID) {
        /*
        pseudo code
        if requestID belongs to DepartmentScheduler then
            return list of all Users
        else
            return forbidden (look up http error codes)
         *
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User createUser(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "email", required = true) String email
    ) {

    }
}
 */
