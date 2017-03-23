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
import java.util.ArrayList;

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

        Faculty faculty = new Faculty("admin", "test", "doesnot@exist", "John", "Doe");
        Term term = new Term("Winter", 2017);


        Schedule two = new Schedule(term, "Second_Sched2");
        RoomOffering room = new RoomOffering(two, "Theatre");
        two.setTerm(term);
        two.addCourse(new CourseOffering("CPE453", two));
        two.addCourse(new CourseOffering("CPE349", two));
        two.addCourse(new CourseOffering("CPE309", two));

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
        Term term = new Term("Winter", 2018);

        Schedule one =  new Schedule(term, "First_Sched1");
        RoomOffering room = new RoomOffering(one, "A (very) Active Volcano");
        term.addSched(one);
        one.setTerm(term);

        ArrayList<Component> addedComponents = new ArrayList<Component>();
        ArrayList<CourseOffering> addedOfferings = new ArrayList<CourseOffering>();

        String[] courseNames = {"CPE453", "CPE309", "CPE300", "CPE349"};

        String type = "Lecture" + Integer.toString(13);
        CourseOffering offering = new CourseOffering(courseNames[0], one);

        Component component = new Component(type, 1, 8, 10, offering, room, faculty, 13);
        component.setDays(false, true, true, true, false, false, false);
        addedComponents.add(component);
        offering.addComponent(component);
        addedOfferings.add(offering);

        one.addCourse(offering);

        type = "Lecture" + Integer.toString(15);
        offering = new CourseOffering(courseNames[1], one);

        component = new Component(type, 1, -4, -2, offering, room, faculty, 15);
        component.setDays(false, true, false, true, false, true, false);
        addedComponents.add(component);
        offering.addComponent(component);
        addedOfferings.add(offering);

        one.addCourse(offering);

        type = "Lecture" + Integer.toString(17);
        offering = new CourseOffering(courseNames[2], one);

        component = new Component(type, 1, 0,  4, offering, room, faculty, 17);
        component.setDays(false, false, true, false, true, false, false);
        addedComponents.add(component);
        offering.addComponent(component);
        addedOfferings.add(offering);

        one.addCourse(offering);

        type = "Lecture" + Integer.toString(19);
        offering = new CourseOffering(courseNames[3], one);

        component = new Component(type, 1, 4, 5, offering, room, faculty, 19);
        component.setDays(false, true, true, false, true, true, false);
        addedComponents.add(component);
        offering.addComponent(component);
        addedOfferings.add(offering);

        one.addCourse(offering);


//
//        for(int j = 0; j < courseNames.length; j++){
//            CourseOffering offering = new CourseOffering(courseNames[j], one);
//            for (int i = 0; i < 5; i++) {
//                String type = "Lecture" + Integer.toString(i);
//                Component component = new Component(type, 1, i + 1, i + 2, offering, room, faculty, i);
//                component.setDays(false, true, false, true, false, true, false);
//                addedComponents.add(component);
//                offering.addComponent(component);
//            }
//            for (int i = 0; i < 5; i++) {
//                String type = "Lab" + Integer.toString(i);
//                Component component = new Component(type, 1, i + 1, i + 2, offering, room, faculty, i);
//                component.setDays(false, false, true, false, true, false, false);
//                addedComponents.add(component);
//                offering.addComponent(component);
//            }
//            addedOfferings.add(offering);
//            one.addCourse(offering);
//        }

        entityManager.getTransaction().begin();
        entityManager.persist(faculty);
        entityManager.persist(room);
        entityManager.persist(term);
        for(Component c : addedComponents){
            entityManager.persist(c);
        }
        for(CourseOffering o : addedOfferings){
            entityManager.persist(o);
        }
        entityManager.persist(one);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
