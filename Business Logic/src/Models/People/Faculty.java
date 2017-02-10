package Models.People;

public class Faculty extends User {
    private static final int DAYS_IN_WEEK = 7;
    private static final int THIRTY_MIN_INTERVALS_PER_DAY = 48;

    private int[][] preferredTimes = new int[DAYS_IN_WEEK][THIRTY_MIN_INTERVALS_PER_DAY];
    private int preferredTotalHours;// workload preference
    private int[] coursePreferences = new int[40];// course preferences -1, 0, 1 <=> CANNOT, CAN, PREFER

    public Faculty(int userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    public void setPreferences() {
        return;
    }

    private boolean addCoursePref(int courseNum, int prefLvl) {
        if (prefLvl >= -1 && prefLvl <= 1) {
            coursePreferences[courseHash(courseNum)] = prefLvl;
            return true;
        }
        return false;
    }

    private boolean addTimePref(int day, int interval, int prefLvl){
        if (prefLvl >= -1 && prefLvl <= 1 && day >= 0 && day <= 6 && interval >= 0 && interval <= 47) {
            preferredTimes[day][interval] = prefLvl;
            return true;
        }
        return false;
    }

    private boolean setWeeklyHoursPref(int total){
        if(0<total && total <= 168){
            preferredTotalHours = total;
            return true;
        }
        return false;
    }

    public int courseHash(int courseNum){
        int baseCourse = 101;
        int index = 0;

        index = courseNum - baseCourse;
        //do more shit here
        return 0;
    }
}