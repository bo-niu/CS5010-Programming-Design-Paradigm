import java.util.Objects;

/**
 * Address class contains information about street and number, city, zip code, state, country of a
 * restaurant.
 */
public class Address {

  private String streetNum;
  private String city;
  private String zip;
  private String state;
  private String country;

  /**
   * constructor of the Address class.
   *
   * @param streetNum street and number
   * @param city      city
   * @param zip       zip code
   * @param state     state
   * @param country   country
   */
  public Address(String streetNum, String city, String zip, String state, String country) {
    this.streetNum = streetNum;
    this.city = city;
    this.zip = zip;
    this.state = state;
    this.country = country;
  }

  /**
   * getter of the street and number.
   *
   * @return street and number
   */
  public String getStreetNum() {
    return streetNum;
  }

  /**
   * setter of the street and number.
   *
   * @param streetNum street and number
   */
  public void setStreetNum(String streetNum) {
    this.streetNum = streetNum;
  }

  /**
   * getter of the city.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  /**
   * setter of the city.
   *
   * @param city city name
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * getter of the zip code.
   *
   * @return zip code
   */
  public String getZip() {
    return zip;
  }

  /**
   * setter of the zip code.
   *
   * @param zip zip code
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * getter of the state.
   *
   * @return state name
   */
  public String getState() {
    return state;
  }

  /**
   * setter of the state name.
   *
   * @param state state name
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * getter of the country name.
   *
   * @return country name
   */
  public String getCountry() {
    return country;
  }

  /**
   * setter of the country name.
   *
   * @param country country name
   */
  public void setCountry(String country) {
    this.country = country;
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
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getStreetNum(), address.getStreetNum()) &&
        Objects.equals(getCity(), address.getCity()) &&
        Objects.equals(getZip(), address.getZip()) &&
        Objects.equals(getState(), address.getState()) &&
        Objects.equals(getCountry(), address.getCountry());
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getStreetNum(), getCity(), getZip(), getState(), getCountry());
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Address{" +
        "streetNum='" + streetNum + '\'' +
        ", city='" + city + '\'' +
        ", zip='" + zip + '\'' +
        ", state='" + state + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
