import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mail Class is the base class of all kinds of mails including email and letter.
 */
public class Mail {

  private Map<String, String> headerMap = new HashMap<String, String>();
  private String template;
  private String contents;

  /**
   * Constructor of the class
   *
   * @param headerMap the hash map of the name vs value.
   * @param template  string of the mail template.
   */
  public Mail(Map<String, String> headerMap, String template) {
    this.headerMap = headerMap;
    this.template = template;
    this.contents = generate();
  }

  /**
   * Generate contents given the template and hash map that replace the placeholder by the specific
   * string.
   *
   * @return the concrete contents
   */
  private String generate() {
    String generatedStr = template;
    for (Map.Entry<String, String> entry : headerMap.entrySet()) {
//      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
      Pattern pattern = Pattern.compile("\\[\\[(.*?)\\]\\]");
      Matcher matcher = pattern.matcher(generatedStr);
      while (matcher.find()) {
        String find = matcher.group(1);
        String val = headerMap.get(find);
        if (val == null) {
          val = "";
        }
        generatedStr = generatedStr.replace(matcher.group(0), val);
      }
    }

    return generatedStr;
  }

  /**
   * Getter of the header map.
   *
   * @return header hash map
   */
  public Map<String, String> getHeaderMap() {
    return headerMap;
  }

  /**
   * Getter of the template.
   *
   * @return template
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Getter of the contents.
   *
   * @return contents
   */
  public String getContents() {
    return contents;
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
    if (!(o instanceof Mail)) {
      return false;
    }
    Mail mail = (Mail) o;
    return Objects.equals(getHeaderMap(), mail.getHeaderMap()) &&
        Objects.equals(getTemplate(), mail.getTemplate()) &&
        Objects.equals(getContents(), mail.getContents());
  }

  /**
   * Calculate the hash code of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getHeaderMap(), getTemplate(), getContents());
  }

  /**
   * Transform the object to a string.
   *
   * @return the string form of the object
   */
  @Override
  public String toString() {
    return "Mail{" +
        "headerMap=" + headerMap +
        ", template='" + template + '\'' +
        ", contents='" + contents + '\'' +
        '}';
  }
}
