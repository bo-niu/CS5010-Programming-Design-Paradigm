import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class Artist.
 */
public class ArtistTest {

  /**
   * testArtist is the object we use to test the Artist class. Artist class is an abstract class. So
   * we test it by an object of the child class.
   */
  private Poet testArtist;

  /**
   * In this method, we initialize testArtist.
   *
   * @throws Exception if an exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testArtist = new Poet("Bo", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }

  /**
   * Test if getFirstName function works properly.
   */
  @Test
  public void getFirstName() {
    Assert.assertEquals("Bo", this.testArtist.getFirstName());
  }

  /**
   * Test if getLastName function works properly.
   */
  @Test
  public void getLastName() {
    Assert.assertEquals("Niu", this.testArtist.getLastName());
  }

  /**
   * Test if getGenre function works properly.
   */
  @Test
  public void getGenre() {
    Assert.assertEquals("genre", this.testArtist.getGenre());
  }

  /**
   * Test if getAge function works properly.
   */
  @Test
  public void getAge() {
    Assert.assertEquals(20, this.testArtist.getAge());
  }

  /**
   * Test if getAwards function works properly.
   */
  @Test
  public void getAwards() {
    Assert.assertEquals(1, this.testArtist.getAwards().size());
    Assert.assertEquals("award1", this.testArtist.getAwards().get(0));
  }

  /**
   * Test if addAward function works properly.
   */
  @Test
  public void addAward() {
    this.testArtist.addAward("award2");
    Assert.assertEquals(2, this.testArtist.getAwards().size());
    Assert.assertEquals("award1", this.testArtist.getAwards().get(0));
    Assert.assertEquals("award2", this.testArtist.getAwards().get(1));
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.1
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException1() {
    testArtist = new Poet("", "Niu", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.2
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException2() {
    testArtist = new Poet("Bo", "", "genre", 20,
        new ArrayList<String>(Arrays.asList("award1")));
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.3
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException3() {
    testArtist = new Poet("Bo", "Niu", "genre", -5,
        new ArrayList<String>(Arrays.asList("award1")));
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.4
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException4() {
    testArtist = new Poet("Bo", "Niu", "genre", 200,
        new ArrayList<String>(Arrays.asList("award1")));
  }
}