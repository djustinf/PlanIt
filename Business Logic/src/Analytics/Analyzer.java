package Analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Analyzer {

    /* Exception has to be handled by calling function. most likely cause would be
     * an inability to open the file (permission, existence, etc)
     */
    public static Map<Integer, Integer> import_student_prefs(File csvFile) throws IOException{
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();
        String nextLine;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        //begin reading
        reader.readLine(); //consume first line since it's useless (just a header, no data)
        while ((nextLine = reader.readLine()) != null) {
            // We want index 5 [class num], and index 10 [seat demand]
            String fields[] = nextLine.split(",");
            try {
                data.put(Integer.parseInt(fields[5]), Integer.parseInt(fields[10]));
            }
            catch (Exception e) { //ignore malformed input
                continue;
            }
        }
        return data;
    }

    public static Map<String, Map<Integer, Integer>> import_cohort_data(File csvFile) throws IOException {
        Map<String, Map<Integer, Integer>> data = new HashMap<String, Map<Integer, Integer>>();
        data.put("Fall", new HashMap<Integer, Integer>());
        data.put("Winter", new HashMap<Integer, Integer>());
        data.put("Spring", new HashMap<Integer, Integer>());
        String nextLine;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        //begin reading
        for (int i = 0; i < 10; i++)
            reader.readLine(); //consume header, not useful to us
        while ((nextLine = reader.readLine()) != null) {
            String fields[] = nextLine.split(",");
            int classNum;
            try {
                classNum = Integer.parseInt(fields[0]); //navigates to the next class to grab data
                //[1]->fall | [2]->winter | [3]->spring
                fields = nextLine.split(",");
                data.get("Fall").put(classNum, Integer.parseInt(fields[1]));
                data.get("Winter").put(classNum, Integer.parseInt(fields[2]));
                data.get("Spring").put(classNum, Integer.parseInt(fields[3]));
            }
            catch (Exception e) { //ignore malformed input
                continue;
            }
        }
        return data;

    }
}