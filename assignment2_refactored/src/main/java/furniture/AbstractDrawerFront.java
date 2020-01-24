package furniture;

import java.util.Objects;

/**
 * DrawerFront Furniture class.
 */
public abstract class AbstractDrawerFront extends AbstractFurniture {

  private boolean handleIncludedFlag;
  private int depth;

  /**
   * Whether the drawer front has a handle included.
   *
   * @return true if it has a handle
   */
  public boolean isHandleIncludedFlag() {
    return handleIncludedFlag;
  }

  /**
   * Setter of Whether the drawer front has a handle included.
   *
   * @param handleIncludedFlag Whether the drawer front has a handle included.
   */
  protected void setHandleIncludedFlag(final boolean handleIncludedFlag) {
    this.handleIncludedFlag = handleIncludedFlag;
  }

  /**
   * Setter of the depth.
   *
   * @param depth depth
   */
  protected void setDepth(final int depth) {
    this.depth = depth;
  }

  /**
   * Getter of the depth.
   *
   * @return depth
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Constructor of the DrawerFront class.
   *
   * @param furnitureColor furniture's color
   */
  public AbstractDrawerFront(final FurnitureColor furnitureColor) {
    super(furnitureColor);
  }

  /**
   * Compare two solver.ResponseSolver objects.
   *
   * @param o solver.ResponseSolver object
   * @return true if two object are the same.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractDrawerFront)) {
      return false;
    }
    final AbstractDrawerFront that = (AbstractDrawerFront) o;
    return isHandleIncludedFlag() == that.isHandleIncludedFlag() &&
        getDepth() == that.getDepth() &&
        super.equals(o);
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(isHandleIncludedFlag(), getDepth(), super.hashCode());
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
        '}' + super.toString();
  }
}