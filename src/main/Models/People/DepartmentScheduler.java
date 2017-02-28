package Models.People;

import Models.Scheduling.Schedule;
import Models.Scheduling.Term;

import javax.persistence.Entity;

/**
 * This class defines a extension of the user object with extended permissions.
 * An Instance of DepartmentScheduler will have full access to the system,\n
 * and will be able to create, or modify users and schedules.
 */
@Entity
public class DepartmentScheduler extends User {

    /**
     * This is the default constructor for a DepartmentScheduler.
     * Calls the default constructor of the User class, and does not set any instance variables.
     * This constructor should not be used in general system interaction.
     *
     * @return      a default DepartmentScheduler Object
     */
    protected DepartmentScheduler() {
        super();
    }

    /**
     * This is the constructor for a DepartmentScheduler, which will be used during normal system interaction.
     * This constructor calls the constructor of the User class with all given parameters.
     * The only difference between an instance of this class and the instance of a User class is the class title.
     * The class title is used to check system access permissions at runtime.
     *
     * @param  userName   a string representing the unique username of the Department Scheduler.
     * @param  email      a string representing the email address of the user
     * @param  firstName  a string representing the users first name.
     * @param  lastName   a string representing the useres last name.
     * @return            a DepartmentScheduler Object with all instance variable set.
     */
    public DepartmentScheduler(String userName, String password, String email, String firstName, String lastName) {
        super(userName, password, email, firstName, lastName);
    }

    /**
     * This is the constructor for a DepartmentScheduler, which will be used during normal system interaction.
     * This constructor calls the constructor of the User class with all given parameters.
     * The only difference between an instance of this class and the instance of a User class is the class title.
     * The class title is used to check system access permissions at runtime.
     *
     * @param  term   a Term object to denote which year and period this schedule is for.
     * @param  name   a string representing the name, chosen by the department scheduler, for this schedule.
     * @return        a new Schedule object, with nothing in it aside from the term and name.
     */
    public Schedule newSchedule(Term term, String name){
        Schedule newSched = new Schedule(term, name);
        return newSched;
    }

    /**
     * This is currently just a method stub. Perhaps a remnant of system unclarity.
     * An orphan of confusion. Anyways, this likely won't be encountered during standard system use.
     * Even if it is, nothing will happen.
     *
     * @param  term   a Term object to denote which year and period to check to find the schedule to be updated.
     * @param  name   a string representing the name for the schedule to be updated.
     */
    public void updateSchedule(Term term, String name)
    {

    }

    /**
     * This is currently just a method stub. Perhaps a remnant of system unclarity.
     * An orphan of confusion. Anyways, this likely won't be encountered during standard system use.
     * Even if it is, nothing will happen.
     *
     * This method takes no arguments, and does nothing.
     */
    public void addComponent(){

    }
}