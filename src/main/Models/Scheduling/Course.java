package Models.Scheduling;

import Models.People.Faculty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kris on 2/3/2017.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "course", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "offerings")
    private List<CourseOffering> offerings;

    protected Course() {}

    public Course(String name) {
        this.name = name;
        offerings = new ArrayList<CourseOffering>();
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addOffering(CourseOffering offer) {
        offerings.add(offer);
    }

    public void removeOffering(CourseOffering offer) {
        offerings.remove(offer);
    }

    public List<CourseOffering> getOfferings() {
        return offerings;
    }

}
