import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {

  private Restaurant restaurant;
  private Menu menu;
  private Address address;

  @Before
  public void setUp() throws Exception {
    List<String> meals = new ArrayList<>(Arrays.asList("fish", "beef", "lamb"));
    List<String> desserts = new ArrayList<>(Arrays.asList("candy", "bread", "ice cream"));
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine"));
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee"));
    menu = new Menu(meals, desserts, beverages, drinks);
    address = new Address("8021, Ave", "Seattle", "98115", "Washington", "USA");
    restaurant = new Restaurant("bamboo", menu, address, true);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(restaurant.equals(restaurant));
    Assert.assertFalse(restaurant.equals(null));
    Assert.assertFalse(restaurant.equals(new Integer(5)));

    List<String> drinks = new ArrayList<>(Arrays.asList("tea"));
    Restaurant restaurant1 = new Restaurant("bamboo", menu, address, true);
    Restaurant restaurant2 = new Restaurant("bam", menu, address, true);
    Restaurant restaurant3 = new Restaurant("bamboo", menu, address, false);
    Menu m = new Menu(null, null, null, drinks);
    Restaurant restaurant4 = new Restaurant("bamboo", m, address, true);
    Address a = new Address(null, null, null, null, "CN");
    Restaurant restaurant5 = new Restaurant("bamboo", menu, a, true);
    Assert.assertTrue(restaurant.equals(restaurant1));
    Assert.assertFalse(restaurant.equals(restaurant2));
    Assert.assertFalse(restaurant.equals(restaurant3));
    Assert.assertFalse(restaurant.equals(restaurant4));
    Assert.assertFalse(restaurant.equals(restaurant5));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1489298803, restaurant.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Restaurant{name='bamboo', menu=Menu{meals=[fish, beef, lamb], desserts=[candy, bread, ice cream], beverages=[coke, wine], drinks=[tea, coffee]}, address=Address{streetNum='8021, Ave', city='Seattle', zip='98115', state='Washington', country='USA'}, openFlag=true}";
    Assert.assertTrue(s.equals(restaurant.toString()));
  }

  @Test
  public void getName() {
    Assert.assertTrue(restaurant.getName().equals("bamboo"));
  }

  @Test
  public void setName() {
    restaurant.setName("panada");
    Assert.assertTrue(restaurant.getName().equals("panada"));
  }

  @Test
  public void getMenu() {
    Assert.assertTrue(restaurant.getMenu().equals(menu));
  }

  @Test
  public void setMenu() {
    List<String> meals = new ArrayList<>(Arrays.asList("beef", "lamb"));
    List<String> desserts = new ArrayList<>(Arrays.asList("bread", "ice cream"));
    List<String> beverages = new ArrayList<>(Arrays.asList("coke", "wine"));
    List<String> drinks = new ArrayList<>(Arrays.asList("tea", "coffee"));
    Menu menu2 = new Menu(meals, desserts, beverages, drinks);
    restaurant.setMenu(menu2);
    Assert.assertTrue(restaurant.getMenu().equals(menu2));
  }

  @Test
  public void getAddress() {
    Assert.assertTrue(restaurant.getAddress().equals(address));
  }

  @Test
  public void setAddress() {
    Address address2 = new Address("8021", "Qingdao", "98116", "Shandong", "China");
    restaurant.setAddress(address2);
    Assert.assertTrue(restaurant.getAddress().equals(address2));
  }

  @Test
  public void isOpenFlag() {
    Assert.assertTrue(restaurant.isOpenFlag());
  }

  @Test
  public void setOpenFlag() {
    restaurant.setOpenFlag(false);
    Assert.assertFalse(restaurant.isOpenFlag());
  }
}