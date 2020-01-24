package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class BelacquaQuarterSizeTest {

  private BelacquaQuarterSize belacquaQuarterSize;

  @Before
  public void setUp() throws Exception {
    belacquaQuarterSize = new BelacquaQuarterSize(FurnitureColor.BONE);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("BelacquaQuarterSize", belacquaQuarterSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    String s = "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.";
    Assert.assertEquals(s, belacquaQuarterSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(belacquaQuarterSize.isValid());
    BelacquaQuarterSize belacquaQuarterSize1 = new BelacquaQuarterSize(FurnitureColor.BROWN);
    BelacquaQuarterSize belacquaQuarterSize2 = new BelacquaQuarterSize(FurnitureColor.BLACK);
    Assert.assertFalse(belacquaQuarterSize1.isValid());
    Assert.assertFalse(belacquaQuarterSize2.isValid());
  }

  @Test
  public void testToString() {
    String s = "BelacquaQuarterSize{}Belacqua{}Door{handleIncludedFlag=true}Furniture{width=36, height=18, furnitureColor=BONE, price=500}";
    Assert.assertEquals(s, belacquaQuarterSize.toString());
  }
}