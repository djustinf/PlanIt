package Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Launching point for server
 *
 * Created by Kris on 2/11/2017.
 */
@SpringBootApplication
@Controller
public class PlanIt {
    public static void main(String[] args) {
        SpringApplication.run(PlanIt.class, args);
    }
}
