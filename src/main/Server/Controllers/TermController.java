package Server.Controllers;

import Models.Scheduling.Schedule;
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

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTerm(@RequestParam String uniqueName) {
        // delete term from system
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        TermService.deleteTerm(entityManager, uniqueName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postTerm(@RequestBody Term term) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        TermService.postTerm(entityManager, term);
    }

    @RequestMapping(value = "/{uniqueName}", method = RequestMethod.PUT)
    public void addSchedule(@RequestBody Schedule schedule, @PathVariable("uniqueName") String uniqueName) {
        EntityManagerFactory singleton = PersistenceFactory.getInstance().getEntityManagerFactory();
        EntityManager entityManager = singleton.createEntityManager();
        TermService.addSchedule(entityManager, uniqueName, schedule);
    }
}
