package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class GagaQuarterSizeTest {

  private GagaQuarterSize gagaQuarterSize;

  @Before
  public void setUp() throws Exception {
    gagaQuarterSize = new GagaQuarterSize(FurnitureColor.BROWN);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("GagaQuarterSize", gagaQuarterSize.getJsonInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(gagaQuarterSize.isValid());
  }

  @Test
  public void testToString() {
    String s = "GagaQuarterSize{}Gaga{}Door{handleIncludedFlag=false}Furniture{width=36, height=18, furnitureColor=BROWN, price=200}";
    Assert.assertEquals(s, gagaQuarterSize.toString());
  }
}