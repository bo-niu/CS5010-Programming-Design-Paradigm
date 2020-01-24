import java.util.Objects;

/**
 * Door Furniture class.
 */
public abstract class Door extends Furniture {

  private boolean handleIncludedFlag;

  public boolean isHandleIncludedFlag() {
    return handleIncludedFlag;
  }

  protected void setHandleIncludedFlag(boolean handleIncludedFlag) {
    this.handleIncludedFlag = handleIncludedFlag;
  }

  @Override
  public String getCommentInfo() {
    String comment = "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.";
    String handle = "";
    if (!handleIncludedFlag) {
      handle = "Remember to buy door handles.";
    }
    String result = comment + handle;
    return result;
  }

  public Door(FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Compare two ResponseSolver object.
   *
   * @param o ResponseSolver object
   * @return true if two object are the same.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Door)) {
      return false;
    }
    Door door = (Door) o;
    return isHandleIncludedFlag() == door.isHandleIncludedFlag();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(isHandleIncludedFlag());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Door{" +
        "handleIncludedFlag=" + handleIncludedFlag +
        '}';
  }
}
