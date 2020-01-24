package furniture;

/**
 * LuthienHalfSize Luthien cabinet class.
 */
public class LuthienHalfSize extends AbstractLuthien {

  public LuthienHalfSize(final FurnitureColor furnitureColor,
      final MountedType mountedType, final int shelfNum, final int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
    setPrice(800);
    setWidth(36);
    setHeight(36);
    setDepth(18);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "LuthienHalfSize";
  }

  /**
   * Get the additional information related the object that is easy for customers to forget. Used to
   * remind customers when the object is in the recommendation list. This part makes up the comments
   * field in the output json file.
   *
   * @return additional information related the object
   */
  @Override
  public String getCommentInfo() {
    return null;
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

    if (getShelfNum() < 0 || getDrawerNum() < 0) {
      return false;
    }

    FurnitureColor furnitureColor = getFurnitureColor();
    if (furnitureColor != FurnitureColor.BLACK && furnitureColor != FurnitureColor.BONE) {
      return false;
    }

    final int shelfNum = getShelfNum();
    final int drawNum = getDrawerNum();

    if ((shelfNum <= 3 && drawNum == 0) || (drawNum == 1 && shelfNum <= 2)) {
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
    return "LuthienHalfSize{}"
        + super.toString();
  }
}
