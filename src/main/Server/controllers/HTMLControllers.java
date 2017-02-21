package Server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle all requests that are meant to return HTML
 *
 * Created by Kris on 2/20/2017.
 */
@Controller
public class HTMLControllers {

    @RequestMapping({"/", "/home", "", "/login"})
    public String homeHTML() {
        return "/views/login.html";
    }

    @RequestMapping("/schedules")
    public String schedulesHTML() {
        return "views/schedules.html";
    }

    @RequestMapping("/schedules/components")
    public String componentsHTML() {
        return "views/components.html";
    }

    @RequestMapping("/admin")
    public String adminHTML() {
        return "/views/admin.html";
    }

    @RequestMapping("/MyProfile")
    public String myProfileHTML() {
        return "views/myProfile.html";
    }

    @RequestMapping("/Users")
    public String usersHTML() {
        return "views/users.html";
    }

    @RequestMapping("/Rooms")
    public String roomsHTML() {
        return "/views/rooms.html";
    }

    @RequestMapping("/Rooms")
    public String coursesHTML() {
        return "/views/courses.html";
    }

    @RequestMapping("/Test")
    public String testPageHTML() {
        return "/views/index.html";
    }
}
