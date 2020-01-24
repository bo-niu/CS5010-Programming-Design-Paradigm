package solverTest;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;
import solver.*;

public class JsonInput_Abstract_CabinetTest {

  JsonInput_Cabinet jsonInput_cabinet;

  @Before
  public void setUp() throws Exception {
    jsonInput_cabinet = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 0, FurnitureColor.BROWN,
        MountedType.FLOOR, true);
  }

  @Test
  public void isWorkFlag() {
    Assert.assertTrue(jsonInput_cabinet.isWorkFlag());
  }

  @Test
  public void setWorkFlag() {
    jsonInput_cabinet.setWorkFlag(false);
    Assert.assertFalse(jsonInput_cabinet.isWorkFlag());
  }

  @Test
  public void getDepth() {
    Assert.assertEquals(16, jsonInput_cabinet.getDepth());
  }

  @Test
  public void setDepth() {
    jsonInput_cabinet.setDepth(32);
    Assert.assertEquals(32, jsonInput_cabinet.getDepth());
  }

  @Test
  public void getDrawerNum() {
    Assert.assertEquals(0, jsonInput_cabinet.getDrawerNum());
  }

  @Test
  public void setDrawerNum() {
    jsonInput_cabinet.setDrawerNum(1);
    Assert.assertEquals(1, jsonInput_cabinet.getDrawerNum());
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(72, jsonInput_cabinet.getHeight());
  }

  @Test
  public void setHeight() {
    jsonInput_cabinet.setHeight(32);
    Assert.assertEquals(32, jsonInput_cabinet.getHeight());
  }

  @Test
  public void getWidth() {
    Assert.assertEquals(36, jsonInput_cabinet.getWidth());
  }

  @Test
  public void setWidth() {
    jsonInput_cabinet.setWidth(10);
    Assert.assertEquals(10, jsonInput_cabinet.getWidth());
  }

  @Test
  public void getBudget() {
    Assert.assertEquals(2000, jsonInput_cabinet.getBudget());
  }

  @Test
  public void setBudget() {
    jsonInput_cabinet.setBudget(1500);
    Assert.assertEquals(1500, jsonInput_cabinet.getBudget());
  }

  @Test
  public void getShelfNum() {
    Assert.assertEquals(1, jsonInput_cabinet.getShelfNum());
  }

  @Test
  public void setShelfNum() {
    jsonInput_cabinet.setShelfNum(2);
    Assert.assertEquals(2, jsonInput_cabinet.getShelfNum());
  }

  @Test
  public void getFurnitureColor() {
    Assert.assertEquals(FurnitureColor.BROWN, jsonInput_cabinet.getFurnitureColor());
  }

  @Test
  public void setFurnitureColor() {
    jsonInput_cabinet.setFurnitureColor(FurnitureColor.BLACK);
    Assert.assertEquals(FurnitureColor.BLACK, jsonInput_cabinet.getFurnitureColor());
  }

  @Test
  public void getMountedType() {
    Assert.assertEquals(MountedType.FLOOR, jsonInput_cabinet.getMountedType());
  }

  @Test
  public void setMountedType() {
    jsonInput_cabinet.setMountedType(MountedType.WALL);
    Assert.assertEquals(MountedType.WALL, jsonInput_cabinet.getMountedType());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(jsonInput_cabinet, jsonInput_cabinet);
    Assert.assertNotEquals(jsonInput_cabinet, new Integer(5));
    JsonInput_Cabinet jsonInput_cabinet1 = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    Assert.assertEquals(jsonInput_cabinet, jsonInput_cabinet1);

    JsonInput_Cabinet jsonInput_cabinet2 = new JsonInput_Cabinet(70, 36, 16, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet3 = new JsonInput_Cabinet(72, 30, 16, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet4 = new JsonInput_Cabinet(72, 36, 10, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet5 = new JsonInput_Cabinet(72, 36, 16, 1500, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet6 = new JsonInput_Cabinet(72, 36, 16, 2000, 2, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet7 = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 1,
        FurnitureColor.BROWN, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet8 = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 0,
        FurnitureColor.BLACK, MountedType.FLOOR, true);
    JsonInput_Cabinet jsonInput_cabinet9 = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.WALL, true);
    JsonInput_Cabinet jsonInput_cabinet10 = new JsonInput_Cabinet(72, 36, 16, 2000, 1, 0,
        FurnitureColor.BROWN, MountedType.FLOOR, false);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet2);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet3);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet4);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet5);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet6);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet7);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet8);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet9);
    Assert.assertNotEquals(jsonInput_cabinet, jsonInput_cabinet10);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1588683373, jsonInput_cabinet.hashCode());
  }

  @Test
  public void testToString() {
    String s = "JsonInput_Cabinet{drawerNum=0, height=72, width=36, budget=2000, depth=16, shelfNum=1, furnitureColor=BROWN, mountedType=FLOOR, workFlag=true}";
    Assert.assertEquals(s, jsonInput_cabinet.toString());
  }
}