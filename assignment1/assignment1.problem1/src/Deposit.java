/**
 * Represent the deposit made to a card with the amount of dollars and cents, the card owner's first
 * name and last name to which the deposit will be made.
 *
 * @author Bo Niu
 */
public class Deposit {

  private int dollar;
  private int cent;
  private String firstName;
  private String lastName;

  /**
   * Create a new deposit given the amount of dollars and cents, the card owner's first name and
   * last name.
   *
   * @param dollar    dollars to be deposited.
   * @param cent      cents to be deposited.
   * @param firstName card owner's first name.
   * @param lastName  card owner's last name.
   * @throws IllegalArgumentException when deposit amount is not in the range of [(5 dollars, 0
   *                                  cents), (50 dollars, 0 cents)], or the card owner's first name
   *                                  or last name is empty.
   */
  public Deposit(int dollar, int cent, String firstName, String lastName)
      throws IllegalArgumentException {

    if (dollar < 5 || dollar > 50 || cent < 0 || cent > 99 || (dollar == 50 && cent > 0)) {
      throw new IllegalArgumentException(
          "Deposit amount should be in the range [(5 dollars, 0 cents), (50 dollars, 0 cents)].");
    }
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("FirstName and LastName should not be empty.");
    }

    this.dollar = dollar;
    this.cent = cent;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the amount of dollars of the deposit.
   *
   * @return the dollars
   */
  public int getDollar() {
    return this.dollar;
  }

  /**
   * Get the amount of cents of the deposit.
   *
   * @return the cents
   */
  public int getCent() {
    return this.cent;
  }

  /**
   * Get the card owner's first name.
   *
   * @return the card owner's first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get the card owner's last name.
   *
   * @return the card owner's last name
   */
  public String getLastName() {
    return this.lastName;
  }

}
