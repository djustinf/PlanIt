package Models.Scheduling;

import Models.People.Faculty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Kris on 2/3/2017.
 */
@Entity
public class Component {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    private CourseOffering offering;

    private String sectionType;
    private int workUnits;
   // private int[] days;
    private int startTime;
    private int endTime;
    //private RoomOffering room;
   // private Faculty faculty;

    public Component() {}

    public Component(String sectionType, int workUnits, int startTime, int endTime){
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.endTime = endTime;
       // days = new int[7];
    }
/*
    public Component(String sectionType, int workUnits, int startTime, int endTime,
                     boolean sun, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat){
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.endTime = endTime;
        days = new int[7];
        if(sun) days[0] = 1;
        if(mon) days[1] = 1;
        if(tues) days[2] = 1;
        if(wed) days[3] = 1;
        if(thurs) days[4] = 1;
        if(fri) days[5] = 1;
        if(sat) days[6] = 1;
    }
    */

    public void setID(String ID) {
        this.id = ID;
    }

    public void setRoom(int roomNum){
        //TODO: Figure this shit out
    }

    public String getID(){
        return id;
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

    public int getEndTime() {
        return endTime;
    }

    public double getDurationHours(){
        return ((double)(endTime - startTime))/2;
    }
/*
    public void setDays(boolean sun, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat){
        if(sun) days[0] = 1;
        if(mon) days[1] = 1;
        if(tues) days[2] = 1;
        if(wed) days[3] = 1;
        if(thurs) days[4] = 1;
        if(fri) days[5] = 1;
        if(sat) days[6] = 1;
    }

    public int[] getDays(){
        return days;
    }
    */
}