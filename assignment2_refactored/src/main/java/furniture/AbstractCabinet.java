package furniture;

import java.util.Objects;

/**
 * Cabinet Furniture class.
 */
public abstract class AbstractCabinet extends AbstractFurniture {

  private MountedType mountedType;
  private int depth;
  private int shelfNum;
  private int drawerNum;

  /**
   * Constructor of the Cabinet class.
   *
   * @param furnitureColor furniture color
   * @param mountedType    mounted type
   * @param shelfNum       shelf number
   * @param drawerNum      drawer number
   */
  public AbstractCabinet(final FurnitureColor furnitureColor,
      final MountedType mountedType, final int shelfNum, final int drawerNum) {
    super(furnitureColor);

    this.mountedType = mountedType;
    this.shelfNum = shelfNum;
    this.drawerNum = drawerNum;
  }

  /**
   * Getter of the mounted type.
   *
   * @return mounted type
   */
  public MountedType getMountedType() {
    return mountedType;
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
   * Getter of the shelf number.
   *
   * @return shelf number
   */
  public int getShelfNum() {
    return shelfNum;
  }

  /**
   * Getter of the drawer number.
   *
   * @return drawer number
   */
  public int getDrawerNum() {
    return drawerNum;
  }

  /**
   * Setter of the mounted type.
   *
   * @param mountedType mounted type
   */
  public void setMountedType(final MountedType mountedType) {
    this.mountedType = mountedType;
  }

  /**
   * Setter of the shelf number.
   *
   * @param shelfNum shelf number
   */
  public void setShelfNum(final int shelfNum) {
    this.shelfNum = shelfNum;
  }

  /**
   * Setter of the drawer number.
   *
   * @param drawerNum drawer number
   */
  public void setDrawerNum(final int drawerNum) {
    this.drawerNum = drawerNum;
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
   * Compare two solver.ResponseSolver object.
   *
   * @param object solver.ResponseSolver object
   * @return true if two object are the same.
   */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof AbstractCabinet)) {
      return false;
    }
    final AbstractCabinet abstractCabinet = (AbstractCabinet) object;
    return getDepth() == abstractCabinet.getDepth() &&
        getShelfNum() == abstractCabinet.getShelfNum() &&
        getDrawerNum() == abstractCabinet.getDrawerNum() &&
        getMountedType() == abstractCabinet.getMountedType() &&
        super.equals(object);
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMountedType().toString(), getDepth(), getShelfNum(), getDrawerNum(),
        super.hashCode());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Cabinet{" +
        "mountedType=" + mountedType +
        ", depth=" + depth +
        ", shelfNum=" + shelfNum +
        ", drawerNum=" + drawerNum +
        '}' + super.toString();
  }
}
