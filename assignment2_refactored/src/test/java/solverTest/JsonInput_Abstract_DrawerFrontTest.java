package solverTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;
import solver.*;

public class JsonInput_Abstract_DrawerFrontTest {

  private JsonInput_DrawerFront jsonInput_drawerFront;

  @Before
  public void setUp() throws Exception {
    jsonInput_drawerFront = new JsonInput_DrawerFront(32, 32, 16, 2000, FurnitureColor.BROWN, true);
  }

  @Test
  public void getDepth() {
    Assert.assertEquals(16, jsonInput_drawerFront.getDepth());
  }

  @Test
  public void setDepth() {
    jsonInput_drawerFront.setDepth(32);
    Assert.assertEquals(32, jsonInput_drawerFront.getDepth());
  }

  @Test
  public void isWorkFlag() {
    Assert.assertTrue(jsonInput_drawerFront.isWorkFlag());
  }

  @Test
  public void setWorkFlag() {
    jsonInput_drawerFront.setWorkFlag(false);
    Assert.assertFalse(jsonInput_drawerFront.isWorkFlag());
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(32, jsonInput_drawerFront.getHeight());
  }

  @Test
  public void setHeight() {
    jsonInput_drawerFront.setHeight(36);
    Assert.assertEquals(36, jsonInput_drawerFront.getHeight());
  }

  @Test
  public void getWidth() {
    Assert.assertEquals(32, jsonInput_drawerFront.getWidth());
  }

  @Test
  public void setWidth() {
    jsonInput_drawerFront.setWidth(10);
    Assert.assertEquals(10, jsonInput_drawerFront.getWidth());
  }

  @Test
  public void getBudget() {
    Assert.assertEquals(2000, jsonInput_drawerFront.getBudget());
  }

  @Test
  public void setBudget() {
    jsonInput_drawerFront.setBudget(1500);
    Assert.assertEquals(1500, jsonInput_drawerFront.getBudget());
  }

  @Test
  public void getFurnitureColor() {
    Assert.assertEquals(FurnitureColor.BROWN, jsonInput_drawerFront.getFurnitureColor());
  }

  @Test
  public void setFurnitureColor() {
    jsonInput_drawerFront.setFurnitureColor(FurnitureColor.BLACK);
    Assert.assertEquals(FurnitureColor.BLACK, jsonInput_drawerFront.getFurnitureColor());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(jsonInput_drawerFront, jsonInput_drawerFront);
    Assert.assertNotEquals(jsonInput_drawerFront, new Integer(5));
    JsonInput_DrawerFront jsonInput_drawerFront1 = new JsonInput_DrawerFront(32, 32, 16, 2000,
        FurnitureColor.BROWN, true);
    Assert.assertEquals(jsonInput_drawerFront, jsonInput_drawerFront1);
    JsonInput_DrawerFront jsonInput_drawerFront2 = new JsonInput_DrawerFront(30, 32, 16, 2000,
        FurnitureColor.BROWN, true);
    JsonInput_DrawerFront jsonInput_drawerFront3 = new JsonInput_DrawerFront(32, 30, 16, 2000,
        FurnitureColor.BROWN, true);
    JsonInput_DrawerFront jsonInput_drawerFront4 = new JsonInput_DrawerFront(32, 32, 10, 2000,
        FurnitureColor.BROWN, true);
    JsonInput_DrawerFront jsonInput_drawerFront5 = new JsonInput_DrawerFront(32, 32, 16, 2500,
        FurnitureColor.BROWN, true);
    JsonInput_DrawerFront jsonInput_drawerFront6 = new JsonInput_DrawerFront(32, 32, 16, 2000,
        FurnitureColor.BLACK, true);
    JsonInput_DrawerFront jsonInput_drawerFront7 = new JsonInput_DrawerFront(32, 32, 16, 2000,
        FurnitureColor.BROWN, false);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront2);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront3);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront4);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront5);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront6);
    Assert.assertNotEquals(jsonInput_drawerFront, jsonInput_drawerFront7);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-491686022, jsonInput_drawerFront.hashCode());
  }

  @Test
  public void testToString() {
    String s = "JsonInput_DrawerFront{height=32, width=32, depth=16, budget=2000, furnitureColor=BROWN, workFlag=true}";
    Assert.assertEquals(s, jsonInput_drawerFront.toString());
  }
}