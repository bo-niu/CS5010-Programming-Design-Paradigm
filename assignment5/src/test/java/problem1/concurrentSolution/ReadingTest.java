package problem1.concurrentSolution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import problem1.structure.Course;
import problem1.structure.StudentV;

public class ReadingTest {

//  public static void main(String[] args){
////    long startTime=System.currentTimeMillis();
////    File file = new File("src/main/resources/concurrent/2/studentVle.csv");
////    Queue<String> buffer = new LinkedList<String>();
////    BufferedReader reader = null;
////    try {
////      reader = new BufferedReader(new FileReader(file));
////      String csvRecord = null;
////      csvRecord = reader.readLine();
////      Pattern pattern = Pattern.compile("\\s*\"(.*?)\"\\s*");
////      while ((csvRecord = reader.readLine()) != null) {
//////        buffer.add(tempString);
////        List<String> csvElements = new ArrayList<String>();
////        Matcher matcher = pattern.matcher(csvRecord);
////        while (matcher.find()) {
////          String find = matcher.group(1);
////          csvElements.add(find);
////        }
////      }
////      reader.close();
////      long endTime=System.currentTimeMillis();
////      System.out.println("total running time: "+(endTime-startTime)+"ms");
////    } catch (IOException e) {
////      e.printStackTrace();
////    }
//
//
//
////    long startTime=System.currentTimeMillis();
////    List<StudentV> studentVs = new ArrayList<>();
////    try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/concurrent/2", "studentVle.csv"))) {
////      CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
////      for (CSVRecord csvRecord : csvParser) {
////        String studModule = csvRecord.get("code_module");
////        String studPresentation = csvRecord.get("code_presentation");
////          int studDate = Integer.parseInt(csvRecord.get("date"));
////          int studClick = Integer.parseInt(csvRecord.get("sum_click"));
////      }
////            long endTime=System.currentTimeMillis();
////      System.out.println("total running time: "+(endTime-startTime)+"ms");
////    } catch (IOException e) {
////      e.printStackTrace();
////    }
//  }
}
