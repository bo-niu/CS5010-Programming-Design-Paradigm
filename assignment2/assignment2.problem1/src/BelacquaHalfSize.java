/**
 * BelacquaHalfSize Belacqua Door class.
 */
public class BelacquaHalfSize extends Belacqua {


  public BelacquaHalfSize(FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(true);
    setHeight(36);
    setWidth(36);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "BelacquaHalfSize{}";
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "BelacquaHalfSize";
  }

  /**
   * Get useful information part related the concrete furniture in the output json file.
   *
   * @return useful information related the concrete furniture
   */
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
    if (furnitureColor != FurnitureColor.BONE && furnitureColor != FurnitureColor.OXBLOOD) {
      return false;
    }

    return true;
  }
}
