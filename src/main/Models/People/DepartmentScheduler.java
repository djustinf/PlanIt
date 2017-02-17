package Models.People;

import Models.Scheduling.Schedule;

import javax.persistence.Entity;

/**
 * Created by Kris on 2/1/2017.
 */
@Entity
public class DepartmentScheduler extends User {

    public DepartmentScheduler() {}

    public DepartmentScheduler(String userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    public void buildSchedule(String term){

    }

    public void addComponent(){

    }
}