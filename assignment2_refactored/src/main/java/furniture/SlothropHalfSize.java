package furniture;

/**
 * SlothropHalfSize Slothrop door class.
 */
public class SlothropHalfSize extends AbstractSlothrop {

  /**
   * Constructor of the SlothropHalfSize class.
   *
   * @param furnitureColor furniture's color
   */
  public SlothropHalfSize(final FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(true);
    setHeight(36);
    setWidth(36);
    setPrice(600);
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  @Override
  public String getJsonInfo() {
    return "SlothropHalfSize";
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
    if (furnitureColor != FurnitureColor.BROWN && furnitureColor != FurnitureColor.BLACK) {
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
    return "SlothropHalfSize{}"
        + super.toString();
  }
}
