import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class Book.
 */
public class BookTest {

  private Textbook textbook;

  /**
   * In this method, we do the initialization work.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    String[] s = {"Author1", "Author2"};
    this.textbook = new Textbook("textbook Title", s, 1978, 1000,
        "company1", 550);
  }

  /**
   * Test if the method calculateScaleFactor returns the correct result.
   */
  @Test
  public void calculateScaleFactor() {
    Assert.assertEquals((int) 4, (int) this.textbook.calculateScaleFactor());
  }

  /**
   * Test if the method returns the same publishing company as what we initialized.
   */
  @Test
  public void getPublishingCompany() {
    Assert.assertEquals("company1", this.textbook.getPublishingCompany());
  }

  /**
   * Test if the method returns the same number of pages as what we initialized.
   */
  @Test
  public void getNumOfPages() {
    Assert.assertEquals((int) 550, (int) this.textbook.getNumOfPages());
  }
}