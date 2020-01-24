import java.util.Objects;
import java.util.jar.Attributes.Name;

/**
 * Runner class contains information about a runner, including their best 5k time, best half
 * marathon time and their favorite running event.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Runner class constructor.
   *
   * @param athletesName         athlete's name
   * @param height               athlete's height
   * @param weight               athlete's weight
   * @param league               athlete's league
   * @param best5KTime           athlete's best 5000 time
   * @param bestHalfMarathonTime athlete's best half marathon time
   * @param favoriteRunningEvent athlete's favorite running event
   */
  public Runner(Name athletesName, Double height, Double weight,
      String league, Double best5KTime, Double bestHalfMarathonTime,
      String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Runner class constructor.
   *
   * @param athletesName         athlete's name
   * @param height               athlete's height
   * @param weight               athlete's weight
   * @param best5KTime           athlete's best 5000 time
   * @param bestHalfMarathonTime athlete's best half marathon time
   * @param favoriteRunningEvent athlete's favorite running event
   */
  public Runner(Name athletesName, Double height, Double weight,
      Double best5KTime, Double bestHalfMarathonTime,
      String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Runner{" +
        "best5KTime=" + best5KTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
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
    if (!(o instanceof Runner)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(getBest5KTime(), runner.getBest5KTime()) &&
        Objects.equals(getBestHalfMarathonTime(), runner.getBestHalfMarathonTime()) &&
        Objects.equals(getFavoriteRunningEvent(), runner.getFavoriteRunningEvent()) &&
        super.equals(o);
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBest5KTime(), getBestHalfMarathonTime(),
        getFavoriteRunningEvent());
  }

  /**
   * Getter of the best 5k time.
   *
   * @return best 5k time
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Setter of the best 5k time.
   *
   * @param best5KTime best 5k time
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Getter of the best half marathon time.
   *
   * @return best half marathon time
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Setter of the best half marathon time.
   *
   * @param bestHalfMarathonTime best half marathon time
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * Getter of the favorite running event.
   *
   * @return favorite running event
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  /**
   * Setter of the favorite running event.
   *
   * @param favoriteRunningEvent favorite running event
   */
  public void setFavoriteRunningEvent(String favoriteRunningEvent) {
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

}
