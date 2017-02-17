package Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Launching point for server
 *
 * Created by Kris on 2/11/2017.
 */
@SpringBootApplication
@RestController
public class PlanIt {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(PlanIt.class, args);
    }
}
