/**
 * Luthien cabinet class.
 */
public abstract class Luthien extends Cabinet {

  public Luthien(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Luthien{}";
  }
}