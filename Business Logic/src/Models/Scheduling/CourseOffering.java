package Models.Scheduling;

import java.util.ArrayList;

/**
 * Created by Justin on 2/11/2017.
 */
public class CourseOffering {

    private Course parent;
    private int ID;
    private String name;
    private ArrayList<Component> components;

    public CourseOffering(String schedName, Course parent) {
        this.name = parent.getName() + "-" + schedName;
        this.parent = parent;
        components = new ArrayList<Component>();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
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
