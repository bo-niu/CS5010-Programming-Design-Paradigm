package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class YossarianHalfSizeTest {

  private YossarianHalfSize yossarianHalfSize;

  @Before
  public void setUp() throws Exception {
    yossarianHalfSize = new YossarianHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 3, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("YossarianHalfSize", yossarianHalfSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, yossarianHalfSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(yossarianHalfSize.isValid());
    YossarianHalfSize yossarianHalfSize1 = new YossarianHalfSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 3, 0);
    YossarianHalfSize yossarianHalfSize2 = new YossarianHalfSize(FurnitureColor.BONE,
        MountedType.FLOOR, 90, 0);
    YossarianHalfSize yossarianHalfSize3 = new YossarianHalfSize(FurnitureColor.BONE,
        MountedType.FLOOR, 3, 12);
    Assert.assertFalse(yossarianHalfSize1.isValid());
    Assert.assertFalse(yossarianHalfSize2.isValid());
    Assert.assertFalse(yossarianHalfSize3.isValid());
  }

  @Test
  public void testToString() {
    String s = "YossarianHalfSize{}Yossarian{}Cabinet{mountedType=FLOOR, depth=16, shelfNum=3, drawerNum=0}Furniture{width=36, height=36, furnitureColor=BROWN, price=800}";
    Assert.assertEquals(s, yossarianHalfSize.toString());
  }
}