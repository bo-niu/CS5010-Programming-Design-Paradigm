import java.util.Objects;
import java.util.jar.Attributes.Name;

/**
 * BaseballPlayer contains information about a basketball player, including their team, average
 * batting and season home runs.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double averageBatting;
  private Integer seasonHomeRun;

  /**
   * BasketballPlayer class constructor.
   *
   * @param athletesName   athlete's name
   * @param height         basketball player's height
   * @param weight         basketball player's weight
   * @param league         basketball player's league
   * @param team           basketball player's team
   * @param averageBatting basketball player's average batting
   * @param seasonHomeRun  basketball player's season home run
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight,
      String league, String team, Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight, league);
    this.averageBatting = averageBatting;
    this.team = team;
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * BasketballPlayer class constructor.
   *
   * @param athletesName   athlete's name
   * @param height         basketball player's height
   * @param weight         basketball player's weight
   * @param team           basketball player's team
   * @param averageBatting basketball player's average batting
   * @param seasonHomeRun  basketball player's season home run
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight,
      String team, Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight);
    this.averageBatting = averageBatting;
    this.team = team;
    this.seasonHomeRun = seasonHomeRun;
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
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) &&
        Objects.equals(averageBatting, that.averageBatting) &&
        Objects.equals(seasonHomeRun, that.seasonHomeRun) &&
        super.equals(o);
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, averageBatting, seasonHomeRun);
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", seasonHomeRun=" + seasonHomeRun +
        '}';
  }

  /**
   * getter of the team.
   *
   * @return team
   */
  public String getTeam() {
    return team;
  }

  /**
   * setter of the team.
   *
   * @param team basketball player's team
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * getter of the average batting.
   *
   * @return basketball player's average batting
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * setter of the average batting.
   *
   * @param averageBatting basketball player's average batting
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * getter of the season home run.
   *
   * @return basketball player's season home run
   */
  public Integer getSeasonHomeRun() {
    return seasonHomeRun;
  }

  /**
   * setter of the season home run.
   *
   * @param seasonHomeRun basketball player's season home run
   */
  public void setSeasonHomeRun(Integer seasonHomeRun) {
    this.seasonHomeRun = seasonHomeRun;
  }
}
