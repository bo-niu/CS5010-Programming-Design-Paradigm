package problem1.concurrentSolution;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import problem1.structure.Course;
import problem1.structure.StudentV;

/**
 * This class represents the concurrent runner that concurrently runs to solve the problem.
 */
public class ConcurrentRunner {

//  public static void main(String[] args) {
//    CLIOption cliOption = new CLIOption();
//    Options options = cliOption.createOptions();
//    CommandLineParser parser = new DefaultParser();
//    try {
//      long startTime=System.currentTimeMillis();
//
//      CommandLine commandLine = parser.parse(options, args);
//      String dirName = commandLine.getOptionValue("dir");
//      String dirPath = "src/main/resources/" + dirName;
//
//      String numThreads = commandLine.getOptionValue("numThreads");
//      int numOfThreads;
//      if (numThreads == null) {
//        System.out.println("numThreads not specified, set to 2 automatically.");
//        numOfThreads = 2;
//      } else {
//        numOfThreads = Integer.parseInt(numThreads);
//      }
//
//      int threshold = 0;
//      String thresholdStr = commandLine.getOptionValue("threshold");
//      if (thresholdStr == null) {
//        System.out.println("threshold not specified, set to 0 automatically.");
//      } else {
//        threshold = Integer.parseInt(thresholdStr);
//      }
//
////      String dirPath  = "src/main/resources/concurrent";// + dirName;
//      ConcurrentRunner concurrentRunner = new ConcurrentRunner();
//      ConcurrentHashMap<Course, StudentVArrayList> map = concurrentRunner.readCourseCSV(dirPath);
//      BlockingQueue<String> buffer = new LinkedBlockingQueue<>(50000);
////      ProducerThread p1  =  new ProducerThread(dirPath, buffer);
//
//      Thread producerThread = new Thread(new ProducerThread(dirPath, buffer));
//      producerThread.start();
//      List<Thread> produceThreadList = new ArrayList<Thread>();
//      for (int i = 0; i < numOfThreads; i++) {
//        Thread consumerThread = new Thread(new ConsumerThread(buffer, map));
//        produceThreadList.add(consumerThread);
//        consumerThread.start();
//      }
//      producerThread.join();
//      for (int i = 0; i < numOfThreads; i++) {
//        produceThreadList.get(i).join();
//      }
//
//      concurrentRunner.writeCSV(map, dirPath);
//      concurrentRunner.writeThreoldFile(map, dirPath, threshold);
//
//      long endTime=System.currentTimeMillis();
//      System.out.println("total running time: "+(endTime-startTime)+"ms");
//
//    } catch (InterruptedException | ParseException e) {
//      cliOption.printHelp(options, e.getMessage());
//    }
//  }

  /**
   * Constructor.
   *
   * @param dirPath course.csv file's path
   * @return the ConcurrentHashMap
   */
  public ConcurrentHashMap<Course, ConcurrentHashMapOperation> readCourseCSV(String dirPath) {
    ConcurrentHashMap<Course, ConcurrentHashMapOperation> map = new ConcurrentHashMap<Course, ConcurrentHashMapOperation>();
    try (Reader reader = Files.newBufferedReader(Paths.get(dirPath, "courses.csv"))) {
      CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
      for (CSVRecord csvRecord : csvParser) {
        String courseModule = csvRecord.get("code_module");
        String coursePresentation = csvRecord.get("code_presentation");
        map.put(new Course(courseModule, coursePresentation),
            new ConcurrentHashMapOperation(new ConcurrentHashMap<Integer, Integer>()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }

  /**
   * Write output csv file.
   *
   * @param map     the shared concurrentHashMap
   * @param dirPath output directory
   */
  public void writeCSV(ConcurrentHashMap<Course, ConcurrentHashMapOperation > map, String dirPath) {
    for (Course course : map.keySet()) {
      String filename = course.getModule() + "_" + course.getPresentation() + ".csv";
      try (Writer writer = Files.newBufferedWriter(Paths.get(dirPath, filename))) {
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
            .withHeader("date", "total_clicks"));
//        List<StudentV> result = map.get(course).getStudentVs();
//        for (StudentV studentV : result) {
//          csvPrinter.printRecord(studentV.getDate(), studentV.getClick());
//        }
        ConcurrentHashMapOperation result = map.get(course);
        List<Integer> dates = new ArrayList<>(result.getMap().keySet());
        Collections.sort(dates);
        for (Integer date : dates) {
          csvPrinter.printRecord(date, result.getMap().get(date));
        }
        csvPrinter.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Write file that filtrates the click times.
   *
   * @param map       the shared map
   * @param dirPath   output directory
   * @param threshold threshold number
   */
  public void writeThresholdFile(ConcurrentHashMap<Course, ConcurrentHashMapOperation> map, String dirPath,
      int threshold) {
    String filename = "activity-" + threshold + ".csv";
    try (Writer writer = Files.newBufferedWriter(Paths.get(dirPath, filename))) {
      CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
          .withHeader("module_presentation", "date", "total_clicks"));
      for (Course course : map.keySet()) {
//        List<StudentV> result = map.get(course).getStudentVs();
//        for (StudentV studentV : result) {
//          if (studentV.getClick() >= threshold) {
//            csvPrinter.printRecord(course.getModule() + "_" + course.getPresentation(),
//                studentV.getDate(), studentV.getClick());
//          }
//        }
        ConcurrentHashMapOperation result = map.get(course);
        List<Integer> dates = new ArrayList<>(result.getMap().keySet());
        Collections.sort(dates);
        for (Integer date : dates) {
          if(result.getMap().get(date) >= threshold) {
            csvPrinter.printRecord(course.getModule() + "_" + course.getPresentation(),
                date, result.getMap().get(date));
          }
        }
        csvPrinter.flush();

      }
    } catch (IOException e) {
      e.printStackTrace();


    }
  }
}
