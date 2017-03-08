package Server.Requests;

import Models.Scheduling.Schedule;
import Models.Scheduling.Term;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Justin on 2/21/2017.
 */
public class TermService {

    public static List<Term> getTerms(EntityManager entityManager) {
        List<Term> terms = entityManager.createQuery("SELECT e FROM Term e", Term.class).getResultList();
        return terms;
    }

    public static Term getSingleTerm(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM Term c WHERE uniqueName = '%s'", name);
        return entityManager.createQuery(query, Term.class).getSingleResult();
    }

    public static void postTerm(EntityManager entityManager, Term term) {
        entityManager.getTransaction().begin();
        entityManager.persist(term);
        entityManager.getTransaction().commit();
    }

    public static void addSchedule(EntityManager entityManager, String termName, Schedule schedule) {
        entityManager.getTransaction().begin();
        Term term = getSingleTerm(entityManager, termName);
        term.addSched(schedule);
        schedule.setTerm(term);
        entityManager.getTransaction().commit();
    }

    public static void deleteTerm(EntityManager entityManager, String termName){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Term.class, termName));
        entityManager.getTransaction().commit();
    }
}
