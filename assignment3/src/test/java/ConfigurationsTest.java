import static org.junit.Assert.*;

import javax.security.auth.login.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationsTest {

  private Configurations configurations;

  @Before
  public void setUp() throws Exception {
    configurations = new Configurations();
    configurations.setCsvFile("testCSV.csv");
    configurations.setOutputDir("output");
    configurations.setTemplateFile("template.txt");
    configurations.setMailType(MailType.LETTER);
  }

  @Test
  public void getMailType() {
    Assert.assertEquals(MailType.LETTER, configurations.getMailType());
  }

  @Test
  public void setMailType() {
    configurations.setMailType(MailType.EMAIL);
    Assert.assertEquals(MailType.EMAIL, configurations.getMailType());
  }

  @Test
  public void getTemplateFile() {
    Assert.assertEquals("template.txt", configurations.getTemplateFile());
  }

  @Test
  public void setTemplateFile() {
    configurations.setTemplateFile("template2.txt");
    Assert.assertEquals("template2.txt", configurations.getTemplateFile());
  }

  @Test
  public void getCsvFile() {
    Assert.assertEquals("testCSV.csv", configurations.getCsvFile());
  }

  @Test
  public void setCsvFile() {
    configurations.setCsvFile("test2.csv");
    Assert.assertEquals("test2.csv", configurations.getCsvFile());
  }

  @Test
  public void getOutputDir() {
    Assert.assertEquals("output", configurations.getOutputDir());
  }

  @Test
  public void setOutputDir() {
    configurations.setOutputDir("output2");
    Assert.assertEquals("output2", configurations.getOutputDir());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(configurations.equals(configurations));
    Assert.assertFalse(configurations.equals(null));
    Assert.assertFalse(configurations.equals(new Integer(5)));
    Configurations configurations1 = new Configurations(MailType.LETTER, "template.txt",
        "testCSV.csv", "output");
    Configurations configurations2 = new Configurations(MailType.EMAIL, "template.txt",
        "testCSV.csv", "output");
    Configurations configurations3 = new Configurations(MailType.LETTER, "template2.txt",
        "testCSV.csv", "output");
    Configurations configurations4 = new Configurations(MailType.LETTER, "template.txt",
        "testCSV2.csv", "output");
    Configurations configurations5 = new Configurations(MailType.LETTER, "template.txt",
        "testCSV.csv", "output2");
    Assert.assertTrue(configurations.equals(configurations1));
    Assert.assertFalse(configurations.equals(configurations2));
    Assert.assertFalse(configurations.equals(configurations3));
    Assert.assertFalse(configurations.equals(configurations4));
    Assert.assertFalse(configurations.equals(configurations5));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(696155884, configurations.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(
        "Configurations{mailType=LETTER, templateFile='template.txt', csvFile='testCSV.csv', outputDir='output'}",
        configurations.toString());
  }
}