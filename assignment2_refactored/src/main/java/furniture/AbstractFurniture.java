package furniture;

import java.util.Objects;

/**
 * Furniture class, super class of all concrete furnitures.
 */
public abstract class AbstractFurniture {

  private int width;
  private int height;
  private FurnitureColor furnitureColor;
  private int price;

  /**
   * Constructor.
   *
   * @param furnitureColor furniture's color
   */
  public AbstractFurniture(final FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
  }

  /**
   * Get concrete furniture name part in the output json file.
   *
   * @return concrete furniture name
   */
  public abstract String getJsonInfo();

  /**
   * Get the additional information related the object that is easy for customers to forget. Used to
   * remind customers when the object is in the recommendation list. This part makes up the comments
   * field in the output json file.
   *
   * @return additional information related the object
   */
  public abstract String getCommentInfo();

  /**
   * when using some loops to create some objects of its concrete extended class, some of the
   * objected created might be invalid since for example this class doesn't have some specific
   * color. Therefore, this function is used to check whether the object created is valid or not.
   *
   * @return true if the object is valid
   */
  public abstract boolean isValid();

  /**
   * Getter of the width.
   *
   * @return width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter of the height.
   *
   * @return height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter of the price.
   *
   * @param price price
   */
  public void setPrice(final int price) {
    this.price = price;
  }

  /**
   * Getter of the furniture's color
   *
   * @return furniture's color
   */
  public FurnitureColor getFurnitureColor() {
    return furnitureColor;
  }

  /**
   * Getter of the price.
   *
   * @return price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Setter of the width.
   *
   * @param width width
   */
  public void setWidth(final int width) {
    this.width = width;
  }

  /**
   * Setter of the furniture's color.
   *
   * @param furnitureColor furniture's color
   */
  public void setFurnitureColor(final FurnitureColor furnitureColor) {
    this.furnitureColor = furnitureColor;
  }

  /**
   * Setter of the height.
   *
   * @param height height
   */
  public void setHeight(final int height) {
    this.height = height;
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
    if (!(o instanceof AbstractFurniture)) {
      return false;
    }
    final AbstractFurniture abstractFurniture = (AbstractFurniture) o;
    return getWidth() == abstractFurniture.getWidth() &&
        getHeight() == abstractFurniture.getHeight() &&
        getPrice() == abstractFurniture.getPrice() &&
        getFurnitureColor() == abstractFurniture.getFurnitureColor();
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWidth(), getHeight(), getFurnitureColor().toString(), getPrice());
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
