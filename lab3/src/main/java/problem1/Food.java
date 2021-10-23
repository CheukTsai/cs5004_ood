package problem1;

/**
 * An abstract class that implements from the interface of FoodItem.
 */
public abstract class Food implements Ifood {
  protected String name;
  protected Double currentPricePerUnit;
  protected Integer currentAvailableQuantity;
  protected static Integer MAX_QUANTITY;

  /**
   * Constructs a Food
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Food(String name, Double currentPricePerUnit,
      Integer currentAvailableQuantity) {
    this.name = name;
    this.currentPricePerUnit = currentPricePerUnit;
    this.currentAvailableQuantity = currentAvailableQuantity;
  }

}
