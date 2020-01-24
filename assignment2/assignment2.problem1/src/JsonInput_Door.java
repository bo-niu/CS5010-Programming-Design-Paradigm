import java.util.Objects;

/**
 * Store door information of the json file.
 */
public class JsonInput_Door {

  private int height;
  private int width;
  private int budget;
  private FurnitureColor furnitureColor;
  private boolean workFlag;

  public boolean isWorkFlag() {
    return workFlag;
  }

  public void setWorkFlag(boolean workFlag) {
    this.workFlag = workFlag;
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

  public FurnitureColor getFurnitureColor() {
    return furnitureColor;
  }

  public void setFurnitureColor(FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
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
    if (!(o instanceof JsonInput_Door)) {
      return false;
    }
    JsonInput_Door that = (JsonInput_Door) o;
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
    return Objects.hash(getHeight(), getWidth(), getBudget(), getFurnitureColor(), isWorkFlag());
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
