package Models.Scheduling;

import java.util.List;

/**
 * Java representation of a schedule.
 *
 * @author Kris Campos
 * @version initial - 2/3/2017.
 */
public class Schedule {
    private Term term;
    List<Course> courseList; // one entry per course in DB
    List<Comment> comments;

    // getters and setters

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getTermName() {
        return term.getTermName();
    }

    public void setTermName(String name) {
        term.setTermName(name);
    }

    public int getTermYear() {
        return term.getTermYear();
    }

    public void setTermYear(int year) {
        term.setTermYear(year);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
