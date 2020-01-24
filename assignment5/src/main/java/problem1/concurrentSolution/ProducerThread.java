package problem1.concurrentSolution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents the producer thread.
 */
public class ProducerThread implements Runnable {

  private String dirPath;
  private BlockingQueue<String> buffer;

  /**
   * Constructor.
   *
   * @param dirPath studentvle.csv file path
   * @param buffer  the shared csv string line queue
   */
  public ProducerThread(String dirPath,
      BlockingQueue<String> buffer) {
    this.dirPath = dirPath;
    this.buffer = buffer;
  }

  /**
   * The producer thread's working function.
   */
  @Override
  public void run() {
    System.out.println("Starting producer");
    File file = new File(dirPath + "/studentVle.csv");
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String tempString = null;
      tempString = reader.readLine();
      while ((tempString = reader.readLine()) != null) {
        this.buffer.put(tempString);
      }
      reader.close();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
