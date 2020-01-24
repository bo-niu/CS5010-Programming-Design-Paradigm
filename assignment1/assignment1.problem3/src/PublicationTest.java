import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class Publication.
 */
public class PublicationTest {

  private ConferenceProceeding conferenceProceeding;
  private Journal journal;
  private Textbook textbook;
  private EditedVolume editedVolume;

  /**
   * In this method, we do the initialization work.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    String[] s = {"Author1", "Author2"};
    this.conferenceProceeding = new ConferenceProceeding("conferenceProceeding Title", s, 1999, 250,
        "conference1", "seattle");
    this.textbook = new Textbook("textbook Title", s, 1978, 1000,
        "company1", 550);
    this.editedVolume = new EditedVolume("editedVolume Title", s, 2018, 500,
        "company2", 450);
    s = new String[]{"Editor1", "Editor2"};
    this.journal = new Journal("journal Title", s, 1900, 600, "publisher1", s);
  }

  /**
   * Test if the method returns the correct result.
   *
   * @throws ImpactEstimationException if the age of the publication is higher than 250.
   */
  @Test
  public void estimateImpact() throws ImpactEstimationException {
    Assert.assertEquals(12.5, this.conferenceProceeding.estimateImpact(), 0.00001);
    Assert.assertEquals(97.560975, this.textbook.estimateImpact(), 0.00001);
    Assert.assertEquals(2100, this.editedVolume.estimateImpact(), 0.00001);
    Assert.assertEquals(10.08403, this.journal.estimateImpact(), 0.00001);
  }

  /**
   * Test if the method returns the same title as what we initialized.
   */
  @Test
  public void getTitle() {
    Assert.assertEquals("conferenceProceeding Title", this.conferenceProceeding.getTitle());
  }

  /**
   * Test if the method returns the same author as what we initialized.
   */
  @Test
  public void getAuthors() {
    String[] s = this.conferenceProceeding.getAuthors();
    Assert.assertEquals("Author1", s[0]);
    Assert.assertEquals("Author2", s[1]);
  }

  /**
   * Test if the method returns the same publishing year as what we initialized.
   */
  @Test
  public void getPublishingYear() {
    Assert.assertEquals((int) 1999, (int) this.conferenceProceeding.getPublishingYear());
  }

  /**
   * Test if the method returns the same citation number as what we initialized.
   */
  @Test
  public void getCitationNum() {
    Assert.assertEquals((int) 250, (int) this.conferenceProceeding.getCitationNum());
  }

  /**
   * Test if the exception is thrown when we create an illegal title -- No.1
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException1() {
    String[] s = {"Author1", "Author2"};
    Journal testJournal = new Journal("", s, 1900, 600, "publisher1", s);
  }

  /**
   * Test if the exception is thrown when we create an illegal publishing year -- No.2
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException2() {
    String[] s = {"Author1", "Author2"};
    Journal testJournal = new Journal("journal Title", s, 2050, 600, "publisher1", s);
  }

  /**
   * Test if the exception is thrown when we create an illegal citation number -- No.3
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException3() {
    String[] s = {"Author1", "Author2"};
    Journal testJournal = new Journal("journal Title", s, 1900, -5, "publisher1", s);
  }
}