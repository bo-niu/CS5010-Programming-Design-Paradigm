import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;

/**
 * Represents the test class for the class Actor.
 */
public class ActorTest {

  /**
   * testActor is the object we use to test the Actor class.
   */
  private Actor testActor;

  /**
   * In this method, we initialize testActor.
   *
   * @throws Exception if an exception occurs.
   */
  @org.junit.Before
  public void setUp() throws Exception {
    testActor = new Actor("Bo", "Niu", "genre", 20,
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
    this.testActor.addMovies("movie2");
    Assert.assertEquals(2, this.testActor.getMovies().size());
    Assert.assertEquals("movie1", this.testActor.getMovies().get(0));
    Assert.assertEquals("movie2", this.testActor.getMovies().get(1));
  }

  /**
   * Test if addSeries function works properly.
   */
  @org.junit.Test
  public void addSeries() {
    this.testActor.addSeries("series2");
    Assert.assertEquals(2, this.testActor.getSeries().size());
    Assert.assertEquals("series1", this.testActor.getSeries().get(0));
    Assert.assertEquals("series2", this.testActor.getSeries().get(1));
  }

  /**
   * Test if addOtherMultimedia function works properly.
   */
  @org.junit.Test
  public void addOtherMultimedia() {
    this.testActor.addOtherMultimedia("multimedia2");
    Assert.assertEquals(2, this.testActor.getOtherMultimedia().size());
    Assert.assertEquals("multimedia1", this.testActor.getOtherMultimedia().get(0));
    Assert.assertEquals("multimedia2", this.testActor.getOtherMultimedia().get(1));
  }

  /**
   * Test if getMovies function works properly.
   */
  @org.junit.Test
  public void getMovies() {
    Assert.assertEquals(1, this.testActor.getMovies().size());
    Assert.assertEquals("movie1", this.testActor.getMovies().get(0));

  }

  /**
   * Test if getSeries function works properly.
   */
  @org.junit.Test
  public void getSeries() {
    Assert.assertEquals(1, this.testActor.getSeries().size());
    Assert.assertEquals("series1", this.testActor.getSeries().get(0));

  }

  /**
   * Test if getOtherMultimedia function works properly.
   */
  @org.junit.Test
  public void getOtherMultimedia() {
    Assert.assertEquals(1, this.testActor.getOtherMultimedia().size());
    Assert.assertEquals("multimedia1", this.testActor.getOtherMultimedia().get(0));

  }
}