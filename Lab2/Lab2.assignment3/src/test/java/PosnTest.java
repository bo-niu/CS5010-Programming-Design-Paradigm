import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PosnTest {

  private Posn posn;

  @Before
  public void setUp() throws Exception {
    posn = new Posn(1, 2);
  }

  @Test
  public void getX() {
    Assert.assertEquals(1, (int) posn.getX());
  }

  @Test
  public void getY() {
    Assert.assertEquals(2, (int) posn.getY());
  }

  @Test
  public void testEquals() {
    //Reflexive - for a non-null reference value x, x.equals(x) returns true
    Assert.assertEquals(posn, posn);

    //Symmetric - for non-null reference values x and y, x.equals(y) returns true if and only
    //if y.equals(x) returns true
    Posn posn2 = new Posn(1, 2);
    Assert.assertEquals(posn, posn2);
    Assert.assertEquals(posn2, posn);

    //Transitive - for non-null reference values x, y, and z,
    //a. if x.equals(y) returns true and
    //b. y.equals(z) returns true, then
    //c. x.equals(z) must return true
    Posn posn3 = new Posn(1, 2);
    Assert.assertEquals(posn, posn2);
    Assert.assertEquals(posn2, posn3);
    Assert.assertEquals(posn, posn3);

    //Consistent - for non-null references x, y, multiple invocations of x.equals(y) should
    //return the same result provided the data inside x and y has not been altered.
    Assert.assertEquals(posn, posn2);
    Assert.assertEquals(posn, posn2);
    Assert.assertEquals(posn, posn2);

    //For any non-null reference value x x.equals(null) returns false
    Assert.assertNotEquals(null, posn);

    //other test specific for Posn class
    Posn p1 = new Posn(1, 3);
    Posn p2 = new Posn(2, 2);
    Assert.assertNotEquals(posn, p1);
    Assert.assertNotEquals(posn, p2);
    Assert.assertNotEquals(posn, null);
    Assert.assertNotEquals(posn, new Integer(5));
    posn = new Posn(null, 2);
    Posn posnd = new Posn(null, 2);
    Assert.assertNotEquals(posn, posn2);
    Assert.assertNotEquals(posn, null);
    Assert.assertEquals(posn, posnd);
    posn = new Posn(1, null);
    posnd = new Posn(1, null);
    Assert.assertNotEquals(posn, posn2);
    Assert.assertNotEquals(posn, null);
    Assert.assertEquals(posn, posnd);
  }

  @Test
  public void testHashCode() {
    //For a non-null reference value x, multiple invocations of x.hashCode() must return the
    //same value provided the data inside x has not been altered.
    int h = posn.hashCode();
    Assert.assertEquals(h, posn.hashCode());
    Assert.assertEquals(h, posn.hashCode());
    Assert.assertEquals(h, posn.hashCode());

    //for any two non-null reference values x, y
    //a. if x.equals(y) returns true then
    //b. x.hashCode() and y.hashCode() must return the same result
    Posn posn2 = new Posn(1, 2);
    if (posn.equals(posn2)) {
      Assert.assertEquals(posn.hashCode(), posn2.hashCode());
    } else {
      Assert.assertNotEquals(posn.hashCode(), posn2.hashCode());
    }

    //for any two non-null reference values x, y
    //a. if x.equals(y) returns false then
    //b. it is prefered but not required
    //that x.hashCode() and y.hashCode() return different/distinct results.

    //other test
    Posn p1 = new Posn(null, null);
    Posn p2 = new Posn(1, null);
    Posn p3 = new Posn(null, 2);
    Assert.assertNotEquals(p1.hashCode(), posn.hashCode());
    Assert.assertNotEquals(p2.hashCode(), posn.hashCode());
    Assert.assertNotEquals(p3.hashCode(), posn.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Posn{x=1, y=2}";
    Assert.assertEquals(s, posn.toString());
  }
}