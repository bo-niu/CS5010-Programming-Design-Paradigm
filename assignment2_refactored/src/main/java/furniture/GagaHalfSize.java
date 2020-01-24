package furniture;

/**
 * GagaHalfSize Gaga Door class.
 */
public class GagaHalfSize extends AbstractGaga {

  /**
   * Constructor of the GagaHalfSize class.
   *
   * @param furnitureColor furniture's color
   */
  public GagaHalfSize(final FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(false);
    setPrice(800);
    setHeight(36);
    setWidth(36);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "GagaHalfSize";
  }

  /**
   * when using some loops to create some objects of this class, some of the objected created might
   * be invalid since for example this class doesn't have some specific color. Therefore, this
   * function is used to check whether the object created is valid or not.
   *
   * @return true if the object is valid
   */
  @Override
  public boolean isValid() {

    final FurnitureColor furnitureColor = getFurnitureColor();
    if (furnitureColor != FurnitureColor.BONE && furnitureColor != FurnitureColor.OXBLOOD &&
        furnitureColor != FurnitureColor.BROWN && furnitureColor != FurnitureColor.BLACK) {
      return false;
    }

    return true;
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "GagaHalfSize{}"
        + super.toString();
  }
}
