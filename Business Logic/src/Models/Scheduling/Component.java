package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Component {
    private int sectionID;
    private String sectionType;
    private int workUnits;
    private int startTime;
    private double classHours;

    public Component(int sectionID, String sectionType, int workUnits,
                     int startTime, double classHours){
        this.sectionID = sectionID;
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.classHours = classHours;
    }

    public int getSectionID(){
        return sectionID;
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