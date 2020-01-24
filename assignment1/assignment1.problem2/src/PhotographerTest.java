import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;

/**
 * Represents the test class for the Photographer class.
 */
public class PhotographerTest {

  /**
   * testMusician is the object we use to test the Musician class.
   */
  private Photographer testPhotographer;

  /**
   * In this method, we initialize testPhotographer.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testPhotographer = new Photographer("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }
}