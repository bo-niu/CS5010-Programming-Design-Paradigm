import java.util.ArrayList;

/**
 * Represent a filmmaker with all properties inherited from artist plus his movies, series and other
 * multi-media.
 *
 * @author Bo Niu
 */
public class Filmmaker extends Artist {

  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;

  /**
   * Create a new filmmaker given his first name, last name, genre, age, awards, movies, series and
   * other multi-media.
   *
   * @param firstName       the filmmaker's first name
   * @param lastName        the filmmaker's last name
   * @param genre           the filmmaker's genre
   * @param age             the filmmaker's age
   * @param awards          the filmmaker's awards
   * @param movies          the filmmaker's movies
   * @param series          the filmmaker's series
   * @param otherMultimedia the filmmaker's other multi-media
   * @throws IllegalArgumentException if exception occurs in Artist class
   */
  public Filmmaker(String firstName, String lastName, String genre, int age,
      ArrayList<String> awards,
      ArrayList<String> movies, ArrayList<String> series, ArrayList<String> otherMultimedia)
      throws IllegalArgumentException {
    super(firstName, lastName, genre, age, awards);

    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  /**
   * Add new movies to the filmmaker's movie list.
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
   * Add new series to the filmmaker's series list.
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
   * Add new multimedia to the filmmaker's series list.
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
   * Get the filmmaker's all movies.
   *
   * @return the filmmaker's all movies
   */
  public ArrayList<String> getMovies() {
    return (ArrayList<String>) movies.clone();
  }

  /**
   * Get the filmmaker's all series.
   *
   * @return the filmmaker's all series
   */
  public ArrayList<String> getSeries() {
    return (ArrayList<String>) series.clone();
  }

  /**
   * Get the filmmaker's all multimedia.
   *
   * @return the filmmaker's all multimedia
   */
  public ArrayList<String> getOtherMultimedia() {
    return (ArrayList<String>) otherMultimedia.clone();
  }
}
