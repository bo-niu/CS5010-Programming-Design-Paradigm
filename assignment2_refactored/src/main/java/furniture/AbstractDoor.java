package furniture;

import java.util.Objects;

/**
 * Door Furniture class.
 */
public abstract class AbstractDoor extends AbstractFurniture {

  private boolean handleIncludedFlag;

  /**
   * Getter of whether the door has handle or not.
   *
   * @return whether the door has handle or not
   */
  public boolean isHandleIncludedFlag() {
    return handleIncludedFlag;
  }

  /**
   * Setter of whether the door has handle or not.
   *
   * @param handleIncludedFlag whether the door has handle or not
   */
  protected void setHandleIncludedFlag(final boolean handleIncludedFlag) {
    this.handleIncludedFlag = handleIncludedFlag;
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
    final String comment = "Remember to buy door hinges, Wall fixture attachment for earthquake safety and cabinet corner feet.";
    String handle = "";
    if (!handleIncludedFlag) {
      handle = "Remember to buy door handles.";
    }
    final String result = comment + handle;
    return result;
  }

  /**
   * Constructor of the Door class.
   *
   * @param furnitureColor furniture's color
   */
  public AbstractDoor(final FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Compare two solver.ResponseSolver object.
   *
   * @param o solver.ResponseSolver object
   * @return true if two object are the same.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractDoor)) {
      return false;
    }
    final AbstractDoor abstractDoor = (AbstractDoor) o;
    return isHandleIncludedFlag() == abstractDoor.isHandleIncludedFlag() &&
        super.equals(o);
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(isHandleIncludedFlag(), super.hashCode());
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
        '}' + super.toString();
  }
}
