import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class CurrentCardBalanceTest.
 */
public class CurrentCardBalanceTest {

  /**
   * testBalance is the object we use to test the CurrentCardBalance class.
   */
  private CurrentCardBalance testBalance;

  /**
   * In this method, we initialize testBalance.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testBalance = new CurrentCardBalance(100, 2);
  }

  /**
   * Test if the exception is thrown when we create an illegal card balance -- No.1
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException1() {
    CurrentCardBalance badBalance = new CurrentCardBalance(-5, 2);
  }

  /**
   * Test if the exception is thrown when we create an illegal card balance -- No.2
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException2() {
    CurrentCardBalance badBalance = new CurrentCardBalance(50, -50);
  }

  /**
   * Test if the exception is thrown when we create an illegal card balance -- No.3
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void getException3() {
    CurrentCardBalance badBalance = new CurrentCardBalance(50, 200);
  }


  /**
   * Test if the method returns the same dollars as what we initialized.
   */
  @Test
  public void getDollar() {
    Assert.assertEquals(100, this.testBalance.getDollar());
  }

  /**
   * Test if the method returns the same cents as what we initialized.
   */
  @Test
  public void getCent() {
    Assert.assertEquals(2, this.testBalance.getCent());
  }

  /**
   * Test if the money is what we set after we call the setMoney Function.
   */
  @Test
  public void setMoney() {

    this.testBalance.setMoney(200, 3);
    Assert.assertEquals(200, this.testBalance.getDollar());
    Assert.assertEquals(3, this.testBalance.getCent());
  }
}