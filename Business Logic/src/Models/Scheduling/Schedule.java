package Models.Scheduling;

import java.util.*;

/**
 * Java representation of a schedule.
 *
 * @author Kris Campos
 * @version initial - 2/3/2017.
 */
public class Schedule {
    private int ID;
    private Term term;
    private String name;
    List<CourseOffering> courseList; // one entry per course in DB
    List<Comment> comments;

    public Schedule(Term term, int ID, String name)
    {
        this.term = term;
        this.ID = ID;
        courseList = new ArrayList<CourseOffering>();
        comments = new ArrayList<Comment>();
        this.name = term.getTermName() + term.getTermYear() + name;
    }

    // getters and setters

    public Term getTerm() {
        return term;
    }

    public String getTermName() {
        return term.getTermName();
    }

    public int getTermYear() {
        return term.getTermYear();
    }

    public List<CourseOffering> getCourseList() {
        return courseList;
    }

    public boolean addCourse(CourseOffering course){
        return courseList.add(course);
    }

    public boolean removeCourse(CourseOffering course){
        return courseList.remove(course);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public String getName() {
        return name;
    }
}
