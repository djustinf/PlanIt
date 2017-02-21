package Models.Scheduling;

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

    //@ManyToOne
    //private Room room;

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
    private List<Integer> availability;

    @ManyToOne
    private Schedule sched;

    @OneToMany(mappedBy = "roomOffering", cascade = CascadeType.PERSIST)
    private List<Component> components = new ArrayList<Component>();

    private static final int DAYS_IN_WEEK = 7;
    private static final int INTERVALS_PER_DAY = 48;

    public RoomOffering(Schedule sched, String name){
        this.name = sched.getFullName() + "-" + name;
        this.sched = sched;
        availability = new ArrayList<Integer>();
        for(int i = 0; i<DAYS_IN_WEEK*INTERVALS_PER_DAY; i++){
                availability.add(i, 0); //New rooms start out entirely unoccupied
        }
        components = new ArrayList<Component>();
    }

    protected RoomOffering() {}

    public void addComponent(Component c){
        components.add(c);
        int listIndex;
        List<Integer> days = c.getDays();
        for(int i = 0; i<7; i++){
            if(days.get(i) == 1){
                for(int j = c.getStartTime(); j<c.getEndTime(); j++){
                    listIndex = i*INTERVALS_PER_DAY + j;
                    availability.set(listIndex, availability.get(listIndex)+1);
                }
            }
        }

    }
}
