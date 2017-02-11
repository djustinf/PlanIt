package Controllers;

import Models.HelloWorld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kris on 2/10/2017.
 */
@RestController
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/helloworld", method = RequestMethod.DELETE)
    public HelloWorld helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }
}
