/**
 * GagaQuarterSizeDrawFront DrawerFront class.
 */
public class GagaQuarterSizeDrawFront extends DrawerFront {


  public GagaQuarterSizeDrawFront(FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(false);
    setDepth(18);
    setWidth(36);
    setHeight(18);
    setPrice(100);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "GagaQuarterSizeDrawFront";
  }

  /**
   * Get useful information part related the concrete furniture in the output json file.
   *
   * @return useful information related the concrete furniture
   */
  @Override
  public String getCommentInfo() {
    return "Remember to buy drawer handles.";
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
    return "GagaQuarterSizeDrawFront{}";
  }
}
