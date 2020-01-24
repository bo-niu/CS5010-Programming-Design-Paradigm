import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class ConferenceProceeding.
 */
public class ConferenceProceedingTest {

  private ConferenceProceeding conferenceProceeding;

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
  }

  /**
   * Test if the method calculateScaleFactor returns the correct result.
   */
  @Test
  public void calculateScaleFactor() {
    Assert.assertEquals((int) 1, (int) this.conferenceProceeding.calculateScaleFactor());
  }

  /**
   * Test if the method returns the same conference name as what we initialized.
   */
  @Test
  public void getConferenceName() {
    Assert.assertEquals("conference1", this.conferenceProceeding.getConferenceName());
  }

  /**
   * Test if the method returns the same conference location as what we initialized.
   */
  @Test
  public void getConferenceLocation() {
    Assert.assertEquals("seattle", this.conferenceProceeding.getConferenceLocation());
  }
}