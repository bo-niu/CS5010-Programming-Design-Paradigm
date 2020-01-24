import java.util.Objects;

/**
 * Cabinet Furniture class.
 */
public abstract class Cabinet extends Furniture {

  private MountedType mountedType;
  private int depth;
  private int shelfNum;
  private int drawerNum;

  public MountedType getMountedType() {
    return mountedType;
  }

  public double getDepth() {
    return depth;
  }

  public int getShelfNum() {
    return shelfNum;
  }

  public int getDrawerNum() {
    return drawerNum;
  }

  public void setMountedType(MountedType mountedType) {
    this.mountedType = mountedType;
  }

  public void setShelfNum(int shelfNum) {
    this.shelfNum = shelfNum;
  }

  public void setDrawerNum(int drawerNum) {
    this.drawerNum = drawerNum;
  }

  protected void setDepth(int depth) {
    this.depth = depth;
  }

  public Cabinet(FurnitureColor furnitureColor,
      MountedType mountedType, int shelfNum, int drawerNum) {
    super(furnitureColor);

    this.mountedType = mountedType;
    this.shelfNum = shelfNum;
    this.drawerNum = drawerNum;
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
    if (!(o instanceof Cabinet)) {
      return false;
    }
    Cabinet cabinet = (Cabinet) o;
    return getDepth() == cabinet.getDepth() &&
        getShelfNum() == cabinet.getShelfNum() &&
        getDrawerNum() == cabinet.getDrawerNum() &&
        getMountedType() == cabinet.getMountedType();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMountedType(), getDepth(), getShelfNum(), getDrawerNum());
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
        '}';
  }
}
