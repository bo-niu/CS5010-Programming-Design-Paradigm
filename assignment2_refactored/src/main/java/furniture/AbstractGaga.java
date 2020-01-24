package furniture;

/**
 * Gaga Door class.
 */
public abstract class AbstractGaga extends AbstractDoor {

  public AbstractGaga(final FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Gaga{}"
        + super.toString();
  }
}
