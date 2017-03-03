package Server.Controllers;

import Models.Scheduling.Term;
import Server.Requests.PersistenceFactory;
import Server.Requests.TermService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    public List<Term> getTerm() {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        List<Term> terms = TermService.getTerms(entityManager);
        entityManager.close();
        return terms;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Term createTerm(@RequestParam String name, @RequestParam int year) {
        return new Term(name, year);
        // put it into system before returning
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTerm(@RequestParam String uniqueName) {
        // delete term from system
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postTerm(@RequestBody Term term) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        TermService.postTerm(entityManager, term);
    }
}
