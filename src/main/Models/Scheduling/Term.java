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
    private String termName;
    private int termYear;

    @OneToMany(mappedBy = "term", cascade = CascadeType.PERSIST)
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Term () {}

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
