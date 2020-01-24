package automailtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import automail.*;

public class SenderTest {

  private Sender sender;
  private HashMap<String, String> headerMap;
  private Mail mail;
  private ArrayList<Mail> mailArrayList;



  @Before
  public void setUp() throws Exception {
    sender = new Sender();
    final Configurations configurations1 = new Configurations(MailType.LETTER, "template.txt",
        "testCSV.csv", "output", null);
    headerMap = new HashMap<String, String>();
    headerMap.put("key", "value");
    mail = new Mail(headerMap, "[[key]]");
    mailArrayList = new ArrayList<Mail>();
    mailArrayList.add(mail);
    sender.setMailList(mailArrayList);
  }


  @Test
  public void run() throws IOException {
    final String[] args = {"--email",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/insurancecompanymembers.csv",
        "--send_email",
        "--email_recepient",
        "example@hotmail.com" //this is the recipient's email address. Please modify this address to receive the result
    };
    sender.run(args);

    final String[] args2 = {"--letter",
        "--letter-template",
        "testFile/input/lettertemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args2);

    final String[] args3 = {"--email",
        "--email-template",
        "testFile/input/myEmailTemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/myInsuranceCompanyMembers.csv"};
    sender.run(args3);

  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException1() throws IllegalArgumentException, IOException {
    final String[] args = {
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException2() throws IllegalArgumentException, IOException {
    final String[] args = {"--email",
        "--letter-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException3() throws IllegalArgumentException, IOException {
    final String[] args = {"--letter",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException4() throws IllegalArgumentException, IOException {
    final String[] args = {"--email",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException6() throws IllegalArgumentException, IOException {
    final String[] args = {"--email",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output",
        "--csv-file",
        "123",
        "testFile/input/insurancecompanymembers.csv"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException7() throws IllegalArgumentException, IOException {
    final String[] args = {"--email",
        "--letter",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output"};
    sender.run(args);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException5() throws IllegalArgumentException, IOException {
    final String[] args = {"--email",
        "--email-template",
        "testFile/input/emailtemplate.txt",
        "--output-dir",
        "testFile/output"};
    sender.run(args);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(sender.equals(sender));
    Assert.assertFalse(sender.equals(null));
    Assert.assertFalse(sender.equals(new Integer(5)));
    final Sender sender1 = new Sender();
    final Sender sender2 = new Sender();
    final ArrayList<Mail> mailArrayList = new ArrayList<Mail>();
    mailArrayList.add(mail);
    sender1.setMailList(mailArrayList);
    Assert.assertEquals(sender1, sender);
    Assert.assertNotEquals(sender2, sender);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1919729987, sender.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(
        "Sender{mailList=[Mail{headerMap={key=value}, template='[[key]]', contents='value'}]}",
        sender.toString());
  }

  @Test
  public void getMailList() {
    Assert.assertEquals(mailArrayList, sender.getMailList());
  }

  @Test
  public void setMailList() {
    final HashMap<String, String> headerMap = new HashMap<String, String>();
    headerMap.put("key2", "value2");
    final Mail mail = new Mail(headerMap, "[[key2]]");
    final ArrayList<Mail> mailArrayList = new ArrayList<Mail>();
    mailArrayList.add(mail);
    sender.setMailList(mailArrayList);
    Assert.assertEquals(mailArrayList, sender.getMailList());
  }
}