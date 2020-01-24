package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class SlothropWardrobeSizeTest {

  private SlothropWardrobeSize slothropWardrobeSize;

  @Before
  public void setUp() throws Exception {
    slothropWardrobeSize = new SlothropWardrobeSize(FurnitureColor.BROWN);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("SlothropWardrobeSize", slothropWardrobeSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(
        "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.",
        slothropWardrobeSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(slothropWardrobeSize.isValid());
    SlothropWardrobeSize slothropWardrobeSize1 = new SlothropWardrobeSize(FurnitureColor.OXBLOOD);
    SlothropWardrobeSize slothropWardrobeSize2 = new SlothropWardrobeSize(FurnitureColor.BONE);
    Assert.assertFalse(slothropWardrobeSize1.isValid());
    Assert.assertFalse(slothropWardrobeSize2.isValid());
  }

  @Test
  public void testToString() {
    String s = "SlothropWardrobeSize{}Slothrop{}Door{handleIncludedFlag=true}Furniture{width=36, height=72, furnitureColor=BROWN, price=800}";
    Assert.assertEquals(s, slothropWardrobeSize.toString());
  }
}