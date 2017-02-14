import Models.Scheduling.CourseOffering;
import Models.Scheduling.Schedule;
import Models.Scheduling.Term;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * Created by Justin on 2/13/2017.
 */
public class ScheduleTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void setUpEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "schedPU" );
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void canPersistAndLoadTermAndSchedule() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Term term = new Term();
        term.setTermName("Fall");
        term.setTermYear(2018);

        Schedule one =  new Schedule("First_Sched");
        one.setTerm(term);
        one.addCourse(new CourseOffering("CPE453", one));
        one.addCourse(new CourseOffering("CPE349", one));
        one.addCourse(new CourseOffering("CPE309", one));

        Schedule two = new Schedule("Second_Sched");
        two.setTerm(term);
        two.addCourse(new CourseOffering("CPE453", two));
        two.addCourse(new CourseOffering("CPE349", two));
        two.addCourse(new CourseOffering("CPE309", two));

        term.addSched(one);
        term.addSched(two);

        try {
            entityManager.getTransaction().begin();

            // persist organizer (will be cascaded to hikes)
            entityManager.persist(term);

            entityManager.getTransaction().commit();

            // get a new EM to make sure data is actually retrieved from the store and not Hibernate's internal cache
            entityManager.close();
        }
        catch (RollbackException e) {
            System.out.println("********************************************");
            System.out.printf("Term %s-%d already persists in datastore.\n", term.getTermName(), term.getTermYear());
            System.out.println("********************************************");
            entityManager.close();
            System.exit(0);
        }
        entityManager = entityManagerFactory.createEntityManager();

        // load it back
        entityManager.getTransaction().begin();

        Term loadedTerm = entityManager.find( Term.class, term.getId() );
        assertEquals(loadedTerm.getTermName(), term.getTermName());

        entityManager.getTransaction().commit();
        System.out.println("********************************************");
        System.out.printf("Successfully added %s-%d to datastore.\n", term.getTermName(), term.getTermYear());
        System.out.println("********************************************");

        entityManager.close();
    }
}
