package Server.Requests;

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

    public static void postTerm(EntityManager entityManager, Term term) {
        entityManager.getTransaction().begin();
        entityManager.persist(term);
        entityManager.getTransaction().commit();
    }

    public static void updateTerm(EntityManager entityManager, Term term) {
        entityManager.getTransaction().begin();
        entityManager.merge(term);
        entityManager.getTransaction().commit();
    }

    public static void deleteTerm(EntityManager entityManager, String termName){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Term.class, termName));
        entityManager.getTransaction().commit();
    }
}
