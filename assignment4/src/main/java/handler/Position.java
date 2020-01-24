package handler;

/**
 * Position class stands for a grid in the event place.
 */
public abstract class Position {

  private int gRow;
  private int gCol;
  public abstract PositionType getType();

  /**
   * Setter of the global row.
   * @param gRow global row
   */
  public void setgRow(int gRow) {
    this.gRow = gRow;
  }

  /**
   * Setter of the global column.
   * @param gCol global column
   */
  public void setgCol(int gCol) {
    this.gCol = gCol;
  }
}
