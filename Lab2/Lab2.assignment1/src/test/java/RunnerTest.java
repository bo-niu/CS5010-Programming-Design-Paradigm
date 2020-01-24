import static org.junit.Assert.*;

import java.util.jar.Attributes.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  private Runner runner;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Kobe");
    runner = new Runner(name, 195.5, 200.5, "NBA", 500.0, 1024.0, "5k");
  }

  @Test
  public void testEquals() {
    Name name = new Name("Kobe");
    Assert.assertTrue(runner.equals(runner));
    Assert.assertFalse(runner.equals(new Integer(5)));
    Assert.assertFalse(runner.equals(null));

    Runner runner2 = new Runner(name, 195.5, 200.5, "NBA", 500.0, 1024.0, "5k");
    Runner runner3 = new Runner(name, 195.5, 200.5, "NBA", 501.0, 1024.0, "5k");
    Runner runner4 = new Runner(name, 195.5, 200.5, "NBA", 500.0, 1023.0, "5k");
    Runner runner5 = new Runner(name, 195.5, 200.5, "NBA", 500.0, 1024.0, "50k");
    Runner runner6 = new Runner(name, 196.5, 200.5, 500.0, 1024.0, "5k");
    Assert.assertTrue(runner.equals(runner2));
    Assert.assertFalse(runner.equals(runner3));
    Assert.assertFalse(runner.equals(runner4));
    Assert.assertFalse(runner.equals(runner5));
    Assert.assertFalse(runner.equals(runner6));

  }

  @Test
  public void getBest5KTime() {
    Assert.assertEquals(0, runner.getBest5KTime().compareTo(500.0));
  }

  @Test
  public void setBest5KTime() {
    runner.setBest5KTime(450.0);
    Assert.assertEquals(0, runner.getBest5KTime().compareTo(450.0));
  }

  @Test
  public void getBestHalfMarathonTime() {
    Assert.assertEquals(0, runner.getBestHalfMarathonTime().compareTo(1024.0));
  }

  @Test
  public void setBestHalfMarathonTime() {
    runner.setBestHalfMarathonTime(1025.0);
    Assert.assertEquals(0, runner.getBestHalfMarathonTime().compareTo(1025.0));
  }

  @Test
  public void getFavoriteRunningEvent() {
    Assert.assertEquals("5k", runner.getFavoriteRunningEvent());
  }

  @Test
  public void setFavoriteRunningEvent() {
    runner.setFavoriteRunningEvent("100m");
    Assert.assertEquals("100m", runner.getFavoriteRunningEvent());
  }

  @Test
  public void testToString() {
    String s = "Runner{best5KTime=500.0, bestHalfMarathonTime=1024.0, favoriteRunningEvent='5k'}";
    Assert.assertEquals(s, runner.toString());
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1945256336, runner.hashCode());
  }
}