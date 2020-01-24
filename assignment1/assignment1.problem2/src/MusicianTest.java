import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;

/**
 * Represents the test class for the Musician class.
 */
public class MusicianTest {

  /**
   * testMusician is the object we use to test the Musician class.
   */
  private Musician testMusician;

  /**
   * In this method, we initialize testMusician.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testMusician = new Musician("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }
}