package Models.People;

import Models.Scheduling.Schedule;

/**
 * Created by Kris on 2/1/2017.
 */
public class DepartmentScheduler extends User {

    Schedule schedule = null;

    public DepartmentScheduler(int userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    public void buildSchedule(String term){

    }

    public void addComponent
}