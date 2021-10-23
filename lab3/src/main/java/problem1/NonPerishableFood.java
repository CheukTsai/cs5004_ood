package problem1;

/**
 * A abstract class NonPerishableFood that inherits from its parent class of AbstractFoodItem.
 */
public abstract class NonPerishableFood extends Food {

  /**
   * Constructs a NonPerishableFood
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public NonPerishableFood(String name, Double currentPricePerUnit,
      Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
    MAX_QUANTITY = 250;
  }
}
