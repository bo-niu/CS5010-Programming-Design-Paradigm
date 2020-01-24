import java.util.Objects;

/**
 * Store cabinet information of the json file.
 */
public class JsonInput_Cabinet {

  private int drawerNum;
  private int height;
  private int width;
  private int budget;
  private int depth;
  private int shelfNum;
  private FurnitureColor furnitureColor;
  private MountedType mountedType;
  private boolean workFlag;

  public boolean isWorkFlag() {
    return workFlag;
  }

  public void setWorkFlag(boolean workFlag) {
    this.workFlag = workFlag;
  }

  public JsonInput_Cabinet() {
    workFlag = false;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public int getDrawerNum() {
    return drawerNum;
  }

  public void setDrawerNum(int drawerNum) {
    this.drawerNum = drawerNum;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public int getShelfNum() {
    return shelfNum;
  }

  public void setShelfNum(int shelfNum) {
    this.shelfNum = shelfNum;
  }

  public FurnitureColor getFurnitureColor() {
    return furnitureColor;
  }

  public void setFurnitureColor(FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
  }

  public MountedType getMountedType() {
    return mountedType;
  }

  public void setMountedType(MountedType mountedType) {
    this.mountedType = mountedType;
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
    if (!(o instanceof JsonInput_Cabinet)) {
      return false;
    }
    JsonInput_Cabinet that = (JsonInput_Cabinet) o;
    return getDrawerNum() == that.getDrawerNum() &&
        getHeight() == that.getHeight() &&
        getWidth() == that.getWidth() &&
        getBudget() == that.getBudget() &&
        getDepth() == that.getDepth() &&
        getShelfNum() == that.getShelfNum() &&
        isWorkFlag() == that.isWorkFlag() &&
        getFurnitureColor() == that.getFurnitureColor() &&
        getMountedType() == that.getMountedType();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(getDrawerNum(), getHeight(), getWidth(), getBudget(), getDepth(), getShelfNum(),
            getFurnitureColor(), getMountedType(), isWorkFlag());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "JsonInput_Cabinet{" +
        "drawerNum=" + drawerNum +
        ", height=" + height +
        ", width=" + width +
        ", budget=" + budget +
        ", depth=" + depth +
        ", shelfNum=" + shelfNum +
        ", furnitureColor=" + furnitureColor +
        ", mountedType=" + mountedType +
        ", workFlag=" + workFlag +
        '}';
  }
}
