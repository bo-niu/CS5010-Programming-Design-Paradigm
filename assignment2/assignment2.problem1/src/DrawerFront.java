import java.util.Objects;

/**
 * DrawerFront Furniture class.
 */
public abstract class DrawerFront extends Furniture {

  private boolean handleIncludedFlag;
  private int depth;

  public boolean isHandleIncludedFlag() {
    return handleIncludedFlag;
  }

  protected void setHandleIncludedFlag(boolean handleIncludedFlag) {
    this.handleIncludedFlag = handleIncludedFlag;
  }

  protected void setDepth(int depth) {
    this.depth = depth;
  }

  public int getDepth() {
    return depth;
  }

  public DrawerFront(FurnitureColor furnitureColor) {
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
    if (!(o instanceof DrawerFront)) {
      return false;
    }
    DrawerFront that = (DrawerFront) o;
    return isHandleIncludedFlag() == that.isHandleIncludedFlag() &&
        getDepth() == that.getDepth();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(isHandleIncludedFlag(), getDepth());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "DrawerFront{" +
        "handleIncludedFlag=" + handleIncludedFlag +
        ", depth=" + depth +
        '}';
  }
}