package Models.Scheduling;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Landon on 2/11/2017.
 */
@Entity
public class RoomOffering {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    /* each second-index indicates a 30 minute interval, each increment of 1 shows an occupancy.
    * if there is a 2 in days[3][14] that means this room has two courses scheduled on wednesday from 7:00 AM - 7:30 AM
    *
    * UPDATE
    * this has been linearized. Now the above example would be 2 = availability.get(3*INTERVALS_PER_DAY + 14)
    * 0 - [12:00 AM, 12:30 AM]
    * 1 - [12:30 AM, 1:00 AM]
    * 2 - [1:00 AM, 1:30 AM]
    * 3 - [1:30 AM, 2:00 AM]
    * 4 - [2:00 AM, 2:30 AM]
    * ...
    * 46 - [11:00 PM, 11:30 PM]
    * 47 - [11:30 PM, 12:00 AM]*/
    @ElementCollection
    private List<String> availability;

    @ManyToOne
    @JsonBackReference(value = "roomList")
    private Schedule sched;

    @ManyToOne
    @JsonBackReference(value = "offerings")
    private Room room;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "roomOffering", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "components")
    private List<Component> components = new ArrayList<Component>();

    private static final int DAYS_IN_WEEK = 7;
    private static final int INTERVALS_PER_DAY = 48;

    public RoomOffering(Schedule sched, String name){
        this.name = sched.getFullName() + "-" + name;
        this.sched = sched;
        availability = new ArrayList<String>();
        components = new ArrayList<Component>();
    }

    protected RoomOffering() {}

    //FIXME broke when I had to change days to strings
    //I think I fixed it!, but we lost the unique availability by day. Changing something creates a duplicate day/availability entry.
    //this could create some conflicts that don't really exist.
    public void addComponent(Component c){
        components.add(c);
        List<String> days = c.getDays();
        for(int i = 0; i<days.size(); i++) {
            for(int j = c.getStartTime(); j<c.getEndTime(); j++) {
                 availability.add(days.get(i)+j);
            }
        }
    }
}
