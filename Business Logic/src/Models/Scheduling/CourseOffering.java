package Models.Scheduling;

import java.util.ArrayList;

/**
 * Created by Justin on 2/11/2017.
 */
public class CourseOffering {

    private int ID;
    private String name;
    private ArrayList<Component> components;

    public CourseOffering(Integer courseID, Integer termYear, String termName) {
        this.name = courseID.toString() + termName + termYear.toString();
        components = new ArrayList<Component>();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public Component addComponent(String sectionType, int workUnits, int startTime, double classHours) {
        Component component = new Component(sectionType, workUnits, startTime, classHours);
        components.add(component);
        return component;
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }
}
