/**
 * YossarianWardrobeSize Yossarian Cabinet furniture class.
 */
public class YossarianWardrobeSize extends Yossarian {

  public YossarianWardrobeSize(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
    setPrice(1000);
    setWidth(36);
    setHeight(72);
    setDepth(16);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "YossarianWardrobeSize";
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
        furnitureColor != FurnitureColor.BONE && furnitureColor != FurnitureColor.OXBLOOD) {
      return false;
    }

    if (getShelfNum() > 7) {
      return false;
    }

    if (getDrawerNum() != 0) {
      return false;
    }

    if (getMountedType() == MountedType.WALL) {
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
    return "YossarianWardrobeSize{}";
  }
}
