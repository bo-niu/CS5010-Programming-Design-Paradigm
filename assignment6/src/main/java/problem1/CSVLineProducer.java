package problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents the producer thread.
 */
public class CSVLineProducer implements Runnable {

    private String dirPath;
    private BlockingQueue<String> buffer;
    private String fileName;
    private static final String POISON_PILL_MESSAGE = "END OF FILE";

    /**
     * Constructor.
     *
     * @param dirPath  OULAD data folder path
     * @param buffer   the shared csv string line queue
     * @param fileName specific file name within the dataset
     */
    public CSVLineProducer(String dirPath, BlockingQueue<String> buffer, String fileName) {
        this.dirPath = dirPath;
        this.buffer = buffer;
        this.fileName = fileName;
    }

    /**
     * The producer thread's working function.
     */
    @Override
    public void run() {
        System.out.println("Starting producer for " + fileName);
        File file = new File(dirPath + "/" + fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            tempString = reader.readLine();
            while ((tempString = reader.readLine()) != null) {
                this.buffer.put(tempString);
            }
            reader.close();
            this.buffer.put(POISON_PILL_MESSAGE);
            System.out.println("this.buffer.put(POISON_PILL_MESSAGE); passed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
