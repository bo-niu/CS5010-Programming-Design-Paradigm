import java.util.Objects;

/**
 * Furniture class, super class of all concrete furnitures.
 */
public abstract class Furniture {

  private int width;
  private int height;
  private FurnitureColor furnitureColor;
  private int price;

  public abstract String getJsonInfo();

  public abstract String getCommentInfo();

  public abstract boolean isValid();

  public int getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public FurnitureColor getFurnitureColor() {
    return furnitureColor;
  }

  public int getPrice() {
    return price;
  }

  protected void setWidth(int width) {
    this.width = width;
  }

  public void setFurnitureColor(FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
  }

  protected void setHeight(int height) {
    this.height = height;
  }

  public Furniture(FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
    this.price = price;
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
    if (!(o instanceof Furniture)) {
      return false;
    }
    Furniture furniture = (Furniture) o;
    return getWidth() == furniture.getWidth() &&
        getHeight() == furniture.getHeight() &&
        getPrice() == furniture.getPrice() &&
        getFurnitureColor() == furniture.getFurnitureColor();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWidth(), getHeight(), getFurnitureColor(), getPrice());
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Furniture{" +
        "width=" + width +
        ", height=" + height +
        ", furnitureColor=" + furnitureColor +
        ", price=" + price +
        '}';
  }
}
