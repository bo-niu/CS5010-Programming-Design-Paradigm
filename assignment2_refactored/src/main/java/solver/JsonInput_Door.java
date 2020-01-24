package solver;

import java.util.Objects;
import furniture.*;

/**
 * Store door information of the json file.
 */
public class JsonInput_Door {

  private int height;
  private int width;
  private int budget;
  private FurnitureColor furnitureColor;
  private boolean workFlag;

  /**
   * Constructor of the JsonInput_Door class.
   *
   * @param height         height
   * @param width          width
   * @param budget         budget
   * @param furnitureColor furniture color
   * @param workFlag       whether the customer wants a door (which is whether the input json
   *                       contains door keyword)
   */
  public JsonInput_Door(final int height, final int width, final int budget,
      final FurnitureColor furnitureColor, final boolean workFlag) {
    this.height = height;
    this.width = width;
    this.budget = budget;
    this.furnitureColor = furnitureColor;
    this.workFlag = workFlag;
  }

  /**
   * Constructor.
   */
  public JsonInput_Door() {
    this.workFlag = false;
    this.furnitureColor = FurnitureColor.BROWN;
  }

  /**
   * Getter of the work flag. If the input json file indicates that the customer wants a door with
   * some desired configurations, then the workFlag will be set to true, otherwise false.
   *
   * @return work flag
   */
  public boolean isWorkFlag() {
    return workFlag;
  }

  /**
   * Setter of the work flag. If the input json file indicates that the customer wants a door with
   * some desired configurations, then the workFlag should be set to true, otherwise false.
   *
   * @param workFlag work flag
   */
  public void setWorkFlag(final boolean workFlag) {
    this.workFlag = workFlag;
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
    if (!(o instanceof JsonInput_Door)) {
      return false;
    }
    final JsonInput_Door that = (JsonInput_Door) o;
    return getHeight() == that.getHeight() &&
        getWidth() == that.getWidth() &&
        getBudget() == that.getBudget() &&
        isWorkFlag() == that.isWorkFlag() &&
        getFurnitureColor() == that.getFurnitureColor();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(getHeight(), getWidth(), getBudget(), getFurnitureColor().toString(), isWorkFlag());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "JsonInput_Door{" +
        "height=" + height +
        ", width=" + width +
        ", budget=" + budget +
        ", furnitureColor=" + furnitureColor +
        ", workFlag=" + workFlag +
        '}';
  }
}
