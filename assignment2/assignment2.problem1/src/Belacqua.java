/**
 * Belacqua Door class.
 */
public abstract class Belacqua extends Door {

  public Belacqua(FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Belacqua{}";
  }
}
