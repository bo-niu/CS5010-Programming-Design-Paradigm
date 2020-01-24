import java.util.ArrayList;

/**
 * Represent a painter.
 *
 * @author Bo Niu
 */
public class Painter extends Artist {

  /**
   * Create a new painter given his first name, last name, genre, age and awards.
   *
   * @param firstName the painter's first name
   * @param lastName  the painter's last name
   * @param genre     the painter's gender
   * @param age       the painter's age
   * @param awards    the painter's awards
   * @throws IllegalArgumentException if the input age is less than 0 or higher than 128
   */
  public Painter(String firstName, String lastName, String genre, int age, ArrayList<String> awards)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);
  }
}
