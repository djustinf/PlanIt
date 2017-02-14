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
    private String name;

    @ManyToOne
    private Schedule sched;

    @OneToMany(mappedBy = "offering", cascade = CascadeType.PERSIST)
    private List<Component> components;

    public CourseOffering() {}

    public CourseOffering(String name, Schedule sched) {
        this.name = sched.getName() + "-" + name;
        this.sched = sched;
        components = new ArrayList<Component>();
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return id;
    }

    public Component addComponent(String sectionType, int workUnits, int startTime, int endTime) {
        Component component = new Component(sectionType, workUnits, startTime, endTime);
        components.add(component);
        return component;
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }
}
