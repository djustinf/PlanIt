package Models.Scheduling;

import java.util.List;

/**
 * Created by Landon on 2/11/2017.
 */
public class RoomOffering {
    private Room parent;
    private int[][] availability;
    private List<Component> components;

    private static final int DAYS_IN_WEEK = 7;
    private static final int INTERVALS_PER_DAY = 48;

    public RoomOffering(Room parent){
        this.parent = parent;
        availability = new int[DAYS_IN_WEEK][INTERVALS_PER_DAY];
        components = new List<Component>();
    }

    public void addComponent(Component c){
        components.add(c);

    }

}
