import java.util.ArrayList;

/**
 * Represent a poet.
 *
 * @author Bo Niu
 */
public class Poet extends Artist {

  /**
   * Create a new poet given his first name, last name, genre, age and awards.
   *
   * @param firstName the poet's first name
   * @param lastName  the poet's last name
   * @param genre     the poet's gender
   * @param age       the poet's age
   * @param awards    the poet's awards
   * @throws IllegalArgumentException if the input age is less than 0 or higher than 128
   */
  public Poet(String firstName, String lastName, String genre, int age, ArrayList<String> awards)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);
  }
}
