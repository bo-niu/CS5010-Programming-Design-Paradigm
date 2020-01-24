import java.util.Objects;
import java.util.jar.Attributes.Name;

/*
* Class Athlete contains information about an athlete, including athlete's name,
their height, weight and league.
*/
public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /*
  * Constructs a new athlete, based upon all of the provided input parameters.
  * @param athletesName - object Name, containing athlete's first, middle and last
 name
  * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
 recorded as 187.96cm)
  * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
 200 pounds)
  * @param league - athlete's league, expressed as String
  * @return - object Athlete
  */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }
 /*
 * Constructs a new athlete, based upon all of the provided input parameters.
 * @param athletesName - object Name, containing athlete's first, middle and last
name
 * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
recorded as 187.96cm)
 * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
200 pounds)
 * @return - object Athlete, with league field set to null
 */

  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /*
   * Returns athlete's name as an object Name
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /*
   * Returns athlete's height as a Double
   */
  public Double getHeight() {
    return height;
  }

  /*
   * Returns athlete's weight as a Double
   */
  public Double getWeight() {
    return weight;
  }

  /*
   * Returns athlete's league as a String
   */
  public String getLeague() {
    return league;
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Athlete{" +
        "athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(getAthletesName(), athlete.getAthletesName()) &&
        Objects.equals(getHeight(), athlete.getHeight()) &&
        Objects.equals(getWeight(), athlete.getWeight()) &&
        Objects.equals(getLeague(), athlete.getLeague());
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAthletesName(), getHeight(), getWeight(), getLeague());
  }

  /**
   * setter of the athletes' name.
   *
   * @param athletesName athlete's name
   */
  public void setAthletesName(Name athletesName) {
    this.athletesName = athletesName;
  }

  /**
   * setter of the athlete's height.
   *
   * @param height athlete's height
   */
  public void setHeight(Double height) {
    this.height = height;
  }

  /**
   * setter of athlete's weight.
   *
   * @param weight athlete's weight
   */
  public void setWeight(Double weight) {
    this.weight = weight;
  }

  /**
   * setter of the athlete's league.
   *
   * @param league athlete's league
   */
  public void setLeague(String league) {
    this.league = league;
  }
}