/**
 * Represent a transit card with a method to deposit money to it.
 *
 * @author Bo Niu
 */
public class TransitCard {

  /**
   * Contain all information related to the card owner.
   */
  private CardOwner cardOwner;
  /**
   * Contain all information related to the current card balance.
   */
  private CurrentCardBalance currentCardBalance;

  /**
   * Create a new transit card given the information of the card owner and initial card balance.
   *
   * @param owner       the card owner
   * @param cardBalance initial card balance
   */
  public TransitCard(CardOwner owner, CurrentCardBalance cardBalance) {
    cardOwner = owner;
    currentCardBalance = cardBalance;
  }

  /**
   * Make new deposit using this method.
   *
   * @param newDeposit all information of the new deposit.
   * @return true if the new deposit succeeds, or false if the name does not match with the card
   * owner.
   */
  public boolean depositMoney(Deposit newDeposit) {

    if (!newDeposit.getFirstName().equals(cardOwner.getFirstName()) || !newDeposit.getLastName()
        .equals(cardOwner.getLastName())) {
      return false;
    }

    int curCent =
        currentCardBalance.getCent() + currentCardBalance.getDollar() * 100 + (newDeposit.getCent()
            + newDeposit.getDollar() * 100);
    return currentCardBalance.setMoney(curCent / 100, curCent % 100);
  }

  /**
   * Get current dollars in the card.
   *
   * @return current dollars in the card
   */
  public int getDollar() {
    return currentCardBalance.getDollar();
  }

  /**
   * Get current cents in the card.
   *
   * @return current cents in the card
   */
  public int getCent() {
    return currentCardBalance.getCent();
  }

}

