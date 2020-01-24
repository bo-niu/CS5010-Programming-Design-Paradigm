package handler;

/**
 * Seat is a kind of position in the venue. A seat is one grid in the venue.
 */
public class Seat extends Position{

  private boolean isAvailable;
  private boolean isForWheelchair;
  private boolean isPrinted;
  private String seatName;
  private String bookerName;
  private int price;
  private int row;
  private SingleRequest singleRequest;
  private int col;
  private Session session;

  /**
   * Setter of whether the seat is available or not.
   * @param available true if the seat is available
   */
  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  /**
   * Whether the seat is for wheel chair.
   * @param forWheelchair true if the seat if for wheel chair
   */
  public void setForWheelchair(boolean forWheelchair) {
    isForWheelchair = forWheelchair;
  }

  /**
   * Whether the person who has been assigned the seat has printed his ticket meaning that the seat
   * can no longer be assigned to other people.
   * @param printed true if it is printed
   */
  public void setPrinted(boolean printed) {
    isPrinted = printed;
  }

  /**
   * Setter of the seat's name.
   * @param seatName seat's name
   */
  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  /**
   * Setter of the seat's booker's name
   * @param bookerName booker's name
   */
  public void setBookerName(String bookerName) {
    this.bookerName = bookerName;
  }

  /**
   * The price of the seat.
   * @param price price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * The row in which the seat is located in the session.
   * @param row row
   */
  public void setRow(int row) {
    this.row = row;
  }

  /**
   * The column in which the seat is located in the session.
   * @param col column
   */
  public void setCol(int col) {
    this.col = col;
  }

  /**
   * Constructor.
   * @param isAvailable whether the seat is still available
   * @param isForWheelchair whether the seat is for wheel chair
   * @param isPrinted whether the booker has printed his ticket
   * @param seatName seat's name
   * @param bookerName booker's name
   * @param price seat's price
   * @param row row in which the seat is located in the session.
   * @param col column in which the seat is located in the session.
   * @param session the session in which the seat is in.
   */
  public Seat(boolean isAvailable, boolean isForWheelchair, boolean isPrinted,
      String seatName, String bookerName, int price, int row, int col, Session session) {
    this.isAvailable = isAvailable;
    this.isForWheelchair = isForWheelchair;
    this.isPrinted = isPrinted;
    this.seatName = seatName;
    this.bookerName = bookerName;
    this.price = price;
    this.row = row;
    this.col = col;
    this.session = session;
    singleRequest = null;
  }

  /**
   * Get the type of the position.
   * @return SEAT
   */
  @Override
  public PositionType getType() {
    return PositionType.SEAT;
  }

  /**
   * Getter of the session.
   * @return session
   */
  public Session getSession() {
    return session;
  }

  /**
   * Setter of the session
   * @param session session
   */
  public void setSession(Session session) {
    this.session = session;
  }

  /**
   * Whether the seat is still available.
   * @return true if it is available
   */
  public boolean isAvailable() {
    return isAvailable;
  }

  /**
   * Whether the seat is for wheel chair use.
   * @return true if it is
   */
  public boolean isForWheelchair() {
    return isForWheelchair;
  }

  /**
   * Whether the booker has printed the ticket.
   * @return true if he has done that
   */
  public boolean isPrinted() {
    return isPrinted;
  }

  /**
   * Getter of the seat's name.
   * @return seat's name
   */
  public String getSeatName() {
    return seatName;
  }

  /**
   * Getter of the booker's name
   * @return booker's name
   */
  public String getBookerName() {
    return bookerName;
  }

  /**
   * Getter of the price.
   * @return price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Getter of the row in which the seat is in the session.
   * @return row
   */
  public int getRow() {
    return row;
  }

  /**
   * Getter of the column in which the seat is in the session.
   * @return column
   */
  public int getCol() {
    return col;
  }

  /**
   * Getter of the single ticket request in which the seat is assigned.
   * @return the single ticket request
   */
  public SingleRequest getSingleRequest() {
    return singleRequest;
  }

  /**
   * Setter of the single ticket request in which the seat is assigned.
   * @param singleRequest the single ticket request
   */
  public void setSingleRequest(SingleRequest singleRequest) {
    this.singleRequest = singleRequest;
  }
}
