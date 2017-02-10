package AnalyzerTests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Analytics.Analyzer;

public class AnalyzerTest {

    public static void main(String args[]) {
        Map<Integer, Integer> map = null;
        File studentPrefs = null;
        try {
            studentPrefs = new File(AnalyzerTest.class.getResource("/TestCSVs/\"Student Plan Data Fall 2017.csv\"").toURI());
            map = Analyzer.import_student_prefs(studentPrefs);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (Integer i : map.keySet()) {
            System.out.printf("Class: %d || Students: %d\n", i, map.get(i));
        }
    }
}
