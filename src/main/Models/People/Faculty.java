package Models.People;
import Models.Chunks.Chunk;
import Models.Chunks.FacultyChunk;
import Models.Scheduling.Course;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Faculty extends User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private static final int DAYS_IN_WEEK = 7;
    private static final int INTERVALS_PER_DAY = 48; //30 min intervals

    /* each second-index indicates a 30 minute interval.
    * if there is a 1 in days[3][14] that means this professor would prefer to teach wednesday from 7:00 AM - 7:30 AM
    *
    * UPDATE
    * this has been linearized. Now the above example would be 1 = availability.get(3*INTERVALS_PER_DAY + 14)
    * 0 - [12:00 AM, 12:30 AM]
    * 1 - [12:30 AM, 1:00 AM]
    * 2 - [1:00 AM, 1:30 AM]
    * 3 - [1:30 AM, 2:00 AM]
    * 4 - [2:00 AM, 2:30 AM]
    * ...
    * 46 - [11:00 PM, 11:30 PM]
    * 47 - [11:30 PM, 12:00 AM]*/
    @ElementCollection
    private List<Integer> preferredTimes;
    private int preferredTotalHours;// workload preference

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Integer, Integer> coursePreferences = new HashMap<Integer, Integer>();// course preferences -1, 0, 1 <=> CANNOT, CAN, PREFER

    @ManyToMany(mappedBy = "faculty", cascade = CascadeType.PERSIST) //Doesn't map well with hashmap currently in place
    private List<Course> courses;

    protected Faculty() {}

    public Faculty(String userName, String email, String firstName, String lastName) {
        super(userName, email, firstName, lastName);
        preferredTimes = new ArrayList<Integer>();
        for(int i = 0; i<DAYS_IN_WEEK*INTERVALS_PER_DAY; i++){
            int rem = i%48;
            if (i/48 == 0 || i/48 == 7)//if day is Sunday OR Saturday
                preferredTimes.add(i,-1); //undpreferred by default
            else if ((rem >= 0 && rem <= 13) || (rem >= 44 && rem <= 47))//12AM-7AM OR 10PM-12AM
                preferredTimes.add(i, -1); //unpreferred by default
            else
            preferredTimes.add(i, 0); //All Other Times Neutral by default
        }
    }

    public boolean addCoursePref(int courseNum, int prefLvl) {
        if (prefLvl >= -1 && prefLvl <= 1) {
            coursePreferences.put(courseNum, prefLvl);
            return true;
        }
        return false;
    }

    public boolean addTimePref(int day, int interval, int prefLvl){
        if (prefLvl >= -1 && prefLvl <= 1
                && day >= 0 && day < DAYS_IN_WEEK
                && interval >= 0 && interval <= INTERVALS_PER_DAY) {
            preferredTimes.set(INTERVALS_PER_DAY*day + interval, prefLvl);
            return true;
        }
        return false;
    }

    public boolean setWeeklyHoursPref(int total) {
        if (0 < total && total <= 168) {
            preferredTotalHours = total;
            return true;
        }
        return false;
    }

    /*public ArrayList<Chunk> preferencesToChunks(){
        int chunki = 0;
        int currentChunkVal;
        ArrayList<Chunk> chunks = new ArrayList<Chunk>();
        for(int dayi = 0; dayi < DAYS_IN_WEEK; dayi++){
            currentChunkVal = preferredTimes[dayi][0];
            //started day in a chunk
            if(currentChunkVal != 0){
                chunks.set(chunki, new FacultyChunk(getUserID(), dayi, 0, currentChunkVal));
            }
            for(int houri = 1; houri < INTERVALS_PER_DAY; houri++) {
                //chunk to chunk
                if ((currentChunkVal != 0) && (preferredTimes[dayi][houri] == -1 * currentChunkVal)) {
                    //end last chunk, start new chunk
                    currentChunkVal = preferredTimes[dayi][houri];
                    chunks.get(chunki).setEnd(houri - 1);
                    chunki++;
                    chunks.set(chunki, new FacultyChunk(getUserID(), dayi, houri, currentChunkVal));
                }
                //chunk to 0
                else if (preferredTimes[dayi][houri] == 0 && currentChunkVal != 0) {
                    //end current chunk
                    currentChunkVal = 0;
                    chunks.get(chunki).setEnd(houri-1);
                    chunki++;
                }
                //0 to chunk
                else if (preferredTimes[dayi][houri] != 0 && currentChunkVal == 0) {
                    //start new chunk
                    chunks.set(chunki, new FacultyChunk(getUserID(), dayi, houri, currentChunkVal));
                }
            }
            //ended day in a chunk
            if(currentChunkVal != 0) {
                chunks.get(chunki).setEnd(INTERVALS_PER_DAY-1);
                chunki++;
            }
        }
        return chunks;
    }*/
}