import static org.junit.Assert.*;

import org.junit.Assert;

/**
 * Represents the test class for the class CardOwnerTest.
 */
public class CardOwnerTest {

  /**
   * Bob is the object we use to test the CardOwnerTest class.
   */
  private CardOwner bo;

  /**
   * In this method, we initialize Bob.
   *
   * @throws Exception if any exception occurs.
   */
  @org.junit.Before
  public void setUp() throws Exception {
    bo = new CardOwner("Bo", "Niu", "seattle", "niubo@gmail.com");
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.1
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException1() {
    CardOwner badOwner = new CardOwner("", "Niu", "seattle", "niubo@gmail.com");
  }

  /**
   * Test if the exception is thrown when we create an illegal card owner -- No.2
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException2() {
    CardOwner badOwner = new CardOwner("Bo", "", "seattle", "niubo@gmail.com");
  }


  /**
   * Test if the method returns the same first name as what we initialized.
   */
  @org.junit.Test
  public void getFirstName() {
    Assert.assertEquals("Bo", this.bo.getFirstName());
  }

  /**
   * Test if the method returns the same last name as what we initialized.
   */
  @org.junit.Test
  public void getLastName() {
    Assert.assertEquals("Niu", this.bo.getLastName());
  }

  /**
   * Test if the method returns the same address as what we initialized.
   */
  @org.junit.Test
  public void getAddress() {
    Assert.assertEquals("seattle", this.bo.getAddress());
  }

  /**
   * Test if the method returns the same email as what we initialized.
   */
  @org.junit.Test
  public void getEmail() {
    Assert.assertEquals("niubo@gmail.com", this.bo.getEmail());
  }
}