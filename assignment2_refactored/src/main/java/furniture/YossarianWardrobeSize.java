package furniture;

/**
 * YossarianWardrobeSize Yossarian Cabinet furniture class.
 */
public class YossarianWardrobeSize extends AbstractYossarian {

  /**
   * Constructor of YossarianWardrobeSize class.
   *
   * @param furnitureColor furniture's color
   * @param mountedType    mounted type
   * @param shelfNum       shelf number
   * @param drawerNum      drawer number
   */
  public YossarianWardrobeSize(final FurnitureColor furnitureColor,
      final MountedType mountedType, final int shelfNum, final int drawerNum) {
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

    final FurnitureColor furnitureColor = getFurnitureColor();
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
    return "YossarianWardrobeSize{}"
        + super.toString();
  }
}
