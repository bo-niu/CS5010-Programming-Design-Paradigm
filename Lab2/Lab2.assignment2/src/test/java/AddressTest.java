import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

  private Address address;

  @Before
  public void setUp() throws Exception {
    address = new Address("8021, Ave", "Seattle", "98115", "Washington", "USA");
  }

  @Test
  public void getStreetNum() {
    Assert.assertEquals("8021, Ave", address.getStreetNum());
  }

  @Test
  public void setStreetNum() {
    address.setStreetNum("8022, Ave");
    Assert.assertEquals("8022, Ave", address.getStreetNum());
  }

  @Test
  public void getCity() {
    Assert.assertEquals("Seattle", address.getCity());
  }

  @Test
  public void setCity() {
    address.setCity("Qingdao");
    Assert.assertEquals("Qingdao", address.getCity());
  }

  @Test
  public void getZip() {
    Assert.assertEquals("98115", address.getZip());
  }

  @Test
  public void setZip() {
    address.setZip("98116");
    Assert.assertEquals("98116", address.getZip());
  }

  @Test
  public void getState() {
    Assert.assertEquals("Washington", address.getState());
  }

  @Test
  public void setState() {
    address.setState("state");
    Assert.assertEquals("state", address.getState());
  }

  @Test
  public void getCountry() {
    Assert.assertEquals("USA", address.getCountry());
  }

  @Test
  public void setCountry() {
    address.setCountry("CN");
    Assert.assertEquals("CN", address.getCountry());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(address.equals(address));
    Assert.assertFalse(address.equals(null));
    Assert.assertFalse(address.equals(new Integer(5)));
    Address address2 = new Address("8022, Ave", "Seattle", "98115", "Washington", "USA");
    Address address3 = new Address("8021, Ave", "NY", "98115", "Washington", "USA");
    Address address4 = new Address("8021, Ave", "Seattle", "98116", "Washington", "USA");
    Address address5 = new Address("8021, Ave", "Seattle", "98115", "WashingtonDC", "USA");
    Address address6 = new Address("8021, Ave", "Seattle", "98115", "Washington", "CN");
    Address address7 = new Address("8021, Ave", "Seattle", "98115", "Washington", "USA");
    Assert.assertTrue(address.equals(address7));
    Assert.assertFalse(address.equals(address2));
    Assert.assertFalse(address.equals(address3));
    Assert.assertFalse(address.equals(address4));
    Assert.assertFalse(address.equals(address5));
    Assert.assertFalse(address.equals(address6));


  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(-1801625819, address.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Address{streetNum='8021, Ave', city='Seattle', zip='98115', state='Washington', country='USA'}";
    Assert.assertEquals(s, address.toString());
  }
}