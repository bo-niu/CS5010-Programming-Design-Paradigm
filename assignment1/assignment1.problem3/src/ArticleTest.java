import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Represents the test class for the class Article.
 */
public class ArticleTest {

  private Journal journal;

  /**
   * In this method, we do the initialization work.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    String[] s = new String[]{"Editor1", "Editor2"};
    this.journal = new Journal("journal Title", s, 1900, 600, "publisher1", s);
  }
}