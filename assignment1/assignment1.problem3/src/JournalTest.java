import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class Journal.
 */
public class JournalTest {

  private Journal journal;

  /**
   * In this method, we do the initialization work.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    this.journal = new Journal("journal Title", new String[]{"Author1", "Author2"}, 1900, 600,
        "publisher1", new String[]{"Editor1", "Editor2"});
  }

  /**
   * Test if the method calculateScaleFactor returns the correct result.
   */
  @Test
  public void calculateScaleFactor() {
    Assert.assertEquals((int) 2, (int) this.journal.calculateScaleFactor());
  }

  /**
   * Test if the method returns the same publisher as what we initialized.
   */
  @Test
  public void getPublisher() {
    Assert.assertEquals("publisher1", this.journal.getPublisher());
  }

  /**
   * Test if the method returns the same editors as what we initialized.
   */
  @Test
  public void getEditor() {
    String[] s = this.journal.getEditor();
    Assert.assertEquals(2, s.length);
    Assert.assertEquals("Editor1", s[0]);
    Assert.assertEquals("Editor2", s[1]);
  }
}