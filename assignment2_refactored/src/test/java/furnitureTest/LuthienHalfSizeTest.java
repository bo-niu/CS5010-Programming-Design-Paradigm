package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class LuthienHalfSizeTest {

  private LuthienHalfSize luthienHalfSize;

  @Before
  public void setUp() throws Exception {
    luthienHalfSize = new LuthienHalfSize(FurnitureColor.BONE, MountedType.FLOOR, 3, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("LuthienHalfSize", luthienHalfSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, luthienHalfSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(luthienHalfSize.isValid());
    LuthienHalfSize luthienHalfSize1 = new LuthienHalfSize(FurnitureColor.BROWN, MountedType.FLOOR,
        3, 0);
    LuthienHalfSize luthienHalfSize2 = new LuthienHalfSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 3, 0);
    LuthienHalfSize luthienHalfSize3 = new LuthienHalfSize(FurnitureColor.BONE, MountedType.FLOOR,
        90, 0);
    LuthienHalfSize luthienHalfSize4 = new LuthienHalfSize(FurnitureColor.BONE, MountedType.FLOOR,
        3, 12);
    Assert.assertFalse(luthienHalfSize1.isValid());
    Assert.assertFalse(luthienHalfSize2.isValid());
    Assert.assertFalse(luthienHalfSize3.isValid());
    Assert.assertFalse(luthienHalfSize4.isValid());
  }

  @Test
  public void testToString() {
    String s = "LuthienHalfSize{}Luthien{}Cabinet{mountedType=FLOOR, depth=18, shelfNum=3, drawerNum=0}Furniture{width=36, height=36, furnitureColor=BONE, price=800}";
    Assert.assertEquals(s, luthienHalfSize.toString());
  }
}