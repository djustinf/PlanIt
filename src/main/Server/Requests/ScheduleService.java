package Server.Requests;

import Models.Scheduling.Course;
import Models.Scheduling.CourseOffering;
import Models.Scheduling.Schedule;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Jason on 2/22/17.
 */
public class ScheduleService {

    public static List<Schedule> getSchedule(EntityManager entityManager) {
        String query = "SELECT e FROM Schedule e";
        List<Schedule> schedules = entityManager.createQuery(query, Schedule.class).getResultList();
        return schedules;
    }

    public static void postSchedule(EntityManager entityManager, Schedule schedule) {
        entityManager.getTransaction().begin();
        entityManager.persist(schedule);
        entityManager.getTransaction().commit();
    }

    public static Schedule getSingleSchedule(EntityManager entityManager, String name) {
        String query = String.format("SELECT c FROM Schedule c WHERE fullName = '%s'", name);
        return entityManager.createQuery(query, Schedule.class).getSingleResult();
    }

    public static void addCourseOffering(EntityManager entityManager, String fullName, CourseOffering offering) {
        entityManager.getTransaction().begin();
        Schedule schedule = getSingleSchedule(entityManager, fullName);
        schedule.addCourse(offering);
        offering.setSched(schedule);
        entityManager.getTransaction().commit();
    }
}
