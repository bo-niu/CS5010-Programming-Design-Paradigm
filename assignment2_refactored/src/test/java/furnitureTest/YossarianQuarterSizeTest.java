package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class YossarianQuarterSizeTest {

  private YossarianQuarterSize yossarianQuarterSize;

  @Before
  public void setUp() throws Exception {
    yossarianQuarterSize = new YossarianQuarterSize(FurnitureColor.BROWN, MountedType.FLOOR, 1, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("YossarianQuarterSize", yossarianQuarterSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, yossarianQuarterSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(yossarianQuarterSize.isValid());
    YossarianQuarterSize yossarianQuarterSize1 = new YossarianQuarterSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 3, 0);
    YossarianQuarterSize yossarianQuarterSize2 = new YossarianQuarterSize(FurnitureColor.BONE,
        MountedType.FLOOR, 90, 0);
    YossarianQuarterSize yossarianQuarterSize3 = new YossarianQuarterSize(FurnitureColor.BONE,
        MountedType.FLOOR, 3, 12);
    Assert.assertFalse(yossarianQuarterSize1.isValid());
    Assert.assertFalse(yossarianQuarterSize2.isValid());
    Assert.assertFalse(yossarianQuarterSize3.isValid());
  }

  @Test
  public void testToString() {
    String s = "YossarianQuarterSize{}Yossarian{}Cabinet{mountedType=FLOOR, depth=16, shelfNum=1, drawerNum=0}Furniture{width=36, height=18, furnitureColor=BROWN, price=600}";
    Assert.assertEquals(s, yossarianQuarterSize.toString());
  }
}