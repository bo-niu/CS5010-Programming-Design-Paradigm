package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class GagaQuarterSizeDrawFrontTest {

  private GagaQuarterSizeDrawFront gagaQuarterSizeDrawFront;

  @Before
  public void setUp() throws Exception {
    gagaQuarterSizeDrawFront = new GagaQuarterSizeDrawFront(FurnitureColor.BROWN);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("GagaQuarterSizeDrawFront", gagaQuarterSizeDrawFront.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert
        .assertEquals("Remember to buy drawer handles.", gagaQuarterSizeDrawFront.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(gagaQuarterSizeDrawFront.isValid());
  }

  @Test
  public void testToString() {
    String s = "GagaQuarterSizeDrawFront{}DrawerFront{handleIncludedFlag=false, depth=18}Furniture{width=36, height=18, furnitureColor=BROWN, price=400}";
    Assert.assertEquals(s, gagaQuarterSizeDrawFront.toString());
  }

  @Test
  public void isHandleIncludedFlag() {
    Assert.assertFalse(gagaQuarterSizeDrawFront.isHandleIncludedFlag());
  }

  @Test
  public void getDepth() {
    Assert.assertEquals(18, gagaQuarterSizeDrawFront.getDepth());
  }

  @Test
  public void testEquals() {
    GagaQuarterSizeDrawFront gagaQuarterSizeDrawFront1 = new GagaQuarterSizeDrawFront(
        FurnitureColor.BROWN);
    Assert.assertEquals(gagaQuarterSizeDrawFront, gagaQuarterSizeDrawFront1);
    Assert.assertEquals(gagaQuarterSizeDrawFront, gagaQuarterSizeDrawFront);
    Assert.assertNotEquals(gagaQuarterSizeDrawFront, new Integer(5));
    GagaQuarterSizeDrawFront gagaQuarterSizeDrawFront2 = new GagaQuarterSizeDrawFront(
        FurnitureColor.OXBLOOD);
    Assert.assertNotEquals(gagaQuarterSizeDrawFront, gagaQuarterSizeDrawFront2);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(1970925003, gagaQuarterSizeDrawFront.hashCode());
  }
}