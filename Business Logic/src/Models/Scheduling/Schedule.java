package Models.Scheduling;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        courseList = new List<CourseOffering>();
        comments = new List<Comment>();
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
}
