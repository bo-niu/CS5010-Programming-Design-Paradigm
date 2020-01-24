import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MailTest {

  private Mail mail;
  private HashMap<String, String> headerMap;

  @Before
  public void setUp() throws Exception {
    headerMap = new HashMap<String, String>();
    headerMap.put("key", "value");
    mail = new Mail(headerMap, "[[key]]");
  }

  @Test
  public void getHeaderMap() {
    Assert.assertEquals(headerMap, mail.getHeaderMap());
  }

  @Test
  public void getTemplate() {
    Assert.assertEquals("[[key]]", mail.getTemplate());
  }

  @Test
  public void getContents() {
    Assert.assertEquals("value", mail.getContents());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(mail.equals(mail));
    Assert.assertFalse(mail.equals(null));
    Assert.assertFalse(mail.equals(new Integer(5)));
    HashMap<String, String> headerMap = new HashMap<String, String>();
    headerMap.put("key", "value");
    HashMap<String, String> headerMap2 = new HashMap<String, String>();
    headerMap2.put("key", "value2");
    HashMap<String, String> headerMap3 = new HashMap<String, String>();
    headerMap3.put("key", "value2");
    Mail mail1 = new Mail(headerMap, "[[key]]");
    Mail mail2 = new Mail(headerMap2, "[[key]]");
    Mail mail3 = new Mail(headerMap, "[[key2]]");
    Mail mail4 = new Mail(headerMap3, "[[key]]");
    Assert.assertTrue(mail.equals(mail1));
    Assert.assertFalse(mail.equals(mail2));
    Assert.assertFalse(mail.equals(mail3));
    Assert.assertFalse(mail.equals(mail4));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1919730049, mail.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Mail{headerMap={key=value}, template='[[key]]', contents='value'}",
        mail.toString());
  }
}