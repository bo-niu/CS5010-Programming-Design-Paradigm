package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class LuthienQuarterSizeTest {

  private LuthienQuarterSize luthienQuarterSize;

  @Before
  public void setUp() throws Exception {
    luthienQuarterSize = new LuthienQuarterSize(FurnitureColor.BONE, MountedType.FLOOR, 1, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("LuthienQuarterSize", luthienQuarterSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, luthienQuarterSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(luthienQuarterSize.isValid());
    LuthienQuarterSize luthienQuarterSize1 = new LuthienQuarterSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 3, 0);
    LuthienQuarterSize luthienQuarterSize2 = new LuthienQuarterSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 3, 0);
    LuthienQuarterSize luthienQuarterSize3 = new LuthienQuarterSize(FurnitureColor.BONE,
        MountedType.FLOOR, 90, 0);
    LuthienQuarterSize luthienQuarterSize4 = new LuthienQuarterSize(FurnitureColor.BONE,
        MountedType.FLOOR, 3, 12);
    Assert.assertFalse(luthienQuarterSize1.isValid());
    Assert.assertFalse(luthienQuarterSize2.isValid());
    Assert.assertFalse(luthienQuarterSize3.isValid());
    Assert.assertFalse(luthienQuarterSize4.isValid());
  }

  @Test
  public void testToString() {
    String s = "LuthienQuarterSize{}Luthien{}Cabinet{mountedType=FLOOR, depth=18, shelfNum=1, drawerNum=0}Furniture{width=36, height=18, furnitureColor=BONE, price=600}";
    Assert.assertEquals(s, luthienQuarterSize.toString());
  }
}