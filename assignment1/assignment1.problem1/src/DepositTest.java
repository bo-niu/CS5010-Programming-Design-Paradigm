import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class DepositTest.
 */
public class DepositTest {

  /**
   * testDeposit is the object we use to test the Deposit class.
   */
  private Deposit testDeposit;

  /**
   * In this method, we initialize testDeposit.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    testDeposit = new Deposit(45, 20, "Bo", "Niu");
  }

  /**
   * Test if the method returns the same dollars as what we initialized.
   */
  @Test
  public void getDollar() {
    Assert.assertEquals(45, this.testDeposit.getDollar());
  }

  /**
   * Test if the method returns the same cents as what we initialized.
   */
  @Test
  public void getCent() {
    Assert.assertEquals(20, this.testDeposit.getCent());
  }

  /**
   * Test if the method returns the same first name as what we initialized.
   */
  @Test
  public void getFirstName() {
    Assert.assertEquals("Bo", this.testDeposit.getFirstName());
  }

  /**
   * Test if the method returns the same last name as what we initialized.
   */
  @Test
  public void getLastName() {
    Assert.assertEquals("Niu", this.testDeposit.getLastName());
  }
}