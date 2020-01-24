import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Represents the test class for the EditedVolume Book.
 */
public class EditedVolumeTest {

  private EditedVolume editedVolume;

  /**
   * In this method, we do the initialization work.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    String[] s = {"Author1", "Author2"};
    this.editedVolume = new EditedVolume("editedVolume Title", s, 2018, 500,
        "company2", 450);
  }
}