package problem1;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * A process writes generated HashMap for given course into a csv file.
 */
public class IndependentProcess implements Runnable {

    private String fileName;
    private String dirPath;
    private ConcurrentHashMap<Integer, Integer> clickNumMap;
    private ConcurrentHashMap<Integer, String> assessmentMap;
    
  /**
   * Constructor.
   *
   * @param fileName output file's name
   * @param dirPath output file's path
   * @param clickNumMap the course's clickNumHashMap
   * @param assessmentMap the course's assessmentHashMap
   */
    public IndependentProcess(String fileName, String dirPath,
                              ConcurrentHashMap<Integer, Integer> clickNumMap,
                              ConcurrentHashMap<Integer, String> assessmentMap) {
        this.fileName = fileName;
        this.dirPath = dirPath;
        this.clickNumMap = clickNumMap;
        this.assessmentMap = assessmentMap;
    }

    @Override
    public void run() {

        try (Writer writer = Files.newBufferedWriter(Paths.get(dirPath, fileName))) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("date", "normalized_date", "total_click", "relative_click", "assessment_type"));
            int size = clickNumMap.size();
            int sum = 0;
            for (Integer date : clickNumMap.keySet()) {
                sum += clickNumMap.get(date);
            }
            double avg = (double) sum / size;
            List<Integer> dates = new ArrayList<>(clickNumMap.keySet());
            Collections.sort(dates);
            double length = dates.get(size - 1);
            for (Integer date : dates) {
                csvPrinter.printRecord(date, date / length, clickNumMap.get(date),
                        (clickNumMap.get(date) / avg), assessmentMap.get(date));
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
