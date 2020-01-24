package handler;

/**
 * Empty class stands for a position that is not seat.
 */
public class Empty extends Position{

  /**
   * Get the enum type of the Empty class.
   *
   * @return EMPTY
   */
  @Override
  public PositionType getType() {
    return PositionType.EMPTY;
  }
}
