/**
 * GagaHalfSize Gaga Door class.
 */
public class GagaHalfSize extends Gaga {


  public GagaHalfSize(FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(false);
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

  @Override
  public String getCommentInfo() {
    return super.getCommentInfo();
  }

  /**
   * Check if the object is valid.
   *
   * @return true if the object is valid
   */
  @Override
  public boolean isValid() {

    FurnitureColor furnitureColor = getFurnitureColor();
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
    return "GagaHalfSize{}";
  }
}
