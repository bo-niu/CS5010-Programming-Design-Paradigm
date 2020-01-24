package automail;

import java.util.Objects;


/**
 * Configurations class store the valid input command line arguments configurations.
 */
public class Configurations {

  private MailType mailType;
  private String templateFile;
  private String csvFile;
  private String outputDir;
  private String recipient;

  /**
   * Constructor of the Configurations class.
   */
  public Configurations() {
  }

  /**
   * Constructor of the Configurations class.
   *
   * @param mailType     mail type
   * @param templateFile template file
   * @param csvFile      csv file
   * @param outputDir    output directory
   * @param recipient    recipient email address
   */
  public Configurations(final MailType mailType, final String templateFile, final String csvFile,
      final String outputDir, final String recipient) {
    this.mailType = mailType;
    this.templateFile = templateFile;
    this.csvFile = csvFile;
    this.outputDir = outputDir;
    this.recipient = recipient;
  }

  /**
   * Getter of the mail type.
   *
   * @return mail type
   */
  public MailType getMailType() {
    return mailType;
  }

  /**
   * Setter of the mail type.
   *
   * @param mailType mail type
   */
  public void setMailType(final MailType mailType) {
    this.mailType = mailType;
  }

  /**
   * Getter of the template file.
   *
   * @return template file
   */
  public String getTemplateFile() {
    return templateFile;
  }

  /**
   * Setter of the template file.
   *
   * @param templateFile template file
   */
  public void setTemplateFile(final String templateFile) {
    this.templateFile = templateFile;
  }

  /**
   * Getter of the csv file.
   *
   * @return csv file
   */
  public String getCsvFile() {
    return csvFile;
  }

  /**
   * Setter of the csv file
   *
   * @param csvFile csv file
   */
  public void setCsvFile(final String csvFile) {
    this.csvFile = csvFile;
  }

  /**
   * Getter of the output directory.
   *
   * @return output directory
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * Setter of the output directory.
   *
   * @param outputDir output directory
   */
  public void setOutputDir(final String outputDir) {
    this.outputDir = outputDir;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(final String recipient) {
    this.recipient = recipient;
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
    if (!(o instanceof Configurations)) {
      return false;
    }
    final Configurations that = (Configurations) o;
    return getMailType() == that.getMailType() &&
        Objects.equals(getTemplateFile(), that.getTemplateFile()) &&
        Objects.equals(getCsvFile(), that.getCsvFile()) &&
        Objects.equals(getOutputDir(), that.getOutputDir());
  }

  /**
   * Calculate the hash code of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMailType().toString(), getTemplateFile(), getCsvFile(), getOutputDir());
  }

  /**
   * Transform the object to a string.
   *
   * @return the string form of the object
   */
  @Override
  public String toString() {
    return "Configurations{" +
        "mailType=" + mailType +
        ", templateFile='" + templateFile + '\'' +
        ", csvFile='" + csvFile + '\'' +
        ", outputDir='" + outputDir + '\'' +
        '}';
  }
}