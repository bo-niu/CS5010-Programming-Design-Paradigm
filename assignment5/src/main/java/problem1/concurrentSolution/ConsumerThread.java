package problem1.concurrentSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import problem1.structure.Course;
import problem1.structure.StudentV;

/**
 * This class represents the consumer thread.
 */
public class ConsumerThread implements Runnable {

  private BlockingQueue<String> buffer;
  private ConcurrentHashMap<Course, ConcurrentHashMapOperation> map;

  /**
   * The constructor
   *
   * @param buffer the shared blockingqueue recording the csv lines
   * @param map    the concurrent hash map recording the courses vs clicks
   */
  public ConsumerThread(BlockingQueue<String> buffer,
      ConcurrentHashMap<Course, ConcurrentHashMapOperation> map) {
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

        /**
         * here I set a poll time limit to end the loop.
         * Otherwise the thread will be blocked forever when the buffer is empty
         * and the program will never stop.
         */
        csvRecord = buffer.poll(1000, TimeUnit.MILLISECONDS);
        if (csvRecord == null) {
          break;
        }
        List<String> csvElements = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\s*\"(.*?)\"\\s*");
        Matcher matcher = pattern.matcher(csvRecord);
        while (matcher.find()) {
          String find = matcher.group(1);
          csvElements.add(find);
        }
        if (csvElements.size() != 6) {
          System.out.println("csvElements.size() != 6");
        }
        String courseModule = csvElements.get(0);
        String coursePresentation = csvElements.get(1);
        Course course = new Course(courseModule, coursePresentation);

        int studDate = Integer.parseInt(csvElements.get(4));
        int studClick = Integer.parseInt(csvElements.get(5));
        ConcurrentHashMapOperation map2 = map.get(course);
        if (map2 == null) {
          continue;
        }
        map2.changeMap(studDate, studClick);

      }

    } catch (InterruptedException | NullPointerException e) {
      e.printStackTrace();
    }
  }

}
