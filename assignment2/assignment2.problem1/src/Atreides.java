/**
 * Atreides cabinet class.
 */
public abstract class Atreides extends Cabinet {

  public Atreides(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
  }

  /**
   * Make object to String.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Atreides{}";
  }
}