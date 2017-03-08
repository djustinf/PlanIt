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
    private List<Integer> days;

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
        this.name = offering.getName() + "-" + Integer.toString(section);
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.endTime = endTime;
        days = new ArrayList<Integer>();
    }

    public Component(String sectionType, int workUnits, int startTime, int endTime,
                     boolean sun, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat){
        this.sectionType = sectionType;
        this.workUnits = workUnits;
        this.startTime = startTime;
        this.endTime = endTime;
        days = new ArrayList<Integer>();
        if(sun) days.add(0, 1);
        if(mon) days.add(1, 1);
        if(tues) days.add(2, 1);
        if(wed) days.add(3, 1);
        if(thurs) days.add(4, 1);
        if(fri) days.add(5, 1);
        if(sat) days.add(6, 1);
    }

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

    public String getName() {
        return name;
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
        if(sun) days.add(0, 1);
        if(mon) days.add(1, 1);
        if(tues) days.add(2, 1);
        if(wed) days.add(3, 1);
        if(thurs) days.add(4, 1);
        if(fri) days.add(5, 1);
        if(sat) days.add(6, 1);
    }

    public List<Integer> getDays(){
        return days;
    }

}