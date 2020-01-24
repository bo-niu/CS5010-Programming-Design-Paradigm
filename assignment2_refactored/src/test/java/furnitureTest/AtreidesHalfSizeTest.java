package furnitureTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;

public class AtreidesHalfSizeTest {

  private AtreidesHalfSize atreidesHalfSize;

  @Before
  public void setUp() throws Exception {
    atreidesHalfSize = new AtreidesHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 2, 0);
  }

  @Test
  public void getJsonInfo() {
    Assert.assertEquals("AtreidesHalfSize", atreidesHalfSize.getJsonInfo());
  }

  @Test
  public void getCommentInfo() {
    Assert.assertEquals(null, atreidesHalfSize.getCommentInfo());
  }

  @Test
  public void isValid() {
    Assert.assertTrue(atreidesHalfSize.isValid());
    AtreidesHalfSize atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 2, 0);
    AtreidesHalfSize atreidesHalfSize2 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 10, 0);
    AtreidesHalfSize atreidesHalfSize3 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 2, 10);

    Assert.assertFalse(atreidesHalfSize1.isValid());
    Assert.assertFalse(atreidesHalfSize2.isValid());
    Assert.assertFalse(atreidesHalfSize3.isValid());
  }

  @Test
  public void testToString() {
    String s = "AtreidesHalfSize{}Atreides{}Cabinet{mountedType=FLOOR, depth=16, shelfNum=2, drawerNum=0}Furniture{width=36, height=36, furnitureColor=BROWN, price=800}";
    Assert.assertEquals(s, atreidesHalfSize.toString());
  }

  @Test
  public void testEquals() {
    AtreidesHalfSize atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 2, 0);
    Assert.assertEquals(atreidesHalfSize1, atreidesHalfSize);
    Assert.assertEquals(atreidesHalfSize, atreidesHalfSize);
    Assert.assertNotEquals(atreidesHalfSize, new Integer(5));
    AtreidesHalfSize atreidesHalfSize2 = new AtreidesHalfSize(FurnitureColor.OXBLOOD,
        MountedType.FLOOR, 2, 0);
    AtreidesHalfSize atreidesHalfSize3 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.WALL, 2, 0);
    AtreidesHalfSize atreidesHalfSize4 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 1, 0);
    AtreidesHalfSize atreidesHalfSize5 = new AtreidesHalfSize(FurnitureColor.BROWN,
        MountedType.FLOOR, 2, 1);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize2);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize3);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize4);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize5);
    atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 2, 0);
    atreidesHalfSize1.setWidth(40);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize1);
    atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 2, 0);
    atreidesHalfSize1.setHeight(40);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize1);
    atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 2, 0);
    atreidesHalfSize1.setPrice(400);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize1);
    atreidesHalfSize1 = new AtreidesHalfSize(FurnitureColor.BROWN, MountedType.FLOOR, 2, 0);
    atreidesHalfSize1.setFurnitureColor(FurnitureColor.OXBLOOD);
    Assert.assertNotEquals(atreidesHalfSize, atreidesHalfSize1);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1223551800, atreidesHalfSize.hashCode());
  }

  @Test
  public void getWidth() {
    Assert.assertEquals(36, atreidesHalfSize.getWidth());
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(36, atreidesHalfSize.getHeight());
  }

  @Test
  public void getPrice() {
    Assert.assertEquals(800, atreidesHalfSize.getPrice());
  }

  @Test
  public void setFurnitureColor() {
    atreidesHalfSize.setFurnitureColor(FurnitureColor.OXBLOOD);
    Assert.assertEquals(FurnitureColor.OXBLOOD, atreidesHalfSize.getFurnitureColor());
  }
}