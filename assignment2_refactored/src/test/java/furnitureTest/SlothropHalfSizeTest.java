package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class SlothropHalfSizeTest {

  private SlothropHalfSize slothropHalfSize;

  @Before
  public void setUp() throws Exception {
    slothropHalfSize = new SlothropHalfSize(FurnitureColor.BROWN);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("SlothropHalfSize", slothropHalfSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(
        "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.",
        slothropHalfSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(slothropHalfSize.isValid());
    SlothropHalfSize slothropHalfSize1 = new SlothropHalfSize(FurnitureColor.OXBLOOD);
    SlothropHalfSize slothropHalfSize2 = new SlothropHalfSize(FurnitureColor.BONE);
    Assert.assertFalse(slothropHalfSize1.isValid());
    Assert.assertFalse(slothropHalfSize2.isValid());
  }

  @Test
  public void testToString() {
    String s = "SlothropHalfSize{}Slothrop{}Door{handleIncludedFlag=true}Furniture{width=36, height=36, furnitureColor=BROWN, price=600}";
    Assert.assertEquals(s, slothropHalfSize.toString());
  }
}