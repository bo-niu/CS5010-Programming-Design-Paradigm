import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;

/**
 * Represents the test class for the Poet class.
 */
public class PoetTest {

  /**
   * testMusician is the object we use to test the Musician class.
   */
  private Poet testPoet;

  /**
   * In this method, we initialize testPoet.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testPoet = new Poet("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }
}