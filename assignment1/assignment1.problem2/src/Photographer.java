import java.util.ArrayList;

/**
 * Represent a photographer.
 *
 * @author Bo Niu
 */
public class Photographer extends Artist {

  /**
   * Create a new photographer given his first name, last name, genre, age and awards.
   *
   * @param firstName the photographer's first name
   * @param lastName  the photographer's last name
   * @param genre     the photographer's gender
   * @param age       the photographer's age
   * @param awards    the photographer's awards
   * @throws IllegalArgumentException if the input age is less than 0 or higher than 128
   */
  public Photographer(String firstName, String lastName, String genre, int age,
      ArrayList<String> awards)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);
  }
}
