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

    public Course(String name) {
        this.name = name;
        faculty = new ArrayList<Faculty>();
        offerings = new ArrayList<CourseOffering>();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
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

    public CourseOffering addOffering(Term term) {
        CourseOffering offer = new CourseOffering(ID, term.getTermYear(), term.getTermName());
        offerings.add(offer);
        return offer;
    }

    public void removeOffering(CourseOffering offer) {
        offerings.remove(offer);
    }

    public ArrayList<CourseOffering> getOfferings() {
        return offerings;
    }
}
