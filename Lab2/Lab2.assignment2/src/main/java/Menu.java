import java.util.List;
import java.util.Objects;

/**
 * Menu class contains information about the restaurant's meals, desserts. beverages, and drinks.
 */
public class Menu {

  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;

  /**
   * Constructor of the Menu class.
   *
   * @param meals     the restaurant's meals
   * @param desserts  the restaurant's desserts
   * @param beverages the restaurant's beverages
   * @param drinks    the restaurant's drinks
   */
  public Menu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   * Whether or not this object is equal to the other object.
   *
   * @param o the other object
   * @return true if two object is equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Menu)) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(meals, menu.meals) &&
        Objects.equals(desserts, menu.desserts) &&
        Objects.equals(beverages, menu.beverages) &&
        Objects.equals(drinks, menu.drinks);
  }

  /**
   * Hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(meals, desserts, beverages, drinks);
  }

  /**
   * The object's string form.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Menu{" +
        "meals=" + meals +
        ", desserts=" + desserts +
        ", beverages=" + beverages +
        ", drinks=" + drinks +
        '}';
  }

  /**
   * Getter of the the restaurant's meals.
   *
   * @return the restaurant's meals
   */
  public List<String> getMeals() {
    return meals;
  }

  /**
   * Setter of the restaurant's meals.
   *
   * @param meals the restaurant's meals
   */
  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  /**
   * Getter of the restaurant's desserts.
   *
   * @return the restaurant's desserts
   */
  public List<String> getDesserts() {
    return desserts;
  }

  /**
   * Setter of the restaurant's desserts.
   *
   * @param desserts the restaurant's desserts
   */
  public void setDesserts(List<String> desserts) {
    this.desserts = desserts;
  }

  /**
   * Getter of the restaurant's beverages.
   *
   * @return the restaurant's beverages
   */
  public List<String> getBeverages() {
    return beverages;
  }

  /**
   * Setter of the restaurant's beverages.
   *
   * @param beverages the restaurant's beverages
   */
  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  /**
   * Getter of the restaurant's drinks.
   *
   * @return the restaurant's drinks
   */
  public List<String> getDrinks() {
    return drinks;
  }

  /**
   * Setter of the restaurant's drinks.
   *
   * @param drinks the restaurant's drinks
   */
  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }
}
