/**
 * SlothropWardrobeSize Slothrop door class.
 */
public class SlothropWardrobeSize extends Slothrop {


  public SlothropWardrobeSize(FurnitureColor furnitureColor) {
    super(furnitureColor);
    setHandleIncludedFlag(true);
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
    return "SlothropWardrobeSize";
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
    return "SlothropWardrobeSize{}";
  }
}
