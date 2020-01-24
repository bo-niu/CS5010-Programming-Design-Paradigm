package problem1.concurrentSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Before;
import org.junit.Test;
import problem1.structure.CLIOption;
import problem1.structure.Course;

public class ConcurrentRunnerTest {


  @Test
  public void run() {
    CLIOption cliOption = new CLIOption();
    Options options = cliOption.createOptions();
    CommandLineParser parser = new DefaultParser();
    try {
      String[] args = {"--dir", "data", "--numThreads", "2", "--threshold", "11000"};
      long startTime=System.currentTimeMillis();
      CommandLine commandLine = parser.parse(options, args);
      String dirName = commandLine.getOptionValue("dir");
      String dirPath = "src/main/resources/" + dirName;

      String numThreads = commandLine.getOptionValue("numThreads");
      int numOfThreads;
      if (numThreads == null) {
        System.out.println("numThreads not specified, set to 2 automatically.");
        numOfThreads = 2;
      } else {
        numOfThreads = Integer.parseInt(numThreads);
      }

      int threshold = 0;
      String thresholdStr = commandLine.getOptionValue("threshold");
      if (thresholdStr == null) {
        System.out.println("threshold not specified, set to 0 automatically.");
      } else {
        threshold = Integer.parseInt(thresholdStr);
      }

//      String dirPath  = "src/main/resources/concurrent";// + dirName;
      ConcurrentRunner concurrentRunner = new ConcurrentRunner();
      ConcurrentHashMap<Course, ConcurrentHashMapOperation> map = concurrentRunner.readCourseCSV(dirPath);
      BlockingQueue<String> buffer = new LinkedBlockingQueue<>(50000);
//      ProducerThread p1  =  new ProducerThread(dirPath, buffer);

      Thread producerThread = new Thread(new ProducerThread(dirPath, buffer));
      producerThread.start();
      List<Thread> produceThreadList = new ArrayList<Thread>();
      for (int i = 0; i < numOfThreads; i++) {
        Thread consumerThread = new Thread(new ConsumerThread(buffer, map));
        produceThreadList.add(consumerThread);
        consumerThread.start();
      }
      producerThread.join();
      for (int i = 0; i < numOfThreads; i++) {
        produceThreadList.get(i).join();
      }

      concurrentRunner.writeCSV(map, dirPath);
      concurrentRunner.writeThresholdFile(map, dirPath, threshold);

      long endTime=System.currentTimeMillis();
      System.out.println("total running time: "+(endTime-startTime)+"ms");

    } catch (InterruptedException | ParseException e) {
      cliOption.printHelp(options, e.getMessage());
    }
  }

}