package problem1.sequentialSolution;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import problem1.structure.Course;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



/**
 * Sequential solution for this project.
 */
public class Sequential {

    private String dirPath;

    Sequential(String dirName){
        this.dirPath  = "src/main/resources/" + dirName;
    }

    /**
     * Reads course.csv in a list of Course.
     *
     * @return a list of Course.
     */
     List<Course> readCourseCSV() {
        List<Course> courses = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(dirPath, "courses.csv"))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord csvRecord : csvParser) {
                String courseModule = csvRecord.get("code_module");
                String coursePresentation = csvRecord.get("code_presentation");
                int courseLength = Integer.parseInt(csvRecord.get("module_presentation_length"));
                courses.add(new Course(courseModule, coursePresentation, courseLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Reads the studentV.csv in a HashMap
     * key = Course
     * value = HashMap(key = date, value = click)
     * @return a HashMap representing the info of studentV.
     */
    private HashMap<Course, HashMap<Integer, Integer>> readStudentCSV() {
        HashMap<Course, HashMap<Integer, Integer>> map = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(dirPath, "studentVle.csv"))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord csvRecord : csvParser) {
                String studModule = csvRecord.get("code_module");
                String studPresentation = csvRecord.get("code_presentation");
                Integer studDate = Integer.parseInt(csvRecord.get("date"));
                Integer studClick = Integer.parseInt(csvRecord.get("sum_click"));
                Course studCourse = new Course(studModule, studPresentation);
                if (map.containsKey(studCourse)) {
                    HashMap<Integer, Integer> innerMap = map.get(studCourse);
                    if (innerMap.containsKey(studDate)) {
                        int click = innerMap.get(studDate);
                        innerMap.put(studDate, click + studClick);
                        map.put(studCourse, innerMap);
                    }
                    else {
                        innerMap.put(studDate, studClick);
                        map.put(studCourse, innerMap);
                    }
                }
                else {
                    HashMap<Integer, Integer> innerMap = new HashMap<>();
                    innerMap.put(studDate, studClick);
                    map.put(studCourse, innerMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Writes the map into multiple csv files.
     * file_name = key
     * columns_1 = value.key
     * columns_2 = value.value
     */
    void writeCSV() {
        HashMap<Course, HashMap<Integer, Integer>> map = readStudentCSV();
        for (Course course : map.keySet()) {
            String filename = course.getModule() + "_" + course.getPresentation() + ".csv";
            try (Writer writer = Files.newBufferedWriter(Paths.get(dirPath, filename))) {
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("date", "total_clicks"));
                HashMap<Integer, Integer> result = map.get(course);
                List<Integer> dates = new ArrayList<>(result.keySet());
                Collections.sort(dates);
                for (Integer date : dates) {
                    csvPrinter.printRecord(date, result.get(date));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}