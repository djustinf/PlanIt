package Models.Scheduling;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kris on 2/3/2017.
 */
@Entity
public class Term {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String uniqueName;

    private String termName;

    private int termYear;

    @OneToMany(mappedBy = "term", cascade = CascadeType.PERSIST)
    private List<Schedule> schedules = new ArrayList<Schedule>();

    protected Term () {}

    public Term (String name, int year) {
        termName = name;
        termYear = year;
        genName();
    }

    public void genName() {
        uniqueName = termName + Integer.toString(termYear);
    }

    public String getId() {
        return id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public int getTermYear() {
        return termYear;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setTermYear(int termYear) {
        this.termYear = termYear;
    }

    public void addSched(Schedule sched) {
        schedules.add(sched);
    }

    public void removeSched(Schedule sched) {
        schedules.remove(sched);
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
