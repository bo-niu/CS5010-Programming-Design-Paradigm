import static org.junit.Assert.*;

import java.util.jar.Attributes.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {

  private BaseballPlayer baseballPlayer;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Kobe");
    baseballPlayer = new BaseballPlayer(name, 195.5, 200.5, "Laker", 0.45, 82);
  }

  @Test
  public void testEquals() {
    Name name = new Name("Kobe");

    Assert.assertTrue(baseballPlayer.equals(baseballPlayer));
    Assert.assertFalse(baseballPlayer.equals(null));
    Assert.assertFalse(baseballPlayer.equals(new Integer(5)));
    BaseballPlayer baseballPlayer2 = new BaseballPlayer(name, 195.5, 200.5, "Laker", 0.45, 82);
    BaseballPlayer baseballPlayer3 = new BaseballPlayer(name, 196.5, 200.5, "Laker", 0.45, 82);
    BaseballPlayer baseballPlayer4 = new BaseballPlayer(name, 195.5, 200.5, "Laker2", 0.45, 82);
    BaseballPlayer baseballPlayer5 = new BaseballPlayer(name, 195.5, 200.5, "Laker", 0.46, 82);
    BaseballPlayer baseballPlayer6 = new BaseballPlayer(name, 195.5, 200.5, "Laker", 0.45, 87);
    BaseballPlayer baseballPlayer7 = new BaseballPlayer(name, 195.5, 200.5, "ll", "Laker", 0.45,
        82);
    BaseballPlayer baseballPlayer8 = new BaseballPlayer(name, 195.5, 200.5, "ll", "Laker", 0.45,
        82);
    Assert.assertTrue(baseballPlayer.equals(baseballPlayer2));
    Assert.assertFalse(baseballPlayer.equals(baseballPlayer3));
    Assert.assertFalse(baseballPlayer.equals(baseballPlayer4));
    Assert.assertFalse(baseballPlayer.equals(baseballPlayer5));
    Assert.assertFalse(baseballPlayer.equals(baseballPlayer6));
    Assert.assertFalse(baseballPlayer.equals(baseballPlayer7));
    Assert.assertTrue(baseballPlayer7.equals(baseballPlayer8));

  }

  @Test
  public void getTeam() {
    Assert.assertEquals("Laker", baseballPlayer.getTeam());
  }

  @Test
  public void setTeam() {
    baseballPlayer.setTeam("Heat");
    Assert.assertEquals("Heat", baseballPlayer.getTeam());
  }

  @Test
  public void getAverageBatting() {
    Assert.assertEquals(0, baseballPlayer.getAverageBatting().compareTo(0.45));
  }

  @Test
  public void setAverageBatting() {
    baseballPlayer.setAverageBatting(0.55);
    Assert.assertEquals(0, baseballPlayer.getAverageBatting().compareTo(0.55));
  }

  @Test
  public void getSeasonHomeRun() {
    Assert.assertEquals(82, (int) baseballPlayer.getSeasonHomeRun());
  }

  @Test
  public void setSeasonHomeRun() {
    baseballPlayer.setSeasonHomeRun(80);
    Assert.assertEquals(80, (int) baseballPlayer.getSeasonHomeRun());
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-487067621, baseballPlayer.hashCode());
  }

  @Test
  public void testToString() {
    String s = "BaseballPlayer{team='Laker', averageBatting=0.45, seasonHomeRun=82}";
    Assert.assertEquals(s, baseballPlayer.toString());
  }
}