package problem1;

/**
 * A concrete class Vegetable that inherits from its parent class of PerishableFood
 */
public class Vegetable extends PerishableFood{

  /**
   * Constructs a Vegetable
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Vegetable(String name, Double currentPricePerUnit,
      Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }
}
