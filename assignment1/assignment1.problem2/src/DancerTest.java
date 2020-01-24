import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class Dancer.
 */
public class DancerTest {

  /**
   * testDancer is the object we use to test the Dancer class.
   */
  private Dancer testDancer;

  /**
   * In this method, we initialize testDancer.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testDancer = new Dancer("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")),
        new ArrayList<String>(Arrays.asList("movie1")),
        new ArrayList<String>(Arrays.asList("series1")),
        new ArrayList<String>(Arrays.asList("multimedia1")));
  }

  /**
   * Test if addMovies function works properly.
   */
  @org.junit.Test
  public void addMovies() {
    this.testDancer.addMovies("movie2");
    Assert.assertEquals(2, this.testDancer.getMovies().size());
    Assert.assertEquals("movie1", this.testDancer.getMovies().get(0));
    Assert.assertEquals("movie2", this.testDancer.getMovies().get(1));
  }

  /**
   * Test if addSeries function works properly.
   */
  @org.junit.Test
  public void addSeries() {
    this.testDancer.addSeries("series2");
    Assert.assertEquals(2, this.testDancer.getSeries().size());
    Assert.assertEquals("series1", this.testDancer.getSeries().get(0));
    Assert.assertEquals("series2", this.testDancer.getSeries().get(1));
  }

  /**
   * Test if addOtherMultimedia function works properly.
   */
  @org.junit.Test
  public void addOtherMultimedia() {
    this.testDancer.addOtherMultimedia("multimedia2");
    Assert.assertEquals(2, this.testDancer.getOtherMultimedia().size());
    Assert.assertEquals("multimedia1", this.testDancer.getOtherMultimedia().get(0));
    Assert.assertEquals("multimedia2", this.testDancer.getOtherMultimedia().get(1));
  }

  /**
   * Test if getMovies function works properly.
   */
  @org.junit.Test
  public void getMovies() {
    Assert.assertEquals(1, this.testDancer.getMovies().size());
    Assert.assertEquals("movie1", this.testDancer.getMovies().get(0));

  }

  /**
   * Test if getSeries function works properly.
   */
  @org.junit.Test
  public void getSeries() {
    Assert.assertEquals(1, this.testDancer.getSeries().size());
    Assert.assertEquals("series1", this.testDancer.getSeries().get(0));

  }

  /**
   * Test if getOtherMultimedia function works properly.
   */
  @org.junit.Test
  public void getOtherMultimedia() {
    Assert.assertEquals(1, this.testDancer.getOtherMultimedia().size());
    Assert.assertEquals("multimedia1", this.testDancer.getOtherMultimedia().get(0));

  }
}