import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class MenuTest {

  private Menu menu;

  @Before
  public void setUp() throws Exception {
    List<String> meals = new ArrayList<>(Arrays.asList("fish", "beef", "lamb"));
    List<String> desserts = new ArrayList<>(Arrays.asList("candy", "bread", "ice cream"));
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine"));
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee"));
    menu = new Menu(meals, desserts, beverages, drinks);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(menu.equals(menu));
    Assert.assertFalse(menu.equals(null));
    Assert.assertFalse(menu.equals(new Integer(5)));
    List<String> meals = new ArrayList<>(Arrays.asList("fish", "beef", "lamb"));
    List<String> desserts = new ArrayList<>(Arrays.asList("candy", "bread", "ice cream"));
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine"));
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee"));
    Menu menu2 = new Menu(meals, desserts, beverages, drinks);
    drinks.remove(0);
    Menu menu3 = new Menu(meals, desserts, beverages, drinks);
    Assert.assertFalse(menu.equals(menu3));
    beverages.remove(0);
    Menu menu4 = new Menu(meals, desserts, beverages, drinks);
    Assert.assertFalse(menu.equals(menu4));
    desserts.remove(0);
    Menu menu5 = new Menu(meals, desserts, beverages, drinks);
    Assert.assertFalse(menu.equals(menu5));
    meals.remove(0);
    Menu menu6 = new Menu(meals, desserts, beverages, drinks);
    Assert.assertFalse(menu.equals(menu6));


  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(2008203702, menu.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Menu{meals=[fish, beef, lamb], desserts=[candy, bread, ice cream], beverages=[coke, wine], drinks=[tea, coffee]}";
    Assert.assertEquals(s, menu.toString());
  }

  @Test
  public void getMeals() {
    List<String> meals = new ArrayList<>(Arrays.asList("fish", "beef", "lamb"));
    assertThat(menu.getMeals(), is(meals));
  }

  @Test
  public void setMeals() {
    List<String> meals = new ArrayList<>(Arrays.asList("fish", "beef", "lamb", "pork"));
    menu.setMeals(meals);
    assertThat(menu.getMeals(), is(meals));
  }

  @Test
  public void getDesserts() {
    List<String> desserts = new ArrayList<>(Arrays.asList("candy", "bread", "ice cream"));
    assertThat(menu.getDesserts(), is(desserts));
  }

  @Test
  public void setDesserts() {
    List<String> desserts = new ArrayList<>(Arrays.asList("candy", "bread"));
    menu.setDesserts(desserts);
    assertThat(menu.getDesserts(), is(desserts));
  }

  @Test
  public void getBeverages() {
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine"));
    assertThat(menu.getBeverages(), is(beverages));
  }

  @Test
  public void setBeverages() {
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine", "juice"));
    menu.setBeverages(beverages);
    assertThat(menu.getBeverages(), is(beverages));
  }

  @Test
  public void getDrinks() {
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee"));
    assertThat(menu.getDrinks(), is(drinks));
  }

  @Test
  public void setDrinks() {
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee", "juice"));
    menu.setDrinks(drinks);
    assertThat(menu.getDrinks(), is(drinks));
  }
}