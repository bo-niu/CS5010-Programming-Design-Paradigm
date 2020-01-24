package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class GagaHalfSizeTest {

  private GagaHalfSize gagaHalfSize;

  @Before
  public void setUp() throws Exception {
    gagaHalfSize = new GagaHalfSize(FurnitureColor.BROWN);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("GagaHalfSize", gagaHalfSize.getJsonInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(gagaHalfSize.isValid());
  }

  @Test
  public void testToString() {
    String s = "GagaHalfSize{}Gaga{}Door{handleIncludedFlag=false}Furniture{width=36, height=36, furnitureColor=BROWN, price=800}";
    Assert.assertEquals(s, gagaHalfSize.toString());
  }

  @Test
  public void isHandleIncludedFlag() {
    Assert.assertFalse(gagaHalfSize.isHandleIncludedFlag());
  }

  @Test
  public void testEquals() {
    GagaHalfSize gagaHalfSize1 = new GagaHalfSize(FurnitureColor.BROWN);
    Assert.assertEquals(gagaHalfSize, gagaHalfSize1);
    Assert.assertEquals(gagaHalfSize, gagaHalfSize);
    Assert.assertNotEquals(gagaHalfSize, new Integer(5));
    GagaHalfSize gagaHalfSize2 = new GagaHalfSize(FurnitureColor.OXBLOOD);
    Assert.assertNotEquals(gagaHalfSize, gagaHalfSize2);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(1969762903, gagaHalfSize.hashCode());
  }

  @Test
  public void getCommentInfo() {
    String s = "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.Remember to buy door handles.";
    Assert.assertEquals(s, gagaHalfSize.getCommentInfo());
  }
}