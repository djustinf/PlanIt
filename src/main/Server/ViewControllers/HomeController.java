package Server.ViewControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for home page
 *
 * @author Kris
 * @version init - 2/20/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "/views/login.html";
    }
}
