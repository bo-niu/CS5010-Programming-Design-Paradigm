/**
 * YossarianQuarterSize Yossarian Cabinet furniture class.
 */
public class YossarianQuarterSize extends Yossarian {

  public YossarianQuarterSize(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
    setPrice(600);
    setWidth(36);
    setHeight(18);
    setDepth(16);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "YossarianQuarterSize";
  }

  /**
   * Get useful information part related the concrete furniture in the output json file.
   *
   * @return useful information related the concrete furniture
   */
  @Override
  public String getCommentInfo() {
    return null;
  }

  /**
   * Check if the object is valid.
   *
   * @return true if the object is valid
   */
  @Override
  public boolean isValid() {

    if (getShelfNum() < 0 || getDrawerNum() < 0) {
      return false;
    }

    FurnitureColor furnitureColor = getFurnitureColor();
    if (furnitureColor != FurnitureColor.BROWN && furnitureColor != FurnitureColor.BLACK &&
        furnitureColor != FurnitureColor.BONE) {
      return false;
    }

    if (getShelfNum() > 1) {
      return false;
    }

    if (getDrawerNum() != 0) {
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
    return "YossarianQuarterSize{}";
  }
}
