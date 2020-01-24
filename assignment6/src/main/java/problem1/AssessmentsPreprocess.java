package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the consumer thread for reading assessment.csv.
 */
public class AssessmentsPreprocess implements Runnable {

    private static final String POISON_PILL_MESSAGE = "END OF FILE";
    private BlockingQueue<String> buffer;
    private ConcurrentHashMap<CourseRecord, ConcurrentHashMap<Integer, String>> map;

    /**
     * The constructor
     *
     * @param buffer the shared blockingQueue recording the csv lines
     * @param map    the concurrent hash map recording the courses vs clicks
     */
    public AssessmentsPreprocess(BlockingQueue<String> buffer,
                                 ConcurrentHashMap<CourseRecord, ConcurrentHashMap<Integer, String>> map) {
        this.buffer = buffer;
        this.map = map;
    }

    /**
     * Consumer thread's run function.
     */
    @Override
    public void run() {

        String csvRecord = null;
        try {
            while (true) {
                csvRecord = buffer.take();
                if (csvRecord.equals(POISON_PILL_MESSAGE)) {
                    this.buffer.put(POISON_PILL_MESSAGE);
                    System.out.println("AssessmentsPreprocess: POISON_PILL_MESSAGE get");
                    break;
                }
                List<String> csvElements = new ArrayList<>();
                Pattern pattern = Pattern.compile("\\s*\"(.*?)\"\\s*");
                Matcher matcher = pattern.matcher(csvRecord);
                while (matcher.find()) {
                    String find = matcher.group(1);
                    csvElements.add(find);
                }
                if (csvElements.size() != 6) {
                    System.out.println("csvElements.size() != 6");
                    continue;
                }
                String courseModule = csvElements.get(0);
                String coursePresentation = csvElements.get(1);
                CourseRecord course = new CourseRecord(courseModule, coursePresentation);
                String dateStr = csvElements.get(4);
                if (!dateStr.equals("")) {
                    int date = Integer.parseInt(dateStr);
                    String assessment_type = csvElements.get(3);
                    ConcurrentHashMap<Integer, String> map2 = map.get(course);
                    if (map2 == null) {
                        continue;
                    }
                    map2.put(date, assessment_type);
                }
            }

        } catch (InterruptedException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
