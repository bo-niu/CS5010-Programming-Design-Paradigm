package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class YossarianWardrobeSizeTest {

  private YossarianWardrobeSize yossarianWardrobeSize;

  @Before
  public void setUp() throws Exception {
    yossarianWardrobeSize = new YossarianWardrobeSize(FurnitureColor.BROWN, MountedType.FLOOR, 7,
        0);
  }

  @Test
  public void getJsonInfo() {
    System.out.println(yossarianWardrobeSize.toString());
    System.out.println(yossarianWardrobeSize.getJsonInfo());
    System.out.println(yossarianWardrobeSize.getCommentInfo());
    Assert.assertEquals("YossarianWardrobeSize", yossarianWardrobeSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, yossarianWardrobeSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(yossarianWardrobeSize.isValid());
    YossarianWardrobeSize yossarianWardrobeSize1 = new YossarianWardrobeSize(FurnitureColor.OXBLOOD,
        MountedType.WALL, 3, 0);
    YossarianWardrobeSize yossarianWardrobeSize2 = new YossarianWardrobeSize(FurnitureColor.BONE,
        MountedType.FLOOR, 90, 0);
    YossarianWardrobeSize yossarianWardrobeSize3 = new YossarianWardrobeSize(FurnitureColor.BONE,
        MountedType.FLOOR, 3, 12);
    Assert.assertFalse(yossarianWardrobeSize1.isValid());
    Assert.assertFalse(yossarianWardrobeSize2.isValid());
    Assert.assertFalse(yossarianWardrobeSize3.isValid());
  }

  @Test
  public void testToString() {
    String s = "YossarianWardrobeSize{}Yossarian{}Cabinet{mountedType=FLOOR, depth=16, shelfNum=7, drawerNum=0}Furniture{width=36, height=72, furnitureColor=BROWN, price=1000}";
    Assert.assertEquals(s, yossarianWardrobeSize.toString());
  }
}