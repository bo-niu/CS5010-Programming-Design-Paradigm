import java.util.Map;

/**
 * Email class extents Mail class, which could have its own specific fields and functions in the
 * future.
 */
public class Email extends Mail {

  /**
   * Constructor matched with the Mail class.
   *
   * @param headerMap the hash map of the name vs value.
   * @param template  string of the mail template.
   */
  public Email(Map<String, String> headerMap, String template) {
    super(headerMap, template);
  }
}
