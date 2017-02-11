package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Component {
    private int ID;
    private String sectionType;
    private int workUnits;
    private int startTime;
    private double classHours;

    public Component(String sectionType, int workUnits, int startTime, double classHours){
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.classHours = classHours;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public String getSectionType(){
        return sectionType;
    }

    public int getWorkUnits() {
        return workUnits;
    }

    public int getStartTime() {
        return startTime;
    }

    public double getClassHours() {
        return classHours;
    }
}