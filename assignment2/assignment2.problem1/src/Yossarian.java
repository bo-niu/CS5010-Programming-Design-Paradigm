/**
 * Yossarian Cabinet furniture class.
 */
public abstract class Yossarian extends Cabinet {

  public Yossarian(FurnitureColor furnitureColor,
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
    return "Yossarian{}";
  }
}
