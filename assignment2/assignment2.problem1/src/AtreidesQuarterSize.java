/**
 * AtreidesQuarterSize cabinet class.
 */
public class AtreidesQuarterSize extends Atreides {

  public AtreidesQuarterSize(FurnitureColor furnitureColor,
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
    return "AtreidesQuarterSize";
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
    if (furnitureColor != FurnitureColor.BROWN && furnitureColor != FurnitureColor.BONE) {
      return false;
    }

    int shelfNum = getShelfNum();
    int drawNum = getDrawerNum();

    if (shelfNum <= 1 && drawNum == 0) {
    } else {
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
    return "AtreidesQuarterSize{}";
  }
}
