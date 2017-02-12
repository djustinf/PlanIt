package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Component {
    private int ID;
    private String sectionType;
    private int workUnits;
    private int[] days;
    private int startTime;
    private int endTime;
    private RoomOffering room;

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRoom(int roomNum){
        this.room = new RoomOffering(roomNum);
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

    public int getEndTime() {
        return endTime;
    }

    public double getDurationHours(){
        return ((double)(endTime - startTime))/2;
    }

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
}