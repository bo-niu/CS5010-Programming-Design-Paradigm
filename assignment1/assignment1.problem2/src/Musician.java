import java.util.ArrayList;

/**
 * Represent a musician.
 *
 * @author Bo Niu
 */
public class Musician extends Artist {

  /**
   * Create a new musician given his first name, last name, genre, age and awards.
   *
   * @param firstName the musician's first name
   * @param lastName  the musician's last name
   * @param genre     the musician's gender
   * @param age       the musician's age
   * @param awards    the musician's awards
   * @throws IllegalArgumentException if the input age is less than 0 or higher than 128
   */
  public Musician(String firstName, String lastName, String genre, int age,
      ArrayList<String> awards)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);
  }
}
