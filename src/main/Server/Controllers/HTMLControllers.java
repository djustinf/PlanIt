package Server.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle all requests that are meant to return HTML
 *
 * Created by Kris on 2/20/2017.
 */
@Controller
public class HTMLControllers {

    @RequestMapping({"/", "/home", ""})
    public String homeHTML() {
        // TODO update the returning html
        return "/views/calendar.html";
    }

    @RequestMapping("/login")
    public String loginHTML() {
        return "/views/login.html";
    }

    @RequestMapping({"/calendar", "/Calendar"})
    public String schedulesHTML() {
        return "views/calendar.html";
    }

    @RequestMapping({"/navbar"})
    public String navbarHTML() {
        return "views/navbar.partial.html";
    }

    /*
    This can be represented as an angular pop-up box

    @RequestMapping("/schedules/components")
    public String componentsHTML() {
        return "views/components.html";
    }
    */

    @RequestMapping({"/admin", "/Admin"})
    public String adminHTML() {
        return "/views/admin.html";
    }

    @RequestMapping({"/myprofile", "/myProfile", "/MyProfile"})
    public String myProfileHTML() {
        return "views/profile.html";
    }

    @RequestMapping({"/test", "/Test"})
    public String testPageHTML() {
        return "/views/index.html";
    }
}
