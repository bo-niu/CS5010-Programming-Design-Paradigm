import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the test class for the class TransitCard.
 */
public class TransitCardTest {

  /**
   * testCard is the object we use to test the TransitCard class.
   */
  private TransitCard testCard;

  /**
   * In this method, we initialize testCard.
   *
   * @throws Exception if any exception occurs.
   */
  @Before
  public void setUp() throws Exception {
    CardOwner testOwner = new CardOwner("Bo", "Niu", "seattle", "niubo@gmail.com");
    CurrentCardBalance testBalance = new CurrentCardBalance(100, 0);
    testCard = new TransitCard(testOwner, testBalance);
  }

  /**
   * Test if the method returns the same dollars as what we initialized.
   */
  @Test
  public void getDollar() {
    Assert.assertEquals(100, this.testCard.getDollar());
  }

  /**
   * Test if the method returns the same dollars as what we initialized.
   */
  @Test
  public void getCent() {
    Assert.assertEquals(0, this.testCard.getCent());
  }

  /**
   * Test if the remaining money changes after a new successful deposit and after a failed deposit.
   */
  @Test
  public void depositMoney() {
    Deposit deposit = new Deposit(30, 10, "Bo", "Niu");
    boolean b = testCard.depositMoney(deposit);
    Assert.assertEquals(true, b);
    Assert.assertEquals(130, this.testCard.getDollar());
    Assert.assertEquals(10, this.testCard.getCent());

    deposit = new Deposit(30, 10, "Kobe", "Bryant");
    b = testCard.depositMoney(deposit);
    Assert.assertEquals(false, b);
    Assert.assertEquals(130, this.testCard.getDollar());
    Assert.assertEquals(10, this.testCard.getCent());

  }
}