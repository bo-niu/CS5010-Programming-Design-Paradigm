import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Represents the test class for the Textbook Book.
 */
public class TextbookTest {

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
}