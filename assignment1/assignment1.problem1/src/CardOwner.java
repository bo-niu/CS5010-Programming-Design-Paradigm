/**
 * Represent a card owner with their details--first name, last name, address and email.
 *
 * @author Bo Niu
 */
public class CardOwner {

  private String firstName;
  private String lastName;
  private String address;
  private String email;

  /**
   * Create a new card owner given the owner's first name, last name, address and email.
   *
   * @param firstName the owner's first name. Should not be empty.
   * @param lastName  the owner's last name. Should not be empty.
   * @param address   the owner's address.
   * @param email     the owner's email.
   * @throws IllegalArgumentException if the owner's first name or last name is set to be empty.
   */
  public CardOwner(String firstName, String lastName, String address, String email)
      throws IllegalArgumentException {
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("First Name and Last Name cannot be empty.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
  }

  /**
   * Get card owner's first name.
   *
   * @return first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get card owner's last name.
   *
   * @return last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Get card owner's address.
   *
   * @return address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Get card owner's email.
   *
   * @return email
   */
  public String getEmail() {
    return this.email;
  }

}
