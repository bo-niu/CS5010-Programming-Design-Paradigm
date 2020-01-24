package automail;

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
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Sender class plays the role as taking the command line arguments as input which containing the
 * input csv file, template file, output directory, and will output the final mail text file.
 */
public class Sender {

  private ArrayList<Mail> mailList;

  /**
   * This is the insurance company's email address used to send all the mails. Created by Bo. Used
   * for testing. The SMTP configuration has been set up by Bo.
   */
  private final String username = "niubotest@gmail.com";
  /**
   * This is the company's email's password. Created by Bo. Used for testing.
   */
  private final String password = "niubotest123";

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
  public static void main(final String[] args) {

    final Sender sender = new Sender();
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
  public void run(final String[] args) throws IOException {

    final Configurations configurations = checkArgument(args);
    Mail mail;

    //get template file and store the contents into a String.
    final File templateFile = new File(configurations.getTemplateFile());
    InputStreamReader reader = new InputStreamReader(new FileInputStream(templateFile), "UTF-8");
    BufferedReader br = new BufferedReader(reader);
    final StringBuffer templateBuffer = new StringBuffer();
    String line = br.readLine();
    while (line != null) {
      templateBuffer.append(line);
      templateBuffer.append("\n");
      line = br.readLine();
    }
    final String template = templateBuffer.toString();

    //Get csv file's header line and store each header into a ArrayList.
    final File csvFile = new File(configurations.getCsvFile());
    reader = new InputStreamReader(new FileInputStream(csvFile), "UTF-8");
    br = new BufferedReader(reader);
    String headerLine = "";
    headerLine = br.readLine();
    if (headerLine == null) {
      throw new IllegalArgumentException("CSV file is empty.");
    }
    final ArrayList<String> headers = new ArrayList<String>();
    final Pattern pattern = Pattern.compile("\\s*\"(.*?)\"\\s*");
    Matcher matcher = pattern.matcher(headerLine);
    while (matcher.find()) {
      final String find = matcher.group(1);
      headers.add(find);
    }

    //Create mail list.
    final ArrayList<Mail> mailList = new ArrayList<Mail>();
    String contentLine = br.readLine();
    while (contentLine != null) {
      if (contentLine.length() == 0) {
        contentLine = br.readLine();
        continue;
      }
      final ArrayList<String> contents = new ArrayList<String>();
      matcher = pattern.matcher(contentLine);
      while (matcher.find()) {
        final String find = matcher.group(1);
        contents.add(find);
      }
//      if (contents.size()==0){
//        continue;
//      }
      if (contents.size() != headers.size()) {
        throw new MissingFormatArgumentException("CSV line error: wrong number of arguments.\n" +
            contentLine);
      }
      final Map<String, String> headerMap = parseHeader(headers, contents);
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
    final String outputDir = configurations.getOutputDir();

    if (outputDir.length() > 0 && outputDir.charAt(outputDir.length() - 1) != '/') {
      outputFileName = configurations.getOutputDir() + "/" + "output_" +
          templateFile.getName().substring(0, templateFile.getName().lastIndexOf(".")) + ".txt";
    } else {
      outputFileName = configurations.getOutputDir() + "output_" +
          templateFile.getName().substring(0, templateFile.getName().lastIndexOf(".")) + ".txt";
    }

    final PrintStream ps = new PrintStream(outputFileName, "UTF-8");
    final StringBuilder sb = new StringBuilder();
    for (final Mail m : mailList
    ) {
      ps.append(m.getContents()).append("\n");
      sb.append(m.getContents()).append("\n");
    }

    if (configurations.getRecipient() != null) {
      sendEmail(configurations.getRecipient(),
          "Insurance company-information about recent data breach", sb.toString());
    }

  }

  /**
   * Check if the input command line argument is valid. throw exceptions if it is invalid.
   *
   * @param args input command line argument
   * @return Configurations object describe the running configuration
   * @throws IllegalArgumentException if the input command line argument is invalid
   */
  private Configurations checkArgument(final String[] args) throws IllegalArgumentException {
    boolean letterFlag = false;
    boolean emailFlag = false;
    boolean emailTemplateFlag = false;
    boolean letterTemplateFlag = false;
    boolean outputDirFlag = false;
    boolean csvFlag = false;
    boolean sendEmailFlag = false;
    final Configurations configurations = new Configurations();

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--email":
          emailFlag = true;
          configurations.setMailType(MailType.EMAIL);
          break;
        case "--letter":
          letterFlag = true;
          configurations.setMailType(MailType.LETTER);
          break;
        case "--letter-template":
          letterTemplateFlag = true;
          i++;
          if (i == args.length) {
            throw new IllegalArgumentException("Letter template file missed.");
          }
          configurations.setTemplateFile(args[i]);

          break;
        case "--email-template":
          emailTemplateFlag = true;
          i++;
          if (i == args.length) {
            throw new IllegalArgumentException("Email template file missed.");
          }
          configurations.setTemplateFile(args[i]);

          break;
        case "--output-dir":
          outputDirFlag = true;
          i++;
          if (i == args.length) {
            throw new IllegalArgumentException("Output directory missed.");
          }
          configurations.setOutputDir(args[i]);

          break;
        case "--csv-file":
          csvFlag = true;
          i++;
          if (i == args.length) {
            throw new IllegalArgumentException("Input CSV file missed.");
          }
          configurations.setCsvFile(args[i]);

          break;
        case "--send_email":
          sendEmailFlag = true;
          break;
        case "--email_recepient":
          i++;
          if (i == args.length) {
            throw new IllegalArgumentException("Email recipient missed.");
          }
          configurations.setRecipient(args[i]);
          break;
        default:
          throw new IllegalArgumentException("Invalid input argument.");
      }

    }

    if (emailFlag && letterTemplateFlag) {
      throw new IllegalArgumentException("Can't process email with letter template.");
    }

    if (letterFlag && emailTemplateFlag) {
      throw new IllegalArgumentException("Can't process letter with email template.");
    }

    if (!letterFlag && !emailFlag) {
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

    if (sendEmailFlag && configurations.getRecipient() == null) {
      throw new IllegalArgumentException("recipient's email address missed.");
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
  private Map<String, String> parseHeader(final ArrayList<String> headers,
      final ArrayList<String> contents) {

    final Map<String, String> map = new HashMap<String, String>();
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
  public void setMailList(final ArrayList<Mail> mailList) {
    this.mailList = mailList;
  }

  /**
   * Send the generated email to the recipient.
   *
   * @param recipient recipient's email address
   * @param tile      email title
   * @param contents  email contents
   */
  private void sendEmail(final String recipient, final String tile, final String contents) {
    final Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS

    final Session session = Session.getInstance(prop,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
          }
        });

    try {

      final Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(
          Message.RecipientType.TO,
          InternetAddress.parse(recipient)
      );
      message.setSubject(tile);
      message.setText(contents);

      Transport.send(message);

      System.out.println("Done");

    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  /**
   * Check if this object is equal to the other object or not.
   *
   * @param o the other object
   * @return true if the two object is equal
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Sender)) {
      return false;
    }
    final Sender sender = (Sender) o;
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

