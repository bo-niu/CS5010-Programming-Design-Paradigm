package furniture;

/**
 * Slothrop door class.
 */
public abstract class AbstractSlothrop extends AbstractDoor {

  /**
   * Constructor of the Slothrop class.
   *
   * @param furnitureColor furniture's color
   */
  public AbstractSlothrop(final FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Slothrop{}"
        + super.toString();
  }
}