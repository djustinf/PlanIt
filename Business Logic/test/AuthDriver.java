import java.util.Scanner;
import Models.People.*;
public class AuthDriver {
    static String[][] lilDB = new String[10][3];

    public static void main(String[] args){
        String userID = "";
        String password = "";
        User user = null;
        int i = 0;

        lilDB[0][0] = "LWoollard";
        lilDB[0][1] = "1123";
        lilDB[0][2] = "Dept.Sched.";
        lilDB[1][0] = "JTaylor";
        lilDB[1][1] = "FratDouche";
        lilDB[1][2] = "Dept.Sched.";
        lilDB[2][0] = "TMcCandles";
        lilDB[2][1] = "Marathon";
        lilDB[2][2] = "Faculty";
        lilDB[3][0] = "RHods";
        lilDB[3][1] = "Farquad";
        lilDB[3][2] = "Faculty";
        lilDB[4][0] = "Namey";
        lilDB[4][1] = "McNameface";
        lilDB[4][2] = "Faculty";
        lilDB[5][0] = "SPrefontaine";
        lilDB[5][1] = "Cortez";
        lilDB[5][2] = "Dept.Sched.";
        lilDB[6][0] = "ARogers";
        lilDB[6][1] = "GBP";
        lilDB[6][2] = "Faculty";
        lilDB[7][0] = "BWick";
        lilDB[7][1] = "password";
        lilDB[7][2] = "Faculty";
        lilDB[8][0] = "A";
        lilDB[8][1] = "1";
        lilDB[8][2] = "Faculty";
        lilDB[9][0] = "B";
        lilDB[9][1] = "2";
        lilDB[9][2] = "Faculty";
        Scanner ui = new Scanner(System.in);
        do {
            System.out.println("Enter Username:");
            userID = ui.nextLine();
            System.out.println("Enter Password:");
            password = ui.nextLine();
            if (checkCreds(userID, password) == true) {
                break;
            }
            i++;
            System.out.printf("Invalid Password\nYou have %d more attempts\n\n", 3-i);
        }while(i < 3);
        if (i >= 3)
        {
            System.out.printf("Too many invalid attempts, System LOCKED!!");
        }
        return;
    }

    public static boolean checkCreds(String uid, String pword){

        if(pword.equals(""))
        {
            directUser("", "Guest");
            return true;
        }
        for(int i = 0; i<10; i++)
        {
            if(lilDB[i][0].equals(uid))
            {
                if(lilDB[i][1].equals(pword))
                {
                    directUser(uid, lilDB[i][2]);
                    return true;
                }
            }
        }
        return false;
    }

    public static User directUser(String uid, String level){
        User user;
        if(level.equals("Dept.Sched."))
        {
            user = new DepartmentScheduler(112358, "Strings", "From", "Database", "here");
        }
        else if(level.equals("Faculty"))
        {
            user = new Faculty(69, "Strings", "From", "Database", "here");
        }
        else
        {
            user = new User(1337, "Strings", "From", "Database", "here");
        }
        return user;
    }
}