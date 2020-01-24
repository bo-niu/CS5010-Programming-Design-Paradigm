/**
 * AtreidesHalfSize cabinet class.
 */
public class AtreidesHalfSize extends Atreides {

  /**
   * constructor.
   *
   * @param furnitureColor furnitureColor
   * @param mountedType    mountedType
   * @param shelfNum       shelfNum
   * @param drawerNum      drawerNum
   */
  public AtreidesHalfSize(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
    setPrice(800);
    setWidth(36);
    setHeight(36);
    setDepth(16);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "AtreidesHalfSize";
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

    if (shelfNum <= 3 && drawNum == 0) {
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
    return "AtreidesHalfSize{}";
  }
}
