import java.util.Objects;

/**
 * Restaurant class contains information about the restaurant's name, menu, address and the state of
 * open or closed.
 */
public class Restaurant {

  private String name;
  private Menu menu;
  private Address address;
  private boolean openFlag;

  /**
   * Constructor of the Restaurant class.
   *
   * @param name     the restaurant's name
   * @param menu     the restaurant's menu
   * @param address  the restaurant's address
   * @param openFlag whether or not the restaurant is open
   */
  public Restaurant(String name, Menu menu, Address address, boolean openFlag) {
    this.name = name;
    this.menu = menu;
    this.address = address;
    this.openFlag = openFlag;
  }

  /**
   * Whether or not this object is equal to the other object.
   *
   * @param o the other object
   * @return true if two object is equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Restaurant)) {
      return false;
    }
    Restaurant that = (Restaurant) o;
    return openFlag == that.openFlag &&
        Objects.equals(name, that.name) &&
        Objects.equals(menu, that.menu) &&
        Objects.equals(address, that.address);
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, menu, address, openFlag);
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Restaurant{" +
        "name='" + name + '\'' +
        ", menu=" + menu +
        ", address=" + address +
        ", openFlag=" + openFlag +
        '}';
  }

  /**
   * Getter of the restaurant's name.
   *
   * @return the restaurant's name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter of the restaurant's name.
   *
   * @param name the restaurant's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter of the restaurant's menu.
   *
   * @return the restaurant's menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Setter of the restaurant's menu.
   *
   * @param menu the restaurant's menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * Getter of the restaurant's address.
   *
   * @return the restaurant's address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Setter of the restaurant's address.
   *
   * @param address the restaurant's address
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Getter of the restaurant's open flag.
   *
   * @return true if the restaurant is open
   */
  public boolean isOpenFlag() {
    return openFlag;
  }

  /**
   * Setter of the restaurant's open flag.
   *
   * @param openFlag the restaurant's open flag.
   */
  public void setOpenFlag(boolean openFlag) {
    this.openFlag = openFlag;
  }
}
