package Models.Scheduling;

import Models.People.Faculty;
import java.util.ArrayList;

/**
 * Created by Kris on 2/3/2017.
 */
public class Course {

    private int ID;
    private String name;
    private ArrayList<CourseOffering> offerings;
    private ArrayList<Faculty> faculty;

    public Course(int ID, String name) {
        this.ID = ID;
        this.name = name;
        faculty = new ArrayList<Faculty>();
        offerings = new ArrayList<CourseOffering>();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty member) {
        faculty.add(member);
    }

    public void removeFaculty(Faculty member) {
        faculty.remove(member);
    }

    public void addOffering(CourseOffering offer) {
        offerings.add(offer);
    }

    public void removeOffering(CourseOffering offer) {
        offerings.remove(offer);
    }
}
