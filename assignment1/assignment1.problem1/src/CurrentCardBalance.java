/**
 * Represent current card balance of a card with dollar and cent.
 *
 * @author Bo Niu
 */
public class CurrentCardBalance {

  private int dollar;
  private int cent;

  /**
   * Create a new card balance given the initial dollor and cent in the card.
   *
   * @param dollar initial dollar in the card
   * @param cent   initial cent in the card
   * @throws IllegalArgumentException if dollar is less than 0 or cent falls outside [0, 99].
   */
  public CurrentCardBalance(int dollar, int cent) throws IllegalArgumentException {
    if (dollar < 0 || cent < 0 || cent > 99) {
      throw new IllegalArgumentException(
          "dollar amount should be greater or equal to 0, and cents amount should be greater or equal to 0 and less than or\n"
              + "equal to 99.");
    }
    this.dollar = dollar;
    this.cent = cent;
  }

  /**
   * Get current dollars in the card.
   *
   * @return current dollar in the card
   */
  public int getDollar() {
    return this.dollar;
  }

  /**
   * Get current cents in the card.
   *
   * @return current cents in the card
   */
  public int getCent() {
    return this.cent;
  }

  /**
   * Set current dollar and cent in the card.
   *
   * @param dollar the dollars
   * @param cent   the cents
   * @return true if the process succeeds. Otherwise return false.
   */
  public boolean setMoney(int dollar, int cent) {
    if (dollar < 0 || cent < 0 || cent > 99) {
      return false;
    }
    this.dollar = dollar;
    this.cent = cent;
    return true;
  }


}
Deposit d = new Deposit(-5, -10);
depositMoney(dollar d){

}