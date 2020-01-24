package furniture;

/**
 * BelacquaWardrobeSize Belacqua Door class.
 */
public class BelacquaWardrobeSize extends AbstractBelacqua {

  /**
   * Constructor of the BelacquaWardrobeSize class.
   *
   * @param furnitureColor furniture's color
   */
  public BelacquaWardrobeSize(final FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(true);
    setPrice(1000);
    setHeight(72);
    setWidth(36);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "BelacquaWardrobeSize";
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
    return super.getCommentInfo();
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
    if (furnitureColor != FurnitureColor.BONE && furnitureColor != FurnitureColor.OXBLOOD) {
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
    return "BelacquaWardrobeSize{}"
        + super.toString();
  }
}