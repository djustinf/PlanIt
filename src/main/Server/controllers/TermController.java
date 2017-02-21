package Server.controllers;

import Models.Scheduling.Term;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API for handling Term objects.
 *
 * @author Kris
 * @version init - 2/21/2017.
 */
@RestController
@RequestMapping("/term")
public class TermController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Term> getTerm(@RequestParam String query) {
        // do some query stuff
        return new ArrayList<Term>();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Term putTerm(@RequestParam String name, @RequestParam int year) {
        Term term = new Term(name, year);
        // put it into system
        return term;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTerm(@RequestParam String uniqueName) {
        // delete term from system
    }
}
