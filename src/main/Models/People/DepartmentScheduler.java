package Models.People;

import Models.Scheduling.Schedule;
import Models.Scheduling.Term;

import javax.persistence.Entity;

/**
 * Created by Kris on 2/1/2017.
 */
@Entity
public class DepartmentScheduler extends User {

    protected DepartmentScheduler() {}

    public DepartmentScheduler(String userName, String email, String firstName, String lastName) {
        super(userName, email, firstName, lastName);
    }

    public Schedule newSchedule(Term term, String name){
        Schedule newSched = new Schedule(term, name);
        return newSched;
    }

    public void updateSchedule(Term term, String name)
    {

    }

    public void addComponent(){

    }
}