package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class AtreidesQuarterSizeTest {

  private AtreidesQuarterSize atreidesQuarterSize;

  @Before
  public void setUp() throws Exception {
    atreidesQuarterSize = new AtreidesQuarterSize(FurnitureColor.BROWN, MountedType.FLOOR, 1, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("AtreidesQuarterSize", atreidesQuarterSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, atreidesQuarterSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    AtreidesQuarterSize atreidesQuarterSize1 = new AtreidesQuarterSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 1, 0);
    AtreidesQuarterSize atreidesQuarterSize2 = new AtreidesQuarterSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 1, 10);
    AtreidesQuarterSize atreidesQuarterSize3 = new AtreidesQuarterSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 9, 0);
    Assert.assertTrue(atreidesQuarterSize.isValid());
    Assert.assertFalse(atreidesQuarterSize1.isValid());
    Assert.assertFalse(atreidesQuarterSize2.isValid());
    Assert.assertFalse(atreidesQuarterSize3.isValid());
  }

  @Test
  public void testToString() {
    String s = "AtreidesQuarterSize{}Atreides{}Cabinet{mountedType=FLOOR, depth=16, shelfNum=1, drawerNum=0}Furniture{width=36, height=18, furnitureColor=BROWN, price=600}";
    Assert.assertEquals(s, atreidesQuarterSize.toString());
  }
}