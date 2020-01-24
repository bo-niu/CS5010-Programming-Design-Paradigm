import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;

/**
 * Represents the test class for the Painter class.
 */
public class PainterTest {

  /**
   * testMusician is the object we use to test the Painter class.
   */
  private Painter testPainter;

  /**
   * In this method, we initialize testPainter.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testPainter = new Painter("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }
}