package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class BelacquaWardrobeSizeTest {

  private BelacquaWardrobeSize belacquaWardrobeSize;

  @Before
  public void setUp() throws Exception {
    belacquaWardrobeSize = new BelacquaWardrobeSize(FurnitureColor.BONE);
  }

  @Test
  public void getJsonInfo() {
    System.out.println(belacquaWardrobeSize.toString());
    System.out.println(belacquaWardrobeSize.getJsonInfo());
    System.out.println(belacquaWardrobeSize.getCommentInfo());
    Assert.assertEquals("BelacquaWardrobeSize", belacquaWardrobeSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    String s = "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.";
    Assert.assertEquals(s, belacquaWardrobeSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(belacquaWardrobeSize.isValid());
    BelacquaWardrobeSize belacquaWardrobeSize1 = new BelacquaWardrobeSize(FurnitureColor.BROWN);
    BelacquaWardrobeSize belacquaWardrobeSize2 = new BelacquaWardrobeSize(FurnitureColor.BLACK);
    Assert.assertFalse(belacquaWardrobeSize1.isValid());
    Assert.assertFalse(belacquaWardrobeSize2.isValid());
  }

  @Test
  public void testToString() {
    String s = "BelacquaWardrobeSize{}Belacqua{}Door{handleIncludedFlag=true}Furniture{width=36, height=72, furnitureColor=BONE, price=1000}";
    Assert.assertEquals(s, belacquaWardrobeSize.toString());
  }
}