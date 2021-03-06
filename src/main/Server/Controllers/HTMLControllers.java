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
        return "/views/calendar.html";
    }

    @RequestMapping("/rooms")
    public String roomsHTML() {
        return "/views/rooms.html";
    }

    @RequestMapping("/users")
    public String usersHTML() {
        return "/views/users.html";
    }

    @RequestMapping("/courses")
    public String coursesHTML() {
        return "/views/courses.html";
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

    @RequestMapping({"/addEvent"})
    public String addEventHTML() {
        return "views/addEvent.partial.html";
    }

    @RequestMapping({"/addRoom"})
    public String addRoomHTML() {
        return "views/addRoom.partial.html";
    }

    @RequestMapping({"/addUser"})
    public String addUserHTML() {
        return "views/addUser.partial.html";
    }

    @RequestMapping({"/viewRooms"})
    public String viewRoomsHTML(){
        return "views/viewRooms.partial.html";
    }

    @RequestMapping({"/viewUsers"})
    public String viewUsersHTML(){
        return "views/viewUsers.partial.html";
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
