package Models.Scheduling;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 2/11/2017.
 */

@Entity
public class CourseOffering {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Schedule sched;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "offering", cascade = CascadeType.PERSIST)
    private List<Component> components;

    protected CourseOffering() {}

    public CourseOffering(String name, Schedule sched) {
        this.name = sched.getFullName() + "-" + name;
        this.sched = sched;
        components = new ArrayList<Component>();
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return id;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }
}
