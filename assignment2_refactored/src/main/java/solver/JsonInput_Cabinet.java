package solver;

import java.util.Objects;
import furniture.*;

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

  /**
   * Constructor of the JsonInput_Cabinet class.
   *
   * @param drawerNum      drawer number
   * @param height         height
   * @param width          width
   * @param budget         budget
   * @param depth          depth
   * @param shelfNum       shelf number
   * @param furnitureColor furniture color
   * @param mountedType    mounted type
   * @param workFlag       whether the customer wants a cabinet (which is whether the input json
   *                       contains cabinet keyword)
   */
  public JsonInput_Cabinet(final int height, final int width, final int depth, final int budget,
      final int shelfNum,
      final int drawerNum,
      final FurnitureColor furnitureColor, final MountedType mountedType, final boolean workFlag) {
    this.drawerNum = drawerNum;
    this.height = height;
    this.width = width;
    this.budget = budget;
    this.depth = depth;
    this.shelfNum = shelfNum;
    this.furnitureColor = furnitureColor;
    this.mountedType = mountedType;
    this.workFlag = workFlag;
  }

  /**
   * Getter of the work flag. If the input json file indicates that the customer wants a cabinet
   * with some desired configurations, then the workFlag will be set to true, otherwise false.
   *
   * @return work flag
   */
  public boolean isWorkFlag() {
    return workFlag;
  }

  /**
   * Setter of the work flag. If the input json file indicates that the customer wants a cabinet
   * with some desired configurations, then the workFlag should be set to true, otherwise false.
   *
   * @param workFlag work flag
   */
  public void setWorkFlag(final boolean workFlag) {
    this.workFlag = workFlag;
  }

  /**
   * Constructor of the JsonInput_Cabinet class.
   */
  public JsonInput_Cabinet() {
    this.furnitureColor = FurnitureColor.BROWN;
    this.mountedType = MountedType.FLOOR;
    workFlag = false;
  }

  /**
   * Getter of the desired depth.
   *
   * @return desired depth
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Setter of the desired depth.
   *
   * @param depth desired depth
   */
  public void setDepth(final int depth) {
    this.depth = depth;
  }

  /**
   * Getter of the desired drawer number.
   *
   * @return desired drawer number
   */
  public int getDrawerNum() {
    return drawerNum;
  }

  /**
   * Setter of the desired drawer number.
   *
   * @param drawerNum desired drawer number
   */
  public void setDrawerNum(final int drawerNum) {
    this.drawerNum = drawerNum;
  }

  /**
   * Getter of the desired height.
   *
   * @return desired height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter of the desired height.
   *
   * @param height desired height.
   */
  public void setHeight(final int height) {
    this.height = height;
  }

  /**
   * Getter of the desired width.
   *
   * @return desired width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Setter of the desired width.
   *
   * @param width desired width
   */
  public void setWidth(final int width) {
    this.width = width;
  }

  /**
   * Getter of the highest budget.
   *
   * @return highest budget
   */
  public int getBudget() {
    return budget;
  }

  /**
   * Setter of the highest budget.
   *
   * @param budget highest budget
   */
  public void setBudget(final int budget) {
    this.budget = budget;
  }

  /**
   * Getter of the desired shelf number.
   *
   * @return desired shelf number
   */
  public int getShelfNum() {
    return shelfNum;
  }

  /**
   * Setter of the desired shelf number.
   *
   * @param shelfNum desired shelf number
   */
  public void setShelfNum(final int shelfNum) {
    this.shelfNum = shelfNum;
  }

  /**
   * Getter of the desired furniture color.
   *
   * @return desired furniture color
   */
  public FurnitureColor getFurnitureColor() {
    return furnitureColor;
  }

  /**
   * Setter of the desired furniture color.
   *
   * @param furnitureColor desired furniture color
   */
  public void setFurnitureColor(final FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
  }

  /**
   * Getter of the desired mounted type.
   *
   * @return desired mounted type
   */
  public MountedType getMountedType() {
    return mountedType;
  }

  /**
   * Setter of the desired mounted type.
   *
   * @param mountedType desired mounted type
   */
  public void setMountedType(final MountedType mountedType) {
    this.mountedType = mountedType;
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
            getFurnitureColor().toString(), getMountedType().toString(), isWorkFlag());
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
