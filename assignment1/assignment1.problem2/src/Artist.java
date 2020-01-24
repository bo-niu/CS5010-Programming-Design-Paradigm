import java.util.ArrayList;

/**
 * Represent an Artist with first name, last name, genre, age and awards. Note: this class is an
 * abstract class which cannot be instantiated.
 *
 * @author Bo Niu
 */
public abstract class Artist {

  private String firstName;
  private String lastName;
  private String genre;
  private int age;
  private ArrayList<String> awards;

  /**
   * Create a new artist given his first name, last name, genre, age and awards.
   *
   * @param firstName the artist's first name
   * @param lastName  the actor's last name
   * @param genre     the actor's genre
   * @param age       the actor's age
   * @param awards    the actor's awards
   * @throws IllegalArgumentException if the input first name or last name is empty, or age falls
   *                                  outside [0, 128]
   */
  public Artist(String firstName, String lastName, String genre, int age, ArrayList<String> awards)
      throws IllegalArgumentException {

    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("first name and last name cannot be empty.");
    }
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("age should be in the range of 0 and 128.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.genre = genre;
    this.awards = awards;
  }

  /**
   * Get the artist's first name.
   *
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the artist's last name.
   *
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the artist's genre.
   *
   * @return the genre.
   */
  public String getGenre() {
    return genre;
  }

  /**
   * Get the artist's age.
   *
   * @return the age.
   */
  public int getAge() {
    return age;
  }

  /**
   * Get the artist's awards.
   *
   * @return the awards.
   */
  public ArrayList<String> getAwards() {
    return (ArrayList<String>) awards.clone();
  }

  /**
   * Add new awards to the artist.
   *
   * @param newAward the name of the award
   */
  public void addAward(String newAward) {
    if (newAward.isEmpty()) {
      return;
    }
    awards.add(newAward);
  }
}
