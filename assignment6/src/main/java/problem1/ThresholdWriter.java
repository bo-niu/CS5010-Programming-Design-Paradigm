package problem1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents the process for writing threshold file.
 */
public class ThresholdWriter {

    public void writeThreshold(int threshold, String dirPath,
                               ConcurrentHashMap<CourseRecord, ClickNumHashMapOperation> clickNumMap,
                               ConcurrentHashMap<CourseRecord, ConcurrentHashMap<Integer, String>> assessmentMap) {
        String filename = "activity-" + threshold + ".csv";
        try (Writer writer = Files.newBufferedWriter(Paths.get(dirPath, filename))) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("module_presentation", "date", "normalized_date", "total_click",
                            "relative_click", "assessment_type"));
            for (CourseRecord courseRecord : clickNumMap.keySet()) {
                ConcurrentHashMap<Integer, Integer> result = clickNumMap.get(courseRecord).getMap();
                int size = result.size();
                int sum = 0;
                for (Integer date : result.keySet()) {
                    sum += result.get(date);
                }
                double avg = sum * 1.0 / size;
                List<Integer> dates = new ArrayList<>(result.keySet());
                Collections.sort(dates);
                double length = dates.get(size - 1);

                for (Integer date : dates) {
                    if (result.get(date) >= threshold) {
                        csvPrinter.printRecord(courseRecord.getModule() + "_" + courseRecord.getPresentation(),
                                date, date / length, result.get(date),
                                result.get(date) / avg, assessmentMap.get(courseRecord).get(date));
                    }
                }
                csvPrinter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
