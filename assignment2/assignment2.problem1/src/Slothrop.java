/**
 * Slothrop door class.
 */
public abstract class Slothrop extends Door {

  public Slothrop(FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Slothrop{}";
  }
}