import java.util.ArrayList;

/**
 * Represent an actor with all properties inherited from artist plus his movies, series and other
 * multi-media.
 *
 * @author Bo Niu
 */
public class Actor extends Artist {

  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;

  /**
   * Create a new actor given his first name, last name, genre, age, awards, movies, series and
   * other multi-media.
   *
   * @param firstName       the actor's first name
   * @param lastName        the actor's last name
   * @param genre           the actor's genre
   * @param age             the actor's age
   * @param awards          the actor's awards
   * @param movies          the actor's movies
   * @param series          the actor's series
   * @param otherMultimedia the actor's other multi-media
   * @throws IllegalArgumentException if exception occurs in Artist class
   */
  public Actor(String firstName, String lastName, String genre, int age, ArrayList<String> awards,
      ArrayList<String> movies, ArrayList<String> series, ArrayList<String> otherMultimedia)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);

    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  /**
   * Add new movies to the actor's movie list.
   *
   * @param newMoive the name of the movie
   */
  public void addMovies(String newMoive) {
    if (newMoive.isEmpty()) {
      return;
    }
    movies.add(newMoive);
  }

  /**
   * Add new series to the actor's series list.
   *
   * @param newSeries the name of the series
   */
  public void addSeries(String newSeries) {
    if (newSeries.isEmpty()) {
      return;
    }
    series.add(newSeries);
  }

  /**
   * Add new multimedia to the actor's series list.
   *
   * @param newOtherMultimedia the name of the multimedia
   */
  public void addOtherMultimedia(String newOtherMultimedia) {
    if (newOtherMultimedia.isEmpty()) {
      return;
    }
    otherMultimedia.add(newOtherMultimedia);
  }

  /**
   * Get the actor's all movies.
   *
   * @return the actor's all movies
   */
  public ArrayList<String> getMovies() {
    return (ArrayList<String>) movies.clone();
  }

  /**
   * Get the actor's all series.
   *
   * @return the actor's all series
   */
  public ArrayList<String> getSeries() {
    return (ArrayList<String>) series.clone();
  }

  /**
   * Get the actor's all multimedia.
   *
   * @return the actor's all multimedia
   */
  public ArrayList<String> getOtherMultimedia() {
    return (ArrayList<String>) otherMultimedia.clone();
  }
}
