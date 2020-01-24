import static org.junit.Assert.*;

import java.util.jar.Attributes.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AthleteTest {

  private Athlete athlete;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Kobe");
    athlete = new Athlete(name, 195.5, 200.5, "NBA");
  }

  @Test
  public void getAthletesName() {
    Name name = new Name("Kobe");
    Assert.assertTrue(name.equals(athlete.getAthletesName()));
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(0, athlete.getHeight().compareTo(195.5));
  }

  @Test
  public void getWeight() {
    Assert.assertEquals(0, athlete.getWeight().compareTo(200.5));
  }

  @Test
  public void getLeague() {
    Assert.assertEquals("NBA", athlete.getLeague());
  }

  @Test
  public void testEquals() {
    Name name = new Name("Kobe");
    Athlete athlete2 = new Athlete(name, 195.5, 200.5, "NBA");
    Athlete athlete3 = new Athlete(name, 195.5, 201.5, "NBA");
    Athlete athlete4 = new Athlete(new Name("Kobe2"), 195.5, 200.5, "NBA");
    Athlete athlete5 = new Athlete(name, 196.5, 200.5, "NBA");
    Athlete athlete6 = new Athlete(name, 195.5, 200.5, "NBC");

    Assert.assertTrue(athlete.equals(athlete));
    Assert.assertTrue(athlete2.equals(athlete));
    Assert.assertFalse(athlete2.equals(null));
    Assert.assertFalse(athlete2.equals(new Integer(5)));

    Assert.assertTrue(athlete.equals(athlete2));
    Assert.assertFalse(athlete.equals(athlete3));
    Assert.assertFalse(athlete.equals(athlete4));
    Assert.assertFalse(athlete.equals(athlete5));
    Assert.assertFalse(athlete.equals(athlete6));
  }

  @Test
  public void setAthletesName() {
    Name name = new Name("James");
    athlete.setAthletesName(name);
    Assert.assertTrue(name.equals(athlete.getAthletesName()));
  }

  @Test
  public void setHeight() {
    athlete.setHeight(200.0);
    Assert.assertEquals(0, athlete.getHeight().compareTo(200.0));
  }

  @Test
  public void setWeight() {
    athlete.setWeight(180.0);
    Assert.assertEquals(0, athlete.getWeight().compareTo(180.0));
  }

  @Test
  public void setLeague() {
    athlete.setLeague("NCAA");
    Assert.assertEquals("NCAA", athlete.getLeague());
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(1946959495, athlete.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Athlete{athletesName=Kobe, height=195.5, weight=200.5, league='NBA'}";
    Assert.assertEquals(s, athlete.toString());
  }
}