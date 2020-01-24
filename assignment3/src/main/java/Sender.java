import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sender class plays the role as taking the command line arguments as input which containing the
 * input csv file, template file, output directory, and will output the final mail text file.
 */
public class Sender {

  private ArrayList<Mail> mailList;

  /**
   * Constructor of Sender class.
   */
  public Sender() {
    this.mailList = new ArrayList<Mail>();
  }

  /**
   * Main function. Deal with all kinds of exceptions thrown during the running.
   *
   * @param args command line argument
   */
  public static void main(String[] args) {

    Sender sender = new Sender();
    try {
      sender.run(args);
    } catch (IllegalArgumentException e) {

      System.out.println(e.toString());
      System.out.println(
          "Usage:\n"
              + "--email only generate email messages\n"
              + "--email-template <file> accept a filename that holds the\n"
              + "email template.\n"
              + "Required if --email is used\n"
              + "--letter only generate letters\n"
              + "--letter-template <file> accept a filename that holds\n"
              + "the email template.\n"
              + "Required if --letter is used\n"
              + "--output-dir <path> accept the name of a folder, all\n"
              + "output is placed in this folder\n"
              + "--csv-file <path> accept the name of the csv file to\n"
              + "process\n"
              + "Examples:\n"
              + "--email --email-template email-template.txt --output-dir\n"
              + "emails --csv-file customer.csv"
      );

    } catch (FileNotFoundException e) {

      System.out.println(e.toString());
      e.printStackTrace();
    } catch (IOException e) {

      System.out.println(e.toString());
      e.printStackTrace();
    }
  }

  /**
   * Run the whole process.
   *
   * @param args input command line arguments
   * @throws IOException if an unwanted situation occurs.
   */
  public void run(String[] args) throws IOException {

    Configurations configurations = checkArgument(args);
    Mail mail;

    //get template file and store the contents into a String.
    File templateFile = new File(configurations.getTemplateFile());
    InputStreamReader reader = new InputStreamReader(new FileInputStream(templateFile), "UTF-8");
    BufferedReader br = new BufferedReader(reader);
    StringBuffer templateBuffer = new StringBuffer();
    String line = br.readLine();
    while (line != null) {
      templateBuffer.append(line);
      templateBuffer.append("\n");
      line = br.readLine();
    }
    String template = templateBuffer.toString();

    //Get csv file's header line and store each header into a ArrayList.
    File csvFile = new File(configurations.getCsvFile());
    String csvFileName = csvFile.getName();
    reader = new InputStreamReader(new FileInputStream(csvFile), "UTF-8");
    br = new BufferedReader(reader);
    String headerLine = "";
    headerLine = br.readLine();
    if (headerLine == null) {
      throw new IllegalArgumentException("CSV file is empty.");
    }
    ArrayList<String> headers = new ArrayList<String>();
    Pattern pattern = Pattern.compile("\\s*\"(.*?)\"\\s*");
    Matcher matcher = pattern.matcher(headerLine);
    while (matcher.find()) {
      String find = matcher.group(1);
      headers.add(find);
    }

    //Create mail list.
    ArrayList<Mail> mailList = new ArrayList<Mail>();
    String contentLine = br.readLine();
    while (contentLine != null) {
      if (contentLine.length() == 0) {
        contentLine = br.readLine();
        continue;
      }
      ArrayList<String> contents = new ArrayList<String>();
      matcher = pattern.matcher(contentLine);
      while (matcher.find()) {
        String find = matcher.group(1);
        contents.add(find);
      }
//      if (contents.size()==0){
//        continue;
//      }
      if (contents.size() != headers.size()) {
        throw new MissingFormatArgumentException("CSV line error: wrong number of arguments.\n" +
            contentLine);
      }
      Map<String, String> headerMap = parseHeader(headers, contents);
      switch (configurations.getMailType()) {
        case EMAIL:
          mail = new Email(headerMap, template);
          break;
        case LETTER:
          mail = new Letter(headerMap, template);
          break;
        default:
          mail = new Mail(headerMap, template);
      }
      mailList.add(mail);

      contentLine = br.readLine();
    }
    this.mailList = mailList;

    //Output file.
    String outputFileName;
    String outputDir = configurations.getOutputDir();

    if (outputDir.length() > 0 && outputDir.charAt(outputDir.length() - 1) != '/') {
      outputFileName = configurations.getOutputDir() + "/" + "output_" +
          templateFile.getName().substring(0, templateFile.getName().lastIndexOf(".")) + ".txt";
    } else {
      outputFileName = configurations.getOutputDir() + "output_" +
          templateFile.getName().substring(0, templateFile.getName().lastIndexOf(".")) + ".txt";
    }

    PrintStream ps = new PrintStream(outputFileName, "UTF-8");
    for (Mail m : mailList
    ) {
      ps.append(m.getContents());
      ps.append("\n");
    }

  }

