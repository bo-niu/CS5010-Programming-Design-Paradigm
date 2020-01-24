package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class BelacquaHalfSizeTest {

  private BelacquaHalfSize belacquaHalfSize;

  @Before
  public void setUp() throws Exception {
    belacquaHalfSize = new BelacquaHalfSize(FurnitureColor.BONE);
  }

  @Test
  public void testToString() {
    String s = "BelacquaHalfSize{}Belacqua{}Door{handleIncludedFlag=true}Furniture{width=36, height=36, furnitureColor=BONE, price=800}";
    Assert.assertEquals(s, belacquaHalfSize.toString());
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("BelacquaHalfSize", belacquaHalfSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(
        "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.",
        belacquaHalfSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(belacquaHalfSize.isValid());
    BelacquaHalfSize belacquaHalfSize1 = new BelacquaHalfSize(FurnitureColor.BROWN);
    BelacquaHalfSize belacquaHalfSize2 = new BelacquaHalfSize(FurnitureColor.BLACK);
    Assert.assertFalse(belacquaHalfSize1.isValid());
    Assert.assertFalse(belacquaHalfSize2.isValid());
  }
}