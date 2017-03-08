package Models.Scheduling;

import Models.People.Faculty;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kris on 2/3/2017.
 */
@Entity
public class Component {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JsonBackReference(value = "component")
    private CourseOffering offering;

    private String sectionType;
    private int workUnits;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> days;

    private int startTime;
    private int endTime;

    @ManyToOne
    @JsonBackReference(value = "components")
    private RoomOffering roomOffering;

    @ManyToOne
    @JsonBackReference(value = "faculty")
    private Faculty faculty;

    protected Component() {}

    public Component(String sectionType, int workUnits, int startTime, int endTime, CourseOffering offering, RoomOffering room, Faculty faculty, int section){
        roomOffering = room;
        this.faculty = faculty;
        this.offering = offering;
        this.sectionType = sectionType;
        this.name = offering.getName() + "-" + sectionType + Integer.toString(section);
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.endTime = endTime;
        days = new ArrayList<String>();
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setRoom(RoomOffering room){
        this.roomOffering = room;
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

    public String getName() {
        return name;
    }

    public void setCourseOffering(CourseOffering offering) {
        this.offering = offering;
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

    public void setDays(boolean sun, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat){
        if(sun)
            days.add("sunday");
        if(mon)
            days.add("monday");
        if(tues)
            days.add("tuesday");
        if(wed)
            days.add("wednesday");
        if(thurs)
            days.add("thursday");
        if(fri)
            days.add("friday");
        if(sat)
            days.add("saturday");
    }

    public List<String> getDays(){
        return days;
    }

}