  /**
   * Check if the input command line argument is valid. throw exceptions if it is invalid.
   *
   * @param args input command line argument
   * @return Configurations object describe the running configuration
   * @throws IllegalArgumentException if the input command line argument is invalid
   */
  private Configurations checkArgument(String[] args) throws IllegalArgumentException {
    boolean letterFlag = false;
    boolean emailFlag = false;
    boolean emailTemplateFlag = false;
    boolean letterTemplateFlag = false;
    boolean outputDirFlag = false;
    boolean csvFlag = false;
    Configurations configurations = new Configurations();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--email")) {
        emailFlag = true;
        configurations.setMailType(MailType.EMAIL);
      } else if (args[i].equals("--letter")) {
        letterFlag = true;
        configurations.setMailType(MailType.LETTER);
      } else if (args[i].equals("--letter-template")) {
        letterTemplateFlag = true;
        i++;
        if (i == args.length) {
          throw new IllegalArgumentException("Letter template file missed.");
        }
        configurations.setTemplateFile(args[i]);


      } else if (args[i].equals("--email-template")) {
        emailTemplateFlag = true;
        i++;
        if (i == args.length) {
          throw new IllegalArgumentException("Email template file missed.");
        }
        configurations.setTemplateFile(args[i]);

      } else if (args[i].equals("--output-dir")) {
        outputDirFlag = true;
        i++;
        if (i == args.length) {
          throw new IllegalArgumentException("Output directory missed.");
        }
        configurations.setOutputDir(args[i]);

      } else if (args[i].equals("--csv-file")) {
        csvFlag = true;
        i++;
        if (i == args.length) {
          throw new IllegalArgumentException("Input CSV file missed.");
        }
        configurations.setCsvFile(args[i]);

      } else {
        throw new IllegalArgumentException("Invalid input argument.");
      }

    }

    if (emailFlag && letterTemplateFlag) {
      throw new IllegalArgumentException("Can't process email with letter template.");
    }

    if (letterFlag && emailTemplateFlag) {
      throw new IllegalArgumentException("Can't process letter with email template.");
    }

    if ((!letterFlag) && (!emailFlag)) {
      throw new IllegalArgumentException("Must process letter or email.");
    }
    if (letterFlag && emailFlag) {
      throw new IllegalArgumentException("Can't process letter and email together.");
    }

    if (!outputDirFlag) {
      throw new IllegalArgumentException("Output Directory missed.");
    }

    if (!csvFlag) {
      throw new IllegalArgumentException("CSV file missed.");
    }

    return configurations;
  }

  /**
   * Generate the hash map of header string vs specific value for a mail template.
   *
   * @param headers  the arrayList of the header string
   * @param contents the arrayList of the specific value
   * @return the hash map.
   */
  private Map<String, String> parseHeader(ArrayList<String> headers, ArrayList<String> contents) {

    Map<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < headers.size(); i++) {
      map.put(headers.get(i), contents.get(i));
    }
    return map;
  }

  /**
   * Getter of the mail list.
   *
   * @return mail list
   */
  public ArrayList<Mail> getMailList() {
    return mailList;
  }

  /**
   * Setter of the mail list.
   *
   * @param mailList mail list
   */
  public void setMailList(ArrayList<Mail> mailList) {
    this.mailList = mailList;
  }

  /**
   * Check if this object is equal to the other object or not.
   *
   * @param o the other object
   * @return true if the two object is equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Sender)) {
      return false;
    }
    Sender sender = (Sender) o;
    return Objects.equals(mailList, sender.mailList);
  }

  /**
   * Calculate the hash code of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(mailList);
  }

  /**
   * Transform the object to a string.
   *
   * @return the string form of the object
   */
  @Override
  public String toString() {
    return "Sender{" +
        "mailList=" + mailList +
        '}';
  }
}

