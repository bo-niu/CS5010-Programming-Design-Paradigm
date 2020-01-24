package furniture;

/**
 * Belacqua Door class.
 */
public abstract class AbstractBelacqua extends AbstractDoor {

  /**
   * Constructor of the Belacqua class.
   *
   * @param furnitureColor furniture's color
   */
  public AbstractBelacqua(final FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Belacqua{}"
        + super.toString();
  }
}
