package solverTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import furniture.*;
import solver.*;

public class JsonInput_Abstract_DoorTest {

  private JsonInput_Door jsonInput_door;

  @Before
  public void setUp() throws Exception {
    jsonInput_door = new JsonInput_Door(32, 32, 2000, FurnitureColor.BROWN, true);
  }

  @Test
  public void isWorkFlag() {
    Assert.assertTrue(jsonInput_door.isWorkFlag());
  }

  @Test
  public void setWorkFlag() {
    jsonInput_door.setWorkFlag(false);
    Assert.assertFalse(jsonInput_door.isWorkFlag());
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(32, jsonInput_door.getHeight());
  }

  @Test
  public void setHeight() {
    jsonInput_door.setHeight(36);
    Assert.assertEquals(36, jsonInput_door.getHeight());
  }

  @Test
  public void getWidth() {
    Assert.assertEquals(32, jsonInput_door.getWidth());
  }

  @Test
  public void setWidth() {
    jsonInput_door.setWidth(10);
    Assert.assertEquals(10, jsonInput_door.getWidth());
  }

  @Test
  public void getBudget() {
    Assert.assertEquals(2000, jsonInput_door.getBudget());
  }

  @Test
  public void setBudget() {
    jsonInput_door.setBudget(1500);
    Assert.assertEquals(1500, jsonInput_door.getBudget());
  }

  @Test
  public void getFurnitureColor() {
    Assert.assertEquals(FurnitureColor.BROWN, jsonInput_door.getFurnitureColor());
  }

  @Test
  public void setFurnitureColor() {
    jsonInput_door.setFurnitureColor(FurnitureColor.BLACK);
    Assert.assertEquals(FurnitureColor.BLACK, jsonInput_door.getFurnitureColor());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(jsonInput_door, jsonInput_door);
    Assert.assertNotEquals(jsonInput_door, new Integer(5));
    JsonInput_Door jsonInput_door1 = new JsonInput_Door(32, 32, 2000, FurnitureColor.BROWN, true);
    Assert.assertEquals(jsonInput_door, jsonInput_door1);
    JsonInput_Door jsonInput_door2 = new JsonInput_Door(36, 32, 2000, FurnitureColor.BROWN, true);
    JsonInput_Door jsonInput_door3 = new JsonInput_Door(32, 36, 2000, FurnitureColor.BROWN, true);
    JsonInput_Door jsonInput_door4 = new JsonInput_Door(32, 32, 2500, FurnitureColor.BROWN, true);
    JsonInput_Door jsonInput_door5 = new JsonInput_Door(32, 32, 2000, FurnitureColor.BLACK, true);
    JsonInput_Door jsonInput_door6 = new JsonInput_Door(32, 32, 2000, FurnitureColor.BROWN, false);
    Assert.assertNotEquals(jsonInput_door, jsonInput_door2);
    Assert.assertNotEquals(jsonInput_door, jsonInput_door3);
    Assert.assertNotEquals(jsonInput_door, jsonInput_door4);
    Assert.assertNotEquals(jsonInput_door, jsonInput_door5);
    Assert.assertNotEquals(jsonInput_door, jsonInput_door6);

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(2028750568, jsonInput_door.hashCode());
  }

  @Test
  public void testToString() {
    String s = "JsonInput_Door{height=32, width=32, budget=2000, furnitureColor=BROWN, workFlag=true}";
    Assert.assertEquals(s, jsonInput_door.toString());
  }
}