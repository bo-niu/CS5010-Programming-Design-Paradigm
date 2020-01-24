package problem1;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * This class represents the concurrent runner that concurrently runs to solve the problem.
 */
public class ConcurrentRunner {

    private ConcurrentHashMap<CourseRecord, ClickNumHashMapOperation> clickNumMaps;
    private ConcurrentHashMap<CourseRecord, ConcurrentHashMap<Integer, String>> assessmentMaps;

    public ConcurrentHashMap<CourseRecord, ClickNumHashMapOperation> getClickNumMaps() {
        return clickNumMaps;
    }

    public ConcurrentHashMap<CourseRecord, ConcurrentHashMap<Integer, String>> getAssessmentMaps() {
        return assessmentMaps;
    }

    public static void main(String[] args) {
        CLIOption cliOption = new CLIOption();
        Options options = cliOption.createOptions();
        CommandLineParser parser = new DefaultParser();
        try {
            long startTime = System.currentTimeMillis();
            //args = new String[]{"--dir", "data", "--numThreads", "4", "--threshold", "11000"};
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

            int threshold = -1;
            String thresholdStr = commandLine.getOptionValue("threshold");
            if (thresholdStr == null) {
                System.out.println("threshold not specified.");
            } else {
                threshold = Integer.parseInt(thresholdStr);
            }

            ConcurrentRunner concurrentRunner = new ConcurrentRunner();
            concurrentRunner.readCourseCSV(dirPath);
            BlockingQueue<String> studentVleBuffer = new LinkedBlockingQueue<>(50000);
            BlockingQueue<String> assessmentBuffer = new LinkedBlockingQueue<>(50000);

            Thread assessmentsProducer = new Thread(new CSVLineProducer(dirPath, assessmentBuffer, "assessments.csv"));
            assessmentsProducer.start();
            Thread studentVleProducer = new Thread(new CSVLineProducer(dirPath, studentVleBuffer, "studentVle.csv"));
            studentVleProducer.start();
            Thread assessmentsConsumer = new Thread(new AssessmentsPreprocess(assessmentBuffer, concurrentRunner.getAssessmentMaps()));
            assessmentsConsumer.start();
            List<Thread> consumerThreadList = new ArrayList<>();
            for (int i = 0; i < numOfThreads; i++) {
                Thread studentVleConsumer = new Thread(new StudentVlePreprocess(studentVleBuffer, concurrentRunner.getClickNumMaps()));
                studentVleConsumer.start();
                consumerThreadList.add(studentVleConsumer);
            }

            assessmentsProducer.join();
            studentVleProducer.join();
            assessmentsConsumer.join();
            for (int i = 0; i < numOfThreads; i++) {
                consumerThreadList.get(i).join();
            }
            long processTime = System.currentTimeMillis();
            System.out.println("Reading time: " + (processTime - startTime) + "ms");

            ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
            for (CourseRecord course : concurrentRunner.getClickNumMaps().keySet()) {
                executorService.execute(new IndependentProcess(course.getModule() + "_" + course.getPresentation() + ".csv", dirPath,
                        concurrentRunner.getClickNumMaps().get(course).getMap(),
                        concurrentRunner.getAssessmentMaps().get(course)));
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            long writeCSVTime = System.currentTimeMillis();
            System.out.println("Writing time for all courses: " + (writeCSVTime - processTime) + "ms");

            if (threshold != -1) {
                ThresholdWriter thresholdWriter = new ThresholdWriter();
                thresholdWriter.writeThreshold(threshold, dirPath, concurrentRunner.getClickNumMaps(), concurrentRunner.getAssessmentMaps());
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Writing time for threshold : " + (endTime - writeCSVTime) + "ms");
            System.out.println("Total running time: " + (endTime - startTime) + "ms");

        } catch (InterruptedException | ParseException e) {
            cliOption.printHelp(options, e.getMessage());
        }
    }

    /**
     * Constructor.
     *
     * @param dirPath course.csv file's path
     */
    public void readCourseCSV(String dirPath) {
        clickNumMaps = new ConcurrentHashMap<>();
        assessmentMaps = new ConcurrentHashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(dirPath, "courses.csv"))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord csvRecord : csvParser) {
                String courseModule = csvRecord.get("code_module");
                String coursePresentation = csvRecord.get("code_presentation");
                clickNumMaps.put(new CourseRecord(courseModule, coursePresentation),
                        new ClickNumHashMapOperation(new ConcurrentHashMap<>()));
                assessmentMaps.put(new CourseRecord(courseModule, coursePresentation),
                        new ConcurrentHashMap<>());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
