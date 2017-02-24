package Server.Requests;

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
}
