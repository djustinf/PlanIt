package Models.People;
import java.util.HashMap;
import java.util.Map;

public class Faculty extends User {
    private static final int DAYS_IN_WEEK = 7;
    private static final int INTERVALS_PER_DAY = 48;

    private int[][] preferredTimes = new int[DAYS_IN_WEEK][INTERVALS_PER_DAY];
    private int preferredTotalHours;// workload preference
    private Map<Integer, Integer> coursePreferences = new HashMap<>();// course preferences -1, 0, 1 <=> CANNOT, CAN, PREFER

    public Faculty(int userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    private boolean addCoursePref(int courseNum, int prefLvl) {
        if (prefLvl >= -1 && prefLvl <= 1) {
            coursePreferences.put(courseNum, prefLvl);
            return true;
        }
        return false;
    }

    private boolean addTimePref(int day, int interval, int prefLvl){
        if (prefLvl >= -1 && prefLvl <= 1
                && day >= 0 && day < DAYS_IN_WEEK
                && interval >= 0 && interval <= INTERVALS_PER_DAY) {
            preferredTimes[day][interval] = prefLvl;
            return true;
        }
        return false;
    }

    private boolean setWeeklyHoursPref(int total) {
        if (0 < total && total <= 168) {
            preferredTotalHours = total;
            return true;
        }
        return false;
    }
}