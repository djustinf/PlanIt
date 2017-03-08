package ModelTests.ScheduleTests;

import Models.People.DepartmentScheduler;
import Models.People.Faculty;
import Models.Scheduling.*;
import Server.Requests.PersistenceFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

/**
 * Created by Justin on 2/13/2017.
 */
public class ScheduleTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void setUpEntityManagerFactory() {
        entityManagerFactory = PersistenceFactory.getInstance().getEntityManagerFactory();
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        PersistenceFactory.getInstance().closeEntityManagerFactory();
    }

    @Test
    public void canPersistAndLoadTermAndSchedule() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Faculty faculty = new Faculty("xXJoe_15Xx", "a", "doesnot@exist", "John", "Doe");
        Term term = new Term("Winter", 2018);

        Schedule one =  new Schedule(term, "First_Sched1");
        RoomOffering room = new RoomOffering(one, "Theatre");
        one.setTerm(term);
        CourseOffering offering = new CourseOffering("CPE453", one);
        offering.addComponent(new Component("Lecture",1, 2, 3, offering, room, faculty, 01));
        one.addCourse(offering);
        one.addCourse(new CourseOffering("CPE349", one));
        one.addCourse(new CourseOffering("CPE309", one));

        Schedule two = new Schedule(term, "Second_Sched2");
        two.setTerm(term);
        two.addCourse(new CourseOffering("CPE453", two));
        two.addCourse(new CourseOffering("CPE349", two));
        two.addCourse(new CourseOffering("CPE309", two));

        term.addSched(one);
        term.addSched(two);

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(faculty);
            entityManager.persist(room);
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

        Schedule loadedTerm = entityManager.find( Schedule.class, one.getId() );
        assertEquals(loadedTerm.getName(), one.getName());

        entityManager.getTransaction().commit();
        System.out.println("********************************************");
        System.out.printf("Successfully added %s-%d to datastore.\n", term.getTermName(), term.getTermYear());
        System.out.println("********************************************");

        entityManager.close();
    }

    @Test
    public void persistSomething() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Faculty faculty = new Faculty("some_random_guy", "hi", "doesnot@exist", "John", "Doe");
        Term term = new Term("Winter", 2050);

        Schedule one =  new Schedule(term, "First_Sched1");
        RoomOffering room = new RoomOffering(one, "A (very) Active Volcano");
        term.addSched(one);
        one.setTerm(term);
        CourseOffering offering = new CourseOffering("CPE453", one);
        for (int i = 0; i < 5; i++) {
            String type = "Lecture" + Integer.toString(i);
            Component component = new Component(type, 1, i + 1, i + 2, offering, room, faculty, i);
            component.setDays(false, true, false, true, false, true, false);
            offering.addComponent(component);
        }
        for (int i = 0; i < 5; i++) {
            String type = "Lab" + Integer.toString(i);
            Component component = new Component(type, 1, i + 1, i + 2, offering, room, faculty, i);
            component.setDays(false, false, true, false, true, false, false);
            offering.addComponent(component);
        }
        one.addCourse(offering);
        one.addCourse(new CourseOffering("CPE349", one));
        one.addCourse(new CourseOffering("CPE309", one));
        entityManager.getTransaction().begin();
        entityManager.persist(faculty);
        entityManager.persist(room);
        entityManager.persist(term);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
