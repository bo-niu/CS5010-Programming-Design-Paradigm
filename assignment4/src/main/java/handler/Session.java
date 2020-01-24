package handler;

import java.util.ArrayList;

/**
 * Session class stands for a session the the venue.
 */
public class Session {

  private String name;
  private Seat[][] seats;

  /**
   * Constructor.
   * @param name session's name
   */
  public Session(String name) {
    this.name = name;
  }

  /**
   * Getter of the session's name.
   * @return session's name
   */
  public String getName() {
    return name;
  }

  /**
   * Getter of all sesats in the session.
   * @return seat array
   */
  public Seat[][] getSeats() {
    return seats;
  }

  /**
   * Setter of the session's name
   * @param name session's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Setter of the seat array.
   * @param seats seat array
   */
  public void setSeats(Seat[][] seats) {
    this.seats = seats;
  }
}